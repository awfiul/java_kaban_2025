package hw;

public class StringMethodsDemo {

    public static void main(String[] args) {

        String value = "  Java Is Powerful  ";

        // length() — длина строки
        int length = value.length();

        // trim() — удаление пробелов по краям
        String trimmed = value.trim();

        // toUpperCase() — верхний регистр
        String upper = trimmed.toUpperCase();

        // toLowerCase() — нижний регистр
        String lower = trimmed.toLowerCase();

        // charAt(int) — символ по индексу
        char ch = trimmed.charAt(0);

        // substring(int) — подстрока с позиции
        String sub1 = trimmed.substring(5);

        // substring(int, int) — подстрока по диапазону
        String sub2 = trimmed.substring(0, 4);

        // replace(String, String) — замена
        String replaced = trimmed.replace("Java", "Scala");

        // contains(String) — проверка вхождения
        boolean contains = trimmed.contains("Power");

        // equalsIgnoreCase(String) — сравнение без учета регистра
        boolean equalsIgnore = trimmed.equalsIgnoreCase("java is powerful");

        System.out.println(length);
        System.out.println(trimmed);
        System.out.println(upper);
        System.out.println(lower);
        System.out.println(ch);
        System.out.println(sub1);
        System.out.println(sub2);
        System.out.println(replaced);
        System.out.println(contains);
        System.out.println(equalsIgnore);
    }
}
