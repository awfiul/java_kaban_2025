package hw;

public class PrimitiveTypesPractice {

    // Членами класса можно сделать любые примитивы — здесь они будут иметь нулевые значения
    byte memberByte;
    short memberShort;
    int memberInt;
    long memberLong;
    float memberFloat;
    double memberDouble;
    char memberChar;
    boolean memberBoolean;

    public static void main(String[] args) {

        // ============================
        // Практика #1 — примеры всех примитивов
        // ============================

        byte x1 = 0;
        short x2 = 0;
        int x3 = 0;
        long x4 = 0L;
        float x5 = 0.0f;
        double x6 = 0.0;
        char x7 = '\u0000'; // нулевой символ Unicode
        boolean x8 = false;

        System.out.println("byte: " + x1);
        System.out.println("short: " + x2);
        System.out.println("int: " + x3);
        System.out.println("long: " + x4);
        System.out.println("float: " + x5);
        System.out.println("double: " + x6);
        System.out.println("char: " + (int)x7);
        System.out.println("boolean: " + x8);


        // ============================
        // Практика #2 — вывод имени Дарья через Unicode
        // ============================

        // Дарья → \u0414\u0430\u0440\u044C\u044f
        System.out.println("\u0414\u0430\u0440\u044C\u044f");


        // ============================
        // Практика #3 — область видимости локальных переменных
        // ============================

        int a = 3;
        {
            int b = 7;
        }

        // int c = a + b; // Ошибка: b недоступна вне блока
        // Переменная b уничтожена после выхода из {}

        // Чтобы продемонстрировать корректный вариант:
        int c;
        {
            int b2 = 7;
            c = a + b2;
        }
        System.out.println("Корректное c: " + c);


        // ============================
        // Практика #4 — перегруженный оператор + для String
        // ============================

        String s = "Возраст: ";
        int age = 25;
        double weight = 52.7;
        Object obj = new Object();

        String result = s + age + ", вес: " + weight + ", объект: " + obj;
        System.out.println(result);


        // ============================
        // Практика #5 — примеры расширяющих преобразований
        // ============================

        byte b1 = 12;
        int sum1 = b1 + 100;      // byte + int → int
        double sum2 = sum1 + 1.5; // int + double → double

        System.out.println(sum1);
        System.out.println(sum2);


        // ============================
        // Практика #6 — примеры сужающих преобразований
        // ============================

        int big = 256;
        byte narrowed1 = (byte) big; // переполнение
        double dbl = 123.99;
        int narrowed2 = (int) dbl;   // дробная часть отбрасывается

        System.out.println(narrowed1);
        System.out.println(narrowed2);


        // ============================
        // Практика #7 — объяснение результата
        // ============================

        int a2 = 120;

        // byte b = a2 + 10;  // ошибка: результат выражения — int (130), требует явного приведения
        byte b3 = (byte)(a2 + 10); // 120 + 10 = 130 → переполнение даёт -126
        byte d3 = (byte)(a2 + 1);  // 120 + 1 = 121 (в пределах byte)

        System.out.println("c = (byte)(a2 + 10) = " + b3);
        System.out.println("d = (byte)(a2 + 1)  = " + d3);


        // ============================
        // Практика #8 — смысл type interface + пример var
        // ============================

        /*
        type interface:
        Компилятор выводит тип переменной на основе её значения.
        В Java это относится к ключевому слову var.
        var не является типом, это синтаксический сахар.
        */

        var number = 150;        // тип int
        var message = "Дарья";   // тип String
        var flag = true;         // тип boolean

        System.out.println(number);
        System.out.println(message);
        System.out.println(flag);
    }
}
