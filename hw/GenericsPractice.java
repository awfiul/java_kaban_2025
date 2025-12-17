package hw;

import java.util.ArrayList;
import java.util.List;

public class GenericsPractice {

    public static void main(String[] args) {

        // =========================
        // Практика #1
        // instanceof и generics
        // =========================

        Box<String> textBox = new Box<>("hello");
        Box<Integer> numberBox = new Box<>(10);

        // Проверка возможна только без указания параметра типа
        if (textBox instanceof Box) {
            System.out.println("textBox является экземпляром Box");
        }

        // Так делать нельзя, будет ошибка компиляции
        // if (textBox instanceof Box<String>) {}


        // =========================
        // Практика #2
        // ? extends T
        // =========================

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);

        printNumbers(intList);


        // =========================
        // ? super T
        // =========================

        List<Number> numberList = new ArrayList<>();
        addIntegers(numberList);

        System.out.println(numberList);
    }

    // Использование ? extends Number
    // Можно читать элементы как Number
    public static void printNumbers(List<? extends Number> list) {
        for (Number n : list) {
            System.out.println(n);
        }

        // list.add(10); // ошибка компиляции
    }

    // Использование ? super Integer
    // Можно безопасно добавлять Integer
    public static void addIntegers(List<? super Integer> list) {
        list.add(10);
        list.add(20);
    }
}

/*
Простой параметризованный класс
*/
class Box<T> {

    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
