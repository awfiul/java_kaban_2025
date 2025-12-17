package hw;

public class VarArgsOverloadPractice {

    public static void main(String[] args) {

        DataPrinter printer = new DataPrinter();

        printer.printValues(1, 2, 3);
        printer.printValues("Дарья", "Анна", "Мария");

        printer.printValues("Результат:", 10, 20, 30);
    }
}

/*
Класс демонстрирует перегрузку методов
с переменным числом параметров
*/
class DataPrinter {

    // Метод принимает любое количество int
    public void printValues(int... numbers) {
        for (int n : numbers) {
            System.out.println("int: " + n);
        }
    }

    // Перегруженный метод принимает любое количество String
    public void printValues(String... texts) {
        for (String s : texts) {
            System.out.println("String: " + s);
        }
    }

    // Еще один перегруженный метод
    // первый параметр обычный, остальные — varargs
    public void printValues(String title, int... numbers) {
        System.out.println(title);
        for (int n : numbers) {
            System.out.println(n);
        }
    }
}
