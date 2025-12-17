package hw;

public class StaticMethodsPractice {

    public static void main(String[] args) {

        // Вариант 1: вызов через имя класса (рекомендуемый способ)
        Counter.printValues();

        // Вариант 2: вызов через объект класса (допустим, но не рекомендуется)
        Counter counter = new Counter();
        counter.printValues();

        // Вариант 3: вызов из нестатического метода
        StaticMethodsPractice demo = new StaticMethodsPractice();
        demo.callFromInstance();
    }

    // Нестатический метод
    public void callFromInstance() {
        Counter.printValues();
    }
}

/*
Класс со статическими полями и статическим методом
*/
class Counter {

    public static int x = 1;
    public static int y;

    public static void printValues() {
        System.out.println(x);
        System.out.println(y);
    }
}
