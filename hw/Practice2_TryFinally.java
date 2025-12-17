package hw;

public class Practice2_TryFinally {

    public static void main(String[] args) {

        try {
            System.out.println("Код в try");
        } finally {
            System.out.println("finally выполнится всегда");
        }
    }
}
