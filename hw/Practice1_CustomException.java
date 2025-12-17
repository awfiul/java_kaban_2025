package hw;

public class Practice1_CustomException {

    public static void main(String[] args) {

        try {
            validateName(null);
        } catch (NameException e) {
            System.out.println("Ошибка проверки имени");
            e.printStackTrace();
        }
    }

    static void validateName(String name) throws NameException {
        if (name == null || name.isEmpty()) {
            throw new NameException("Имя не задано");
        }
    }
}

class NameException extends Exception {

    // конструктор без параметров
    public NameException() {
        super();
    }

    // конструктор с сообщением
    public NameException(String message) {
        super(message);
    }

    // конструктор с сообщением и причиной
    public NameException(String message, Throwable cause) {
        super(message, cause);
    }
}
