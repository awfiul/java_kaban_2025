package hw;

public class Practice2_FinalInCatch {

    public static void main(String[] args) {

        try {
            int[] data = new int[2];
            System.out.println(data[5]);
        } catch (final Exception e) {

            // e объявлен как final
            // это означает, что ссылку e нельзя изменить
            // e = new Exception(); // ошибка компиляции

            System.out.println("Исключение обработано: " + e.getClass().getSimpleName());
        }
    }
}
