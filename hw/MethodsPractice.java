package hw;

public class MethodsPractice {

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        // Перегрузка методов (overloading)
        System.out.println(calc.sum(2, 3));
        System.out.println(calc.sum(2, 3, 4));
        System.out.println(calc.sum(2.5, 3.5));

        // Переопределение методов (overriding)
        Animal animal = new Animal();
        Animal dog = new Dog();

        animal.makeSound();
        dog.makeSound(); // вызывается версия подкласса
    }
}

/*
Пример перегрузки методов.
Методы имеют одинаковое имя, но разные параметры.
*/
class Calculator {

    public int sum(int a, int b) {
        return a + b;
    }

    public int sum(int a, int b, int c) {
        return a + b + c;
    }

    public double sum(double a, double b) {
        return a + b;
    }

    // Метод без возвращаемого значения
    public void reset() {
        // здесь могла бы быть логика сброса
        return;
    }
}

/*
Суперкласс
*/
class Animal {

    public void makeSound() {
        System.out.println("Животное издает звук");
    }
}

/*
Подкласс переопределяет метод суперкласса
*/
class Dog extends Animal {

    @Override
    public void makeSound() {
        System.out.println("Собака лает");
    }
}
