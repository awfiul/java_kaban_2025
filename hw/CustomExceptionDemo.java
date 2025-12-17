package hw;

public class CustomExceptionDemo {

    public static void main(String[] args) {

        try {
            checkScore(-10);
        } catch (ScoreException e) {
            System.out.println("Поймано пользовательское исключение");
            System.out.println(e.getMessage());
        }
    }

    static void checkScore(int score) throws ScoreException {
        if (score < 0) {
            throw new ScoreException("Значение не может быть отрицательным");
        }
    }
}
