package hw;

/*
Демонстрация разных типов комментариев:
- однострочные
- блочные
- документирующие javadoc-комментарии
*/

/**
 * Пример класса, для которого можно сгенерировать документацию
 * с использованием утилиты javadoc.
 *
 * @author Дарья
 * @version 2.0
 * @see java.lang.String
 */
public class JavadocPractice {

    /**
     * Метод показывает работу обычных комментариев.
     *
     * @param name имя, введённое пользователем
     * @return строка с приветствием
     */
    public String greet(String name) {

        // однострочный комментарий
        String prefix = "Здравствуйте, ";

        /*
         блочный комментарий:
         можно писать длинные пояснения,
         объяснять логику работы метода.
        */
        String text = prefix + name;

        return text;
    }

    public static void main(String[] args) {
        JavadocPractice jp = new JavadocPractice();
        System.out.println(jp.greet("Дарья"));
    }
}
