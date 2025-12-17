package hw;

public class Practice1_StaticInitException {

    public static void main(String[] args) {

        // Этот код никогда не выполнится,
        // потому что ошибка возникнет раньше,
        // на этапе инициализации класса App
        System.out.println("Hello");
    }
}

class App {

    // final static поле должно быть инициализировано
    // во время загрузки класса
    final static int START_COUNTER;

    static {

        // Static-блок выполняется при загрузке класса
        // до вызова метода main()

        // Integer.parseInt("Y-") выбросит NumberFormatException,
        // так как строка не является корректным числом

        // Исключение, возникшее в static-блоке,
        // приводит к аварийному завершению программы

        START_COUNTER = Integer.parseInt("Y-");
    }
}
