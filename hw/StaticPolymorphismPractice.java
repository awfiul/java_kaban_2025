package hw;

public class StaticPolymorphismPractice {

    public static void main(String[] args) {

        Parent parent = new Parent();
        Parent child = new Child();

        // Вызовы статических методов
        Parent.print();
        Child.print();

        // Вызов через ссылку родительского типа
        parent.print();
        child.print();
    }
}

class Parent {

    public static void print() {
        System.out.println("Parent.print()");
    }
}

class Child extends Parent {

    // Это НЕ переопределение, а сокрытие метода
    public static void print() {
        System.out.println("Child.print()");
    }
}
