package hexlet.code.games;

import java.util.random.RandomGenerator;

import static hexlet.code.Engine.ROUNDS_COUNT;
import static hexlet.code.Engine.runGame;

public class GcdGame {

    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();
    private static final int RANDOM_BOUND = 100;

    public static void gcdGame(String userName) {
        System.out.println("Find the greatest common divisor of given numbers.");

        String[] questions = new String[ROUNDS_COUNT];
        String[] correctAnswers = new String[ROUNDS_COUNT];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int x = RANDOM.nextInt(RANDOM_BOUND);
            int y = RANDOM.nextInt(RANDOM_BOUND);

            int correctAnswer = gcdCalculation(x, y);

            questions[i] = x + " " + y;
            correctAnswers[i] = String.valueOf(correctAnswer);
        }

        runGame(questions, correctAnswers, userName);
    }
    public static int gcdCalculation(int a, int b) {
        return (b == 0) ? Math.abs(a) : gcdCalculation(b, a % b);
    }

}
