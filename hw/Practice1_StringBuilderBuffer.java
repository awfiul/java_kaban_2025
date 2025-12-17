package hw;

public class Practice1_StringBuilderBuffer {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder("Дарья");

        sb.append(" учит Java");          // добавление
        sb.insert(6, " активно");         // вставка
        sb.replace(0, 5, "Студент");      // замена
        sb.delete(0, 8);                  // удаление
        sb.reverse();                     // разворот
        sb.setLength(10);                 // изменение длины
        sb.capacity();                    // емкость
        sb.length();                      // длина
        sb.charAt(0);                     // символ
        sb.substring(1);                  // подстрока

        System.out.println(sb);

        StringBuffer sbuf = new StringBuffer("Java");

        sbuf.append(" Core");
        sbuf.insert(4, "-");
        sbuf.delete(0, 1);
        sbuf.replace(0, 3, "JVM");
        sbuf.reverse();
        sbuf.length();
        sbuf.capacity();
        sbuf.charAt(0);
        sbuf.substring(2);
        sbuf.ensureCapacity(40);

        System.out.println(sbuf);
    }
}
