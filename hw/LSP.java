package hw;

/*
Принцип подстановки Лисков (LSP):
Объекты подкласса должны полностью заменять объекты суперкласса,
не нарушая логику программы.
*/

class Shape {
    public double area() {
        return 0;
    }
}

class Rectangle extends Shape {
    protected double width;
    protected double height;

    public Rectangle(double w, double h) {
        this.width = w;
        this.height = h;
    }

    @Override
    public double area() {
        return width * height;
    }
}

// Ошибка, нарушающая LSP: Square меняет смысл методов предка
class Square extends Rectangle {

    public Square(double side) {
        super(side, side);
    }

    // Нарушение LSP:
    // Пользователь ожидает поведение прямоугольника,
    // но квадрат вынуждает обе стороны быть равными.
    public void setSide(double side) {
        this.width = side;
        this.height = side;
    }
}

/*
Пример корректного использования LSP:
Мы отделяем интерфейс "Фигура с площадью",
а разные реализации не ломают поведение.
*/

interface Figure {
    double calcArea();
}

class Circle implements Figure {
    private final double radius;

    public Circle(double r) {
        this.radius = r;
    }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }
}

class Triangle implements Figure {
    private final double a;
    private final double b;

    public Triangle(double base, double height) {
        this.a = base;
        this.b = height;
    }

    @Override
    public double calcArea() {
        return (a * b) / 2.0;
    }
}

public class LiskovExample {
    public static void main(String[] args) {

        // Пример нарушения LSP
        Rectangle fig = new Square(10);
        // Код ожидает прямоугольник, но логика изменяется квадратом.

        // Пример корректной реализации LSP
        Figure f1 = new Circle(3);
        Figure f2 = new Triangle(4, 6);

        System.out.println("Площадь круга: " + f1.calcArea());
        System.out.println("Площадь треугольника: " + f2.calcArea());

        // Дарья использует объекты через интерфейс Figure,
        // и каждый объект корректно реализует нужное поведение.
    }
}
