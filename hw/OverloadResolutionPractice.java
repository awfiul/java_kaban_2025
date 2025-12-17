package hw;

public class OverloadResolutionPractice {

    public static void main(String[] args) {

        Printer printer = new Printer();

        Number[] values = {
                Integer.valueOf(1),
                11,
                1.5f,
                11.5
        };

        // (1) Вызов в цикле for-each
        for (Number val : values) {
            printer.print(val);
        }

        System.out.println("-----");

        // (2) Прямые вызовы с теми же значениями
        printer.print(Integer.valueOf(1));
        printer.print(11);
        printer.print(1.5f);
        printer.print(11.5);
    }
}

class Printer {

    public void print(Integer value) {
        System.out.println("Integer = " + value);
    }

    public void print(int value) {
        System.out.println("int = " + value);
    }

    public void print(Float value) {
        System.out.println("Float = " + value);
    }

    public void print(Number value) {
        System.out.println("Number = " + value);
    }
}
