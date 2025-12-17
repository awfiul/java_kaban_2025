package hw;

public class InitBlocksPractice {

    public static void main(String[] args) {
        new Sample(100);
    }
}

class Sample {

    // Статический блок выполняется один раз при загрузке класса
    static {
        System.out.println("static block");
    }

    // Поле инициализируется ДО логических блоков
    private int number = 1;

    // Первый логический блок
    {
        System.out.println("logic block 1, number = " + this.number);
    }

    // Второй логический блок
    {
        System.out.println("logic block 2, number = " + number);
    }

    // Конструктор вызывается ПОСЛЕ всех логических блоков
    public Sample(int number) {
        this.number = number;
        System.out.println("constructor, number = " + number);
    }
}
