package hw;

import java.util.Objects;

public class EqualsPractice {

    public static void main(String[] args) {

        Person p1 = new Person("Дарья", 20);
        Person p2 = new Person("Дарья", 20);
        Person p3 = new Person("Дарья", 21);

        System.out.println(p1.equals(p2)); // true
        System.out.println(p1.equals(p3)); // false
        System.out.println(p1.equals(null)); // false
    }
}

/*
Класс с переопределенным методом equals()
*/
class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {

        // Проверка на сравнение с самим собой
        if (this == obj) {
            return true;
        }

        // Проверка на null
        if (obj == null) {
            return false;
        }

        // Проверка, что объекты одного класса
        if (getClass() != obj.getClass()) {
            return false;
        }

        // Приведение типов
        Person other = (Person) obj;

        // Сравнение значимых полей
        return age == other.age &&
               Objects.equals(name, other.name);
    }

    /*
    При переопределении equals() обычно также переопределяют hashCode(),
    но в рамках данной практики требуется только equals().
    */
}
