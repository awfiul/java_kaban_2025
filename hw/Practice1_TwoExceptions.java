package hw;

public class Practice1_TwoExceptions {

    public static void main(String[] args) {

        try {
            safeOperation();
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException обработан");
        }

        // Это исключение не перехватывается
        dangerousOperation();

        System.out.println("Эта строка не будет выведена");
    }

    static void safeOperation() {
        int a = 10 / 0;
    }

    static void dangerousOperation() {
        String text = null;
        text.length(); // NullPointerException
    }
}
