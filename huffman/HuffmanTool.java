package hw;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.PriorityQueue;

/*
CLI:
  encode:
    java hw.HuffmanTool encode <inputFile> <outputFile>

  decode:
    java hw.HuffmanTool decode <inputFile> <outputFile>

Формат файла описан в отдельном txt (см. HuffmanFormat.txt).
*/
public class HuffmanTool {

    private static final int ALPHABET_SIZE = 256;
    private static final byte[] MAGIC = new byte[] { 'H', 'U', 'F', '1' };

    public static void main(String[] args) {
        if (args == null || args.length != 3) {
            printUsage();
            System.exit(2);
        }

        String mode = args[0].trim().toLowerCase();
        Path input = Path.of(args[1]);
        Path output = Path.of(args[2]);

        try {
            if ("encode".equals(mode)) {
                encodeFile(input, output);
            } else if ("decode".equals(mode)) {
                decodeFile(input, output);
            } else {
                printUsage();
                System.exit(2);
            }
        } catch (Exception e) {
            // Для консольной утилиты достаточно показать понятное сообщение + стек для отладки
            System.err.println("Ошибка: " + e.getMessage());
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }

    private static void printUsage() {
        System.out.println("Usage:");
        System.out.println("  java hw.HuffmanTool encode <inputFile> <outputFile>");
        System.out.println("  java hw.HuffmanTool decode <inputFile> <outputFile>");
    }

    /*
    Кодирование:
    1) Считаем частоты байтов (0..255)
    2) Строим дерево Хаффмана
    3) Строим коды (длина + биты)
    4) Пишем заголовок (magic, originalSize, таблица частот)
    5) Пишем битовый поток закодированных данных
    */
    private static void encodeFile(Path input, Path output) throws IOException {
        if (!Files.exists(input)) {
            throw new IOException("Входной файл не найден: " + input);
        }

        long originalSize;
        int[] freq = new int[ALPHABET_SIZE];

        try (InputStream in = new BufferedInputStream(Files.newInputStream(input))) {
            originalSize = countFrequencies(in, freq);
        }

        Node root = buildTree(freq);
        Code[] codes = buildCodes(root);

        try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(output));
             InputStream in = new BufferedInputStream(Files.newInputStream(input))) {

            writeHeader(out, originalSize, freq);

            BitOutputStream bout = new BitOutputStream(out);

            if (originalSize == 0) {
                // Пустой файл: заголовка достаточно, битов нет
                bout.flushToByteBoundary();
                return;
            }

            int b;
            while ((b = in.read()) != -1) {
                Code c = codes[b & 0xFF];
                // В корректном дереве код обязан существовать для любого байта, встреченного во входе
                bout.writeBits(c.bits, c.length);
            }

            // Доводим до целого байта (паддинг нулями)
            bout.flushToByteBoundary();
        }
    }

    /*
    Декодирование:
    1) Читаем заголовок (magic, originalSize, таблица частот)
    2) Строим дерево Хаффмана заново (по тем же частотам)
    3) Читаем битовый поток и спускаемся по дереву, пока не восстановим originalSize байт
    */
    private static void decodeFile(Path input, Path output) throws IOException {
        if (!Files.exists(input)) {
            throw new IOException("Входной файл не найден: " + input);
        }

        try (InputStream in = new BufferedInputStream(Files.newInputStream(input));
             OutputStream out = new BufferedOutputStream(Files.newOutputStream(output))) {

            Header header = readHeader(in);

            if (header.originalSize == 0) {
                // Пустой файл: просто создаем пустой output
                return;
            }

            Node root = buildTree(header.freq);

            // Особый случай: если в файле был только один уникальный байт,
            // дерево состоит из одного листа. Тогда для восстановления достаточно просто повторить его.
            if (root.isLeaf()) {
                for (long i = 0; i < header.originalSize; i++) {
                    out.write(root.value);
                }
                return;
            }

            BitInputStream bin = new BitInputStream(in);

            long written = 0;
            Node cur = root;

            while (written < header.originalSize) {
                int bit = bin.readBit();
                if (bit == -1) {
                    throw new EOFException("Неожиданный конец файла при чтении закодированных данных");
                }

                cur = (bit == 0) ? cur.left : cur.right;

                if (cur == null) {
                    throw new IOException("Поврежденные данные: переход в null-ветку дерева");
                }

                if (cur.isLeaf()) {
                    out.write(cur.value);
                    written++;
                    cur = root;
                }
            }
        }
    }

    private static long countFrequencies(InputStream in, int[] freq) throws IOException {
        long count = 0;
        int b;
        while ((b = in.read()) != -1) {
            freq[b & 0xFF]++;
            count++;
        }
        return count;
    }

    private static Node buildTree(int[] freq) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (freq[i] > 0) {
                pq.add(Node.leaf(i, freq[i]));
            }
        }

        // Пустой файл
        if (pq.isEmpty()) {
            return Node.leaf(0, 0);
        }

        // Один уникальный байт
        if (pq.size() == 1) {
            return pq.poll();
        }

        while (pq.size() > 1) {
            Node a = pq.poll();
            Node b = pq.poll();

            Node parent = Node.internal(a, b);
            pq.add(parent);
        }

        return pq.poll();
    }

    /*
    Строим коды в виде (bits, length):
    - length: сколько бит значимо
    - bits: код упакован в int (старшие биты не используются)
    */
    private static Code[] buildCodes(Node root) {
        Code[] codes = new Code[ALPHABET_SIZE];

        if (root.isLeaf()) {
            // Если алфавит фактически из одного символа, дадим ему код длины 1: "0"
            codes[root.value] = new Code(0, 1);
            return codes;
        }

        buildCodesDfs(root, 0, 0, codes);
        return codes;
    }

    private static void buildCodesDfs(Node node, int bits, int length, Code[] out) {
        if (node.isLeaf()) {
            out[node.value] = new Code(bits, length);
            return;
        }

        // Влево пишем 0
        buildCodesDfs(node.left, (bits << 1), length + 1, out);

        // Вправо пишем 1
        buildCodesDfs(node.right, (bits << 1) | 1, length + 1, out);
    }

    /*
    Заголовок:
      MAGIC[4] = 'H''U''F''1'
      originalSize (8 байт, big-endian long)
      freq[256] (каждая 4 байта, big-endian int)
    */
    private static void writeHeader(OutputStream out, long originalSize, int[] freq) throws IOException {
        out.write(MAGIC);
        writeLong(out, originalSize);

        for (int i = 0; i < ALPHABET_SIZE; i++) {
            writeInt(out, freq[i]);
        }
    }

    private static Header readHeader(InputStream in) throws IOException {
        byte[] magic = readFully(in, 4);
        for (int i = 0; i < 4; i++) {
            if (magic[i] != MAGIC[i]) {
                throw new IOException("Неверный формат: magic не совпадает");
            }
        }

        long originalSize = readLong(in);

        int[] freq = new int[ALPHABET_SIZE];
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            freq[i] = readInt(in);
            if (freq[i] < 0) {
                throw new IOException("Неверный формат: отрицательная частота для байта " + i);
            }
        }

        return new Header(originalSize, freq);
    }

    private static void writeInt(OutputStream out, int v) throws IOException {
        out.write((v >>> 24) & 0xFF);
        out.write((v >>> 16) & 0xFF);
        out.write((v >>> 8) & 0xFF);
        out.write(v & 0xFF);
    }

    private static int readInt(InputStream in) throws IOException {
        int b1 = in.read();
        int b2 = in.read();
        int b3 = in.read();
        int b4 = in.read();
        if ((b1 | b2 | b3 | b4) < 0) {
            throw new EOFException("Неожиданный конец файла при чтении int");
        }
        return (b1 << 24) | (b2 << 16) | (b3 << 8) | b4;
    }

    private static void writeLong(OutputStream out, long v) throws IOException {
        out.write((int) ((v >>> 56) & 0xFF));
        out.write((int) ((v >>> 48) & 0xFF));
        out.write((int) ((v >>> 40) & 0xFF));
        out.write((int) ((v >>> 32) & 0xFF));
        out.write((int) ((v >>> 24) & 0xFF));
        out.write((int) ((v >>> 16) & 0xFF));
        out.write((int) ((v >>> 8) & 0xFF));
        out.write((int) (v & 0xFF));
    }

    private static long readLong(InputStream in) throws IOException {
        long b1 = in.read();
        long b2 = in.read();
        long b3 = in.read();
        long b4 = in.read();
        long b5 = in.read();
        long b6 = in.read();
        long b7 = in.read();
        long b8 = in.read();
        if ((b1 | b2 | b3 | b4 | b5 | b6 | b7 | b8) < 0) {
            throw new EOFException("Неожиданный конец файла при чтении long");
        }
        return (b1 << 56)
                | (b2 << 48)
                | (b3 << 40)
                | (b4 << 32)
                | (b5 << 24)
                | (b6 << 16)
                | (b7 << 8)
                | b8;
    }

    private static byte[] readFully(InputStream in, int n) throws IOException {
        byte[] buf = new byte[n];
        int off = 0;
        while (off < n) {
            int r = in.read(buf, off, n - off);
            if (r == -1) {
                throw new EOFException("Неожиданный конец файла при чтении " + n + " байт");
            }
            off += r;
        }
        return buf;
    }

    private static final class Header {
        final long originalSize;
        final int[] freq;

        Header(long originalSize, int[] freq) {
            this.originalSize = originalSize;
            this.freq = freq;
        }
    }

    private static final class Code {
        final int bits;
        final int length;

        Code(int bits, int length) {
            this.bits = bits;
            this.length = length;
        }
    }

    /*
    Узел дерева Хаффмана:
    - Для листа value хранит байт (0..255)
    - Для внутреннего узла value не используется
    */
    private static final class Node implements Comparable<Node> {
        final int value;
        final int freq;
        final Node left;
        final Node right;

        private Node(int value, int freq, Node left, Node right) {
            this.value = value;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        static Node leaf(int value, int freq) {
            return new Node(value, freq, null, null);
        }

        static Node internal(Node left, Node right) {
            return new Node(-1, left.freq + right.freq, left, right);
        }

        boolean isLeaf() {
            return left == null && right == null;
        }

        @Override
        public int compareTo(Node o) {
            // Чтобы дерево было воспроизводимым, добавим вторичную сортировку
            // (иначе при равных частотах порядок может отличаться).
            int c = Integer.compare(this.freq, o.freq);
            if (c != 0) {
                return c;
            }
            return Integer.compare(this.value, o.value);
        }
    }

    /*
    Запись битов в байтовый поток.
    Пишем слева направо: сначала старшие биты кода.
    */
    private static final class BitOutputStream {
        private final OutputStream out;

        private int currentByte;
        private int bitCount; // сколько бит уже записано в currentByte (0..7)

        BitOutputStream(OutputStream out) {
            this.out = out;
        }

        void writeBits(int bits, int length) throws IOException {
            // Пример: length=3, bits=0b101
            // Пишем по одному биту: 1,0,1
            for (int i = length - 1; i >= 0; i--) {
                int bit = (bits >>> i) & 1;
                writeBit(bit);
            }
        }

        void writeBit(int bit) throws IOException {
            currentByte = (currentByte << 1) | (bit & 1);
            bitCount++;

            if (bitCount == 8) {
                out.write(currentByte);
                currentByte = 0;
                bitCount = 0;
            }
        }

        void flushToByteBoundary() throws IOException {
            if (bitCount == 0) {
                out.flush();
                return;
            }

            // Дополняем нулями справа до полного байта
            int padding = 8 - bitCount;
            currentByte = currentByte << padding;
            out.write(currentByte);

            currentByte = 0;
            bitCount = 0;

            out.flush();
        }
    }

    /*
    Чтение битов из байтового потока.
    Возвращает 0/1, либо -1 если поток закончился.
    */
    private static final class BitInputStream {
        private final InputStream in;

        private int currentByte;
        private int bitsLeft; // сколько бит осталось прочитать из currentByte (0..8)

        BitInputStream(InputStream in) {
            this.in = in;
        }

        int readBit() throws IOException {
            if (bitsLeft == 0) {
                currentByte = in.read();
                if (currentByte == -1) {
                    return -1;
                }
                bitsLeft = 8;
            }

            bitsLeft--;
            return (currentByte >>> bitsLeft) & 1;
        }
    }
}
