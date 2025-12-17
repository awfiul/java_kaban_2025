package hw;

public class ExceptionFlowDemo {

    public static void main(String[] args) {

        try {
            levelOne();
        } catch (IllegalStateException e) {
            System.out.println("Исключение перехвачено в main()");
        }
    }

    static void levelOne() {
        levelTwo();
    }

    static void levelTwo() {
        throw new IllegalStateException("Ошибка состояния");
    }
}
