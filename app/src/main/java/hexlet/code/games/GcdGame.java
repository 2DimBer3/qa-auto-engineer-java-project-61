package hexlet.code.games;

import java.util.random.RandomGenerator;

import static hexlet.code.Engine.ROUNDS_COUNT;
import static hexlet.code.Engine.runGame;

public class GcdGame {
    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();

    public static void playGcdGame(String userName) {
        final String mainQuestion = "Find the greatest common divisor of given numbers.";
        final String[][] roundsData = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            roundsData[i] = generateRoundData();
        }

        runGame(mainQuestion, roundsData, userName);
    }

    private static String[] generateRoundData() {
        final int MAX_NUMBER = 100;
        int x = RANDOM.nextInt(MAX_NUMBER + 1);
        int y = RANDOM.nextInt(MAX_NUMBER + 1);

        String question = x + " " + y;
        String correctAnswer = String.valueOf(calculateGcd(x, y));

        return new String[]{question, correctAnswer};
    }

    private static int calculateGcd(int a, int b) {
        return (b == 0) ? Math.abs(a) : calculateGcd(b, a % b);
    }
}