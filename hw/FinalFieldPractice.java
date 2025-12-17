package hw;

/*
final-поле не может получить значение по умолчанию,
поэтому его обязательно нужно инициализировать
одним из допустимых способов.
*/
public class FinalFieldPractice {

    public static void main(String[] args) {

        // Инициализация через конструктор
        User u1 = new User(10);

        // Инициализация через перегруженный конструктор
        User u2 = new User();

        System.out.println(u1.id);
        System.out.println(u2.id);
    }
}

/*
Варианты инициализации final-поля:
1. При объявлении
2. В конструкторе
3. В логическом блоке инициализации
*/
class User {

    // final-поле
    public final int id;

    // Вариант 1: инициализация при объявлении
    // public final int id = 5;

    // Вариант 2: инициализация в логическом блоке
    {
        id = 1;
    }

    // Вариант 3: инициализация в конструкторе
    public User(int value) {
        id = value;
    }

    // Конструктор без параметров
    public User() {
        id = 0;
    }
}
