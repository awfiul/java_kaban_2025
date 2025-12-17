package hw;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Practice4_AutoCloseable {

    public static void main(String[] args) throws Exception {

        // AutoCloseable позволяет автоматически
        // закрывать ресурсы после try-блока

        byte[] data = {1, 2, 3};

        // try-with-resources
        // close() будет вызван автоматически
        try (InputStream input = new ByteArrayInputStream(data)) {

            int b = input.read();
            System.out.println(b);
        }

        // Здесь поток уже закрыт
    }
}
