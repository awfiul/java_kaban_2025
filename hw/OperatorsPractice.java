package hw;

public class OperatorsPractice {

    public static void main(String[] args) {

        // ============================
        // Практика #1 — операторы
        // ============================

        // Операторы присваивания
        int a = 5;
        a += 3;
        a -= 1;
        a *= 2;
        a /= 7;
        a %= 3;

        // Тернарный оператор
        int x = 10;
        int y = (x > 5) ? 1 : 0;

        // Логические операторы
        boolean b1 = true || false;
        boolean b2 = true && false;

        // Побитовые операторы
        int p1 = 6 | 3;   // 110 | 011 = 111
        int p2 = 6 ^ 3;   // 110 ^ 011 = 101
        int p3 = 6 & 3;   // 110 & 011 = 010

        // Операторы сравнения
        boolean cmp1 = 5 == 5;
        boolean cmp2 = 5 != 3;
        boolean cmp3 = 7 > 2;
        boolean cmp4 = 7 >= 7;
        boolean cmp5 = 3 < 9;
        boolean cmp6 = 3 <= 3;

        // Операторы сдвига
        int s1 = 8 >> 1;   // 1000 -> 0100
        int s2 = 8 << 2;   // 1000 -> 100000
        int s3 = -8 >>> 1; // беззнаковый сдвиг

        // Арифметические операторы
        int ar1 = 4 + 6;
        int ar2 = 10 - 3;
        int ar3 = 2 * 5;
        int ar4 = 20 / 4;
        int ar5 = 22 % 6;

        // Инкремент и декремент
        int inc = 5;
        int preInc = ++inc;   // префиксный
        int postInc = inc++;  // постфиксный

        int dec = 5;
        int preDec = --dec;
        int postDec = dec--;

        // Унарные операторы
        int neg = -10;
        boolean not = !true;
        int bitNot = ~5;

        // Скобки и индексы
        int[] arr = {1, 2, 3};
        int expr = (2 + 3) * 4;
        int elem = arr[1];

        // String + и +=
        String text = "Имя: ";
        text += "Дарья";
        String mix = "Возраст: " + 20 + ", рост: " + 168;

        System.out.println(text);
        System.out.println(mix);


        // ============================
        // Практика #2 — оператор instanceof
        // ============================

        Animal a1 = new Dog();
        Animal a2 = new Cat();
        Animal a3 = null;

        System.out.println(a1 instanceof Animal); // true
        System.out.println(a1 instanceof Dog);    // true
        System.out.println(a1 instanceof Cat);    // false

        System.out.println(a2 instanceof Animal); // true
        System.out.println(a2 instanceof Dog);    // false

        // instanceof с null всегда возвращает false
        System.out.println(a3 instanceof Animal); // false
    }
}

// Классы для примеров instanceof
class Animal {
}

class Dog extends Animal {
}

class Cat extends Animal {
}
