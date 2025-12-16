package hw;

import java.util.Arrays;

public class ArraysPractice {

    public static void main(String[] args) {

        // ============================
        // Практика #1
        // Присваивание массивов
        // ============================

        int[] first = {1, 2, 3, 4, 5};
        int[] second = {6, 7, 8, 9, 10};

        // Теперь first и second указывают на один и тот же массив
        first = second;

        // Изменяем элемент через first
        first[0] = 100;

        // Изменение видно и через second
        System.out.println("second[0] = " + second[0]); // 100


        // ============================
        // Работа с length и границами
        // ============================

        int[] data = {10, 20, 30};

        System.out.println("Размер массива: " + data.length);

        // data[3] = 40; // ArrayIndexOutOfBoundsException


        // ============================
        // Заменитель многомерных массивов
        // ============================

        int[][] table = {
                {1},
                {2, 3},
                {4, 5, 6},
                {7, 8, 9, 10}
        };

        System.out.println("table[2][1] = " + table[2][1]); // 5


        // ============================
        // Практика #2
        // Класс Arrays
        // ============================

        int[] nums = {9, 3, 7, 1, 5};

        // toString()
        String view = Arrays.toString(nums);
        System.out.println(view);

        // sort()
        Arrays.sort(nums);
        System.out.println("После сортировки: " + Arrays.toString(nums));

        // binarySearch()
        int index = Arrays.binarySearch(nums, 7);
        System.out.println("Индекс числа 7: " + index);

        // equals()
        int[] copy = {1, 3, 5, 7, 9};
        boolean same = Arrays.equals(nums, copy);
        System.out.println("Массивы равны: " + same);

        // compare()
        int[] other = {1, 3, 5, 7, 10};
        int cmp = Arrays.compare(nums, other);
        System.out.println("Результат compare: " + cmp);
    }
}
