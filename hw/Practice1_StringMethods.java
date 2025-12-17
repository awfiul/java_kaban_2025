package hw;

public class Practice1_StringMethods {

    public static void main(String[] args) {

        String text = "Дарья изучает Java";

        System.out.println(text.startsWith("Дарья"));
        System.out.println(text.endsWith("Java"));
        System.out.println(text.indexOf("Java"));
        System.out.println(text.lastIndexOf("а"));
        System.out.println(text.repeat(2));
        System.out.println(text.isEmpty());
        System.out.println(text.replace("Java", "ООП"));
        System.out.println(text.substring(0, 6));
        System.out.println(text.toCharArray().length);
        System.out.println(text.compareTo("Дарья"));
    }
}

