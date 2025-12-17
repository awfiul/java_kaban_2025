package hw;

public class InterfaceDefaultStaticOneFile {

    public static void main(String[] args) {

        // ===== Практика #1 =====

        Service service = new ServiceImpl();

        // Вызов default-метода через объект
        service.printInfo();

        // Вызов static-метода через имя интерфейса
        Service.printVersion();


        // ===== Практика #2 =====

        MultiService multi = new MultiService();
        multi.printInfo();
    }
}

/*
Практика #1
Интерфейс с default и static методами
*/
interface Service {

    // default-метод (имеет реализацию)
    default void printInfo() {
        System.out.println("Информация из Service");
    }

    // static-метод интерфейса
    static void printVersion() {
        System.out.println("Service version 1.0");
    }
}

/*
Класс реализует интерфейс и при желании
переопределяет default-метод
*/
class ServiceImpl implements Service {

    @Override
    public void printInfo() {
        System.out.println("Информация из ServiceImpl");
    }
}

/*
Практика #2
Два интерфейса с одинаковыми default-методами
*/
interface LoggerA {

    default void printInfo() {
        System.out.println("LoggerA.printInfo()");
    }
}

interface LoggerB {

    default void printInfo() {
        System.out.println("LoggerB.printInfo()");
    }
}

/*
Класс реализует оба интерфейса.
Без переопределения возникнет ошибка компиляции.
*/
class MultiService implements LoggerA, LoggerB {

    @Override
    public void printInfo() {
        // Явный выбор реализаций интерфейсов
        LoggerA.super.printInfo();
        LoggerB.super.printInfo();
        System.out.println("MultiService.printInfo()");
    }
}
