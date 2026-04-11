package hexlet.code;

import java.util.Scanner;

public class Engine {

    private static final Scanner SCANNER = new Scanner(System.in);
    public static final int ROUNDS_COUNT = 3;

    public static void runGame(String[] questions, String[] correctAnswers, String userName) {
        for (int i = 0; i < ROUNDS_COUNT; i++) {
            System.out.println("Question: " + questions[i]);
            System.out.print("Your answer: ");
            String userAnswer = SCANNER.nextLine();

            if (correctAnswers[i].equals(userAnswer)) {
                System.out.println("Correct!");
                if (i == ROUNDS_COUNT - 1) {
                    System.out.println("Congratulations, " + userName + "!");
                }
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. "
                        + "Correct answer was '" + correctAnswers[i] + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }
    }
}
