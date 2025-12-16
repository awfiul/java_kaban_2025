package hw;

public class LoopsPractice {

    public static void main(String[] args) {

        // ============================
        // Практика #1
        // Бесконечные циклы
        // ============================

        // Бесконечный while
        int w = 0;
        while (true) {
            w++;
            if (w == 3) {
                break; // выход из бесконечного цикла
            }
        }

        // Бесконечный do-while
        int d = 0;
        do {
            d++;
            if (d == 2) {
                break; // выход из бесконечного цикла
            }
        } while (true);


        // ============================
        // Практика #2
        // break и continue
        // ============================

        for (int i = 0; i < 5; i++) {

            if (i == 1) {
                continue; // пропуск итерации
            }

            if (i == 4) {
                break; // досрочный выход из цикла
            }

            System.out.println("i = " + i);
        }


        // ============================
        // for-each для массивов
        // ============================

        int[] numbers = {2, 4, 6, 8};

        for (int n : numbers) {
            System.out.println(n);
            // n = 100; // изменение элемента массива невозможно
        }


        // ============================
        // for с несколькими параметрами
        // ============================

        for (int left = 0, right = 5; left < right; left++, right--) {
            System.out.println("left=" + left + ", right=" + right);
        }
    }
}
