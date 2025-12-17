package hw;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Practice1_ScannerFileRead {

    public static void main(String[] args) {

        // Scanner может работать не только с консолью,
        // но и с файлами, строками и потоками

        // Указываем путь к текстовому файлу
        File file = new File("data.txt");

        // Scanner при работе с файлом может выбросить исключение,
        // поэтому используется try-catch
        try (Scanner scanner = new Scanner(file)) {

            // hasNextLine() проверяет, есть ли следующая строка
            while (scanner.hasNextLine()) {

                // nextLine() читает строку целиком
                String line = scanner.nextLine();
                System.out.println(line);
            }

            // scanner будет закрыт автоматически,
            // так как используется try-with-resources

        } catch (FileNotFoundException e) {

            // Если файл не найден, выполнение попадет сюда
            System.out.println("Файл не найден");
        }
    }
}
