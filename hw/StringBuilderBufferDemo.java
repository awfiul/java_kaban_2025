package hw;

public class StringBuilderBufferDemo {

    public static void main(String[] args) {

        StringBuilder builder = new StringBuilder("Java");

        // append(String) — добавляет строку в конец
        builder.append(" Builder");

        // insert(int, String) — вставляет строку по индексу
        builder.insert(4, "_");

        // delete(int, int) — удаляет диапазон символов
        builder.delete(4, 5);

        // replace(int, int, String) — заменяет часть строки
        builder.replace(5, 12, "String");

        // reverse() — разворачивает строку
        builder.reverse();

        // capacity() — текущая емкость буфера
        int capacity = builder.capacity();

        // length() — длина строки
        int length = builder.length();

        // charAt(int) — символ по индексу
        char ch = builder.charAt(0);

        // setCharAt(int, char) — замена символа
        builder.setCharAt(0, 'X');

        // substring(int) — получение подстроки
        String sub = builder.substring(1);

        System.out.println(builder);
        System.out.println(capacity);
        System.out.println(length);
        System.out.println(ch);
        System.out.println(sub);

        StringBuffer buffer = new StringBuffer("Thread");

        // append(String) — добавление строки
        buffer.append(" Safe");

        // deleteCharAt(int) — удаление символа
        buffer.deleteCharAt(0);

        // indexOf(String) — поиск подстроки
        int index = buffer.indexOf("Safe");

        // ensureCapacity(int) — гарантирует минимальную емкость
        buffer.ensureCapacity(50);

        System.out.println(buffer);
        System.out.println(index);
        System.out.println(buffer.capacity());
    }
}
