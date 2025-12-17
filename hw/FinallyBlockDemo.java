package hw;

public class FinallyBlockDemo {

    public static void main(String[] args) {

        try {
            int value = 10 / 2;
            System.out.println("Результат: " + value);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка деления");
        } finally {
            System.out.println("Блок finally выполнен");
        }
    }
}
