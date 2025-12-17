package hw;

public class FinalInheritancePractice {

    public static void main(String[] args) {

        SecureService service = new SecureService();
        service.process();
    }
}

/*
Практика #1
final-метод нельзя переопределять в подклассе
*/
class BaseService {

    public final void process() {
        System.out.println("Обработка в BaseService");
    }
}

class SecureService extends BaseService {

    // Попытка переопределения приведет к ошибке компиляции
    /*
    @Override
    public void process() {
        System.out.println("Обработка в SecureService");
    }
    */
}

/*
Практика #2
final-класс нельзя наследовать
*/
final class Config {

    public void load() {
        System.out.println("Загрузка конфигурации");
    }
}

// Попытка наследования от final-класса приведет к ошибке компиляции
/*
class AppConfig extends Config {
}
*/
