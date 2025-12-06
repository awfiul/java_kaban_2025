package hw;

import java.util.Scanner;

public class ConsoleGreeting {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Введите имя: ");
        String username = input.nextLine();

        System.out.println("Привет, " + username);

        input.close();
    }
}
