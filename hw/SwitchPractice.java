package hw;

public class SwitchPractice {

    public static void main(String[] args) {

        // ============================
        // Практика #1
        // Типы данных, допустимые в switch
        // ============================

        // int
        int number = 2;
        switch (number) {
            case 1:
                System.out.println("int = 1");
                break;
            case 2:
                System.out.println("int = 2");
                break;
            default:
                System.out.println("int = другое значение");
        }

        // byte
        byte b = 1;
        switch (b) {
            case 0:
                System.out.println("byte = 0");
                break;
            case 1:
                System.out.println("byte = 1");
                break;
        }

        // short
        short s = 3;
        switch (s) {
            case 3:
                System.out.println("short = 3");
                break;
        }

        // char
        char ch = 'A';
        switch (ch) {
            case 'A':
                System.out.println("char = A");
                break;
            case 'B':
                System.out.println("char = B");
                break;
        }

        // String
        String name = "Дарья";
        switch (name) {
            case "Анна":
                System.out.println("Имя Анна");
                break;
            case "Дарья":
                System.out.println("Имя Дарья");
                break;
            default:
                System.out.println("Другое имя");
        }

        // enum
        Day today = Day.FRIDAY;
        switch (today) {
            case MONDAY:
                System.out.println("Понедельник");
                break;
            case FRIDAY:
                System.out.println("Пятница");
                break;
        }


        // ============================
        // Практика #2
        // Отсутствие break
        // ============================

        int result = 0;
        int value = 2;

        switch (value) {
            case 1:
                result = 1;
                break;
            case 2:
                result = 2;
                // break отсутствует
            case 3:
                result = 3;
                break;
            default:
                result = -1;
        }

        // value == 2:
        // сначала result = 2,
        // затем выполнение "проваливается" в case 3,
        // и result перезаписывается значением 3
        System.out.println("result = " + result);
    }
}

// enum можно использовать в switch
enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY
}
