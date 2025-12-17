package hw;

import java.util.Formatter;

public class FormatterDemo {

    public static void main(String[] args) {

        Formatter formatter = new Formatter();

        formatter.format("Boolean: %b%n", true);
        formatter.format("Char: %c%n", 'A');
        formatter.format("Decimal: %d%n", 125);
        formatter.format("Float: %.2f%n", 12.3456);
        formatter.format("String: %s%n", "Дарья");

        System.out.print(formatter.toString());

        formatter.close();
    }
}
