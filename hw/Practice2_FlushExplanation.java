package hw;

import java.io.PrintWriter;

public class Practice2_FlushExplanation {

    public static void main(String[] args) {

        PrintWriter writer = new PrintWriter(System.out);

        writer.print("Сообщение записано во внутренний буфер");
        writer.flush(); // принудительная отправка данных из буфера в поток

        writer.println();
        writer.println("После flush данные гарантированно выведены");

        writer.close();
    }
}
    