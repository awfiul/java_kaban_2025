package hw;

public class WrappersPractice {

    public static void main(String[] args) {

        // ============================
        // Практика #1 — примеры decode()
        // ============================

        Integer d1 = Integer.decode("10");    // десятичное
        Integer d2 = Integer.decode("0x10");  // шестнадцатеричное
        Integer d3 = Integer.decode("010");   // восьмеричное

        System.out.println(d1); // 10
        System.out.println(d2); // 16
        System.out.println(d3); // 8


        // ============================
        // Практика #2 — способы создания Boolean
        // ============================

        Boolean b1 = Boolean.TRUE;
        Boolean b2 = Boolean.FALSE;

        Boolean b3 = Boolean.valueOf(true);
        Boolean b4 = Boolean.valueOf("true");
        Boolean b5 = Boolean.valueOf("false");

        boolean prim = true;
        Boolean b6 = prim; // автоупаковка

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
        System.out.println(b5);
        System.out.println(b6);


        // ============================
        // Преобразование примитива в строку
        // ============================

        int count = 42;
        String s1 = Integer.toString(count);
        String s2 = String.valueOf(count);

        System.out.println(s1);
        System.out.println(s2);


        // ============================
        // Практика #3 — NPE при автоупаковке/распаковке
        // ============================

        Integer boxed = null;

        try {
            int unboxed = boxed; // NullPointerException
            System.out.println(unboxed);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException при автораспаковке");
        }


        // ============================
        // Практика #4 — IntegerCache
        // ============================

        int n1 = 128;
        Integer x1 = n1;
        Integer y1 = n1;

        System.out.println("x1==n1 " + (x1 == n1));
        System.out.println("y1==n1 " + (y1 == n1));
        System.out.println("x1==y1 " + (x1 == y1));
        System.out.println("x1.equals(n1) -> " + x1.equals(n1));
        System.out.println("y1.equals(n1) -> " + y1.equals(n1));
        System.out.println("x1.equals(y1) -> " + x1.equals(y1));

        int n2 = 127;
        Integer x2 = n2;
        Integer y2 = n2;

        System.out.println("x2==n2 " + (x2 == n2));
        System.out.println("y2==n2 " + (y2 == n2));
        System.out.println("x2==y2 " + (x2 == y2));
        System.out.println("x2.equals(n2) -> " + x2.equals(n2));
        System.out.println("y2.equals(n2) -> " + y2.equals(n2));
        System.out.println("x2.equals(y2) -> " + x2.equals(y2));
    }
}
