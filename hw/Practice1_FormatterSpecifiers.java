package hw;

import java.util.Formatter;

public class Practice1_FormatterSpecifiers {

    public static void main(String[] args) {

        Formatter f = new Formatter();

        f.format("%% Percent sign%n");
        f.format("Boolean value: %b%n", false);
        f.format("Integer value: %d%n", 42);
        f.format("Hash code: %h%n", "Java");
        f.format("Exponential: %e%n", 123.45);

        System.out.print(f);

        f.close();
    }
}
    