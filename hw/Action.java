package hw;

/*
Интерфейс с вложенным классом
*/
public interface Action {

    void run();

    /*
    Вложенный класс в интерфейсе:
    - всегда static
    - не требует экземпляра интерфейса
    */
    class Helper {

        public void execute() {
            System.out.println("Выполнение из вложенного класса интерфейса");
        }
    }
}
