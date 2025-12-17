package hw;

public class OverloadOverridePractice {

    public static void main(String[] args) {

        // ============================
        // Практика #1: перегрузка
        // ============================

        TextMaker maker = new TextMaker();
        System.out.println(maker.build("Дарья"));
        System.out.println(maker.build("Дарья", 20));
        System.out.println(maker.build("Дарья", 20, true));


        // ============================
        // Практика #2: переопределение
        // ============================

        Vehicle v1 = new Vehicle();
        Vehicle v2 = new Car();

        System.out.println(v1.info());
        System.out.println(v2.info());


        // ============================
        // Практика #3: @Override и ошибка
        // ============================

        Animal a = new Animal();
        Animal c = new Cat();

        a.voice();
        c.voice();
    }
}

/*
Практика #1
Перегруженные методы: одинаковое имя, разные параметры.
*/
class TextMaker {

    public String build(String name) {
        return "Имя: " + name;
    }

    public String build(String name, int age) {
        return "Имя: " + name + ", возраст: " + age;
    }

    public String build(String name, int age, boolean active) {
        return "Имя: " + name + ", возраст: " + age + ", активен: " + active;
    }
}

/*
Практика #2
Переопределение: совпадает имя и параметры, а реализация меняется в подклассе.
*/
class Vehicle {

    public String info() {
        return "Обычный транспорт";
    }

    /*
    Если попробовать "переопределить" метод, но изменить тип возвращаемого значения,
    то это будет ошибка компиляции, потому что сигнатура должна совпасть.

    Пример того, что НЕ скомпилируется:
      public int info() { return 1; }

    Единственный допустимый вариант, когда тип возвращаемого значения может отличаться,
    это ковариантность: возвращаемый тип в подклассе может быть подтипом.
    Например, если в суперклассе возвращается Number, то в подклассе можно вернуть Integer.
    */
}

class Car extends Vehicle {

    @Override
    public String info() {
        return "Легковой автомобиль";
    }
}

/*
Практика #3
@Override помогает обнаружить ошибку, если метод написан не так, как в суперклассе.
*/
class Animal {

    public void voice() {
        System.out.println("Животное издает звук");
    }
}

class Cat extends Animal {

    // Если здесь случайно написать voice(String s), это будет перегрузка, а не переопределение.
    // @Override сразу заставит компилятор показать ошибку.

    @Override
    public void voice() {
        System.out.println("Кошка мяукает");
    }

    /*
    Пример ошибки, которую @Override поймает:

    @Override
    public void voise() {
        System.out.println("Опечатка в имени метода");
    }

    Здесь voise не совпадает с voice, поэтому компилятор выдаст ошибку.
    */
}
