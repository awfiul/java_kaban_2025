package hw;

public class MultiCatchDemo {

    public static void main(String[] args) {

        try {
            throwHierarchyException(3);
        } catch (BaseException e) {
            System.out.println("Поймано BaseException");
        }
    }

    static void throwHierarchyException(int level) {
        if (level == 1) {
            throw new BaseException();
        } else if (level == 2) {
            throw new MiddleException();
        } else {
            throw new ChildException();
        }
    }
}

class BaseException extends RuntimeException {
}

class MiddleException extends BaseException {
}

class ChildException extends MiddleException {
}
