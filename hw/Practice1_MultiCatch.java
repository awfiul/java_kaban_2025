package hw;

public class Practice1_MultiCatch {

    public static void main(String[] args) {

        // Несколько исключений обрабатываются одинаково
        try {
            generateException(1);
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Ошибка входных данных или состояния");
        }

        // Иерархия исключений
        try {
            throw new Level3Exception();
        } catch (Level3Exception e) {
            System.out.println("Пойман Level3Exception");
        } catch (Level2Exception e) {
            System.out.println("Пойман Level2Exception");
        } catch (Level1Exception e) {
            System.out.println("Пойман Level1Exception");
        }
    }

    static void generateException(int type) {
        if (type == 1) {
            throw new IllegalArgumentException();
        } else {
            throw new IllegalStateException();
        }
    }
}

class Level1Exception extends RuntimeException {
}

class Level2Exception extends Level1Exception {
}

class Level3Exception extends Level2Exception {
}
