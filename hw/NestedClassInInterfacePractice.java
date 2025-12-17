package hw;

public class NestedClassInInterfacePractice {

    public static void main(String[] args) {

        // Вложенный класс в интерфейсе является static по умолчанию
        Action.Helper helper = new Action.Helper();
        helper.execute();
    }
}
