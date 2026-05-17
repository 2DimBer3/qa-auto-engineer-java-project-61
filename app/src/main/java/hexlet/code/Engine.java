package hexlet.code;

import java.util.Scanner;

public class Engine {

    private static final Scanner SCANNER = new Scanner(System.in);
    public static final int ROUNDS_COUNT = 3;

    public static void runGame(String mainQuestion, String[][] questionsAndAnswers, String userName) {
        System.out.println(mainQuestion);

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            String question = questionsAndAnswers[i][0];
            String correctAnswer = questionsAndAnswers[i][1];

            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            String userAnswer = SCANNER.nextLine();

            if (correctAnswer.equals(userAnswer)) {
                System.out.println("Correct!");
                if (i == ROUNDS_COUNT - 1) {
                    System.out.println("Congratulations, " + userName + "!");
                }
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. "
                        + "Correct answer was '" + correctAnswer + "'.");
                System.out.println("Let's try again, " + userName + "!");
                return;
            }
        }
    }
}
