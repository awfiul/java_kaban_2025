package hw;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Practice1_InputStreamRead {

    public static void main(String[] args) throws Exception {

        // Создаем массив байтов
        byte[] data = {65, 66, 67};

        // ByteArrayInputStream — подкласс InputStream
        // читает данные из массива байтов
        InputStream input = new ByteArrayInputStream(data);

        int value;

        // read() возвращает байт в виде int
        // или -1, если поток закончился
        while ((value = input.read()) != -1) {
            System.out.println(value);
        }

        input.close();
    }
}
