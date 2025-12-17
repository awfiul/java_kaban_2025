package hw;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class Practice2_OutputStreamWrite {

    public static void main(String[] args) throws Exception {

        // ByteArrayOutputStream — подкласс OutputStream
        // записывает байты во внутренний буфер
        OutputStream output = new ByteArrayOutputStream();

        // write(int) записывает младший байт числа
        output.write(72);
        output.write(105);

        // Преобразуем результат в строку
        String result = output.toString();

        System.out.println(result);

        output.close();
    }
}
