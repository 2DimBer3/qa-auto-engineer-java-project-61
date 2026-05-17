package hexlet.code.games;

import java.util.random.RandomGenerator;

import static hexlet.code.Engine.ROUNDS_COUNT;
import static hexlet.code.Engine.runGame;

public class GcdGame {

    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();
    private static final int RANDOM_BOUND = 100;

    public static void gcdGame(String userName) {
        final String mainQuestion = "Find the greatest common divisor of given numbers.";

        String[][] questionsAndAnswers = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int x = RANDOM.nextInt(RANDOM_BOUND);
            int y = RANDOM.nextInt(RANDOM_BOUND);

            String question = x + " " + y;
            String correctAnswer = String.valueOf(gcdCalculation(x, y));

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = correctAnswer;
        }

        runGame(mainQuestion, questionsAndAnswers, userName);
    }

    public static int gcdCalculation(int a, int b) {
        return (b == 0) ? Math.abs(a) : gcdCalculation(b, a % b);
    }

}
