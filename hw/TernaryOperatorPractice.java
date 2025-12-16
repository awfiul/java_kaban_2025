package hw;

public class TernaryOperatorPractice {

    public static void main(String[] args) {

        int value = 2;
        int result;

        // Эквивалент if / else if / else через тернарный оператор
        result = (value == 1) ? 1
               : (value == 2) ? 2
               : 3;

        System.out.println(result);
    }
}
