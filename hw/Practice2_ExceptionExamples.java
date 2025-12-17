package hw;

public class Practice2_ExceptionExamples {

    public static void main(String[] args) {

        // ArithmeticException
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException пойман");
        }

        // ArrayIndexOutOfBoundsException
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException пойман");
        }

        // IllegalArgumentException
        try {
            setAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException пойман");
        }

        // ClassCastException
        try {
            Object obj = "text";
            Integer value = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException пойман");
        }

        // NullPointerException
        try {
            String str = null;
            str.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException пойман");
        }
    }

    private static void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
    }
}
