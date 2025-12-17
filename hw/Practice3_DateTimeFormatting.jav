package hw;

import java.util.Date;
import java.util.Formatter;

public class Practice3_DateTimeFormatting {

    public static void main(String[] args) {

        Date now = new Date();
        Formatter formatter = new Formatter();

        formatter.format("Hour (24): %tH%n", now);
        formatter.format("Minute: %tM%n", now);
        formatter.format("Second: %tS%n", now);
        formatter.format("Year: %tY%n", now);
        formatter.format("Month name: %tB%n", now);

        System.out.print(formatter);

        formatter.close();
    }
}
