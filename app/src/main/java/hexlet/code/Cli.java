package hexlet.code;

import java.util.Scanner;

public class Cli {

    public static void userGreeting() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        System.out.println("Hello, " + scanner.next() + "!");
    }

}
