package hexlet.code;

import java.util.Random;
import java.util.Scanner;
import java.util.random.RandomGenerator;

public class Games {

    private static final Scanner scanner = new Scanner(System.in);
    private static final RandomGenerator random = new Random();

    public static void evenGame(String userName) {
        int numberOfGames = 3;
        int randomBound = 20;

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        for (int i = 0; i < numberOfGames; i++) {
            int number = random.nextInt(randomBound);
            System.out.println("Question: " + number);
            System.out.print("Your answer: ");

            String userValue = scanner.nextLine();
            String correctValue = number % 2 == 0 ? "yes" : "no";

            if (correctValue.equals(userValue)) {
                System.out.println("Correct!");
                if (i == numberOfGames - 1) {
                    System.out.println("Congratulations, " + userName + "!");
                }
            } else {
                System.out.println("'" + userValue + "' is wrong answer ;(. Correct answer was '" + correctValue + "'.");
                System.out.println("Let's try again, "  + userName + "!");
                break;
            }
        }
    }

}
