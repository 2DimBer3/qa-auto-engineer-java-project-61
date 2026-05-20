package hexlet.code.games;

import java.util.random.RandomGenerator;

import static hexlet.code.Engine.ROUNDS_COUNT;
import static hexlet.code.Engine.runGame;

public class PrimeGame {
    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();

    public static void playPrimeGame(String userName) {
        final String mainQuestion = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
        final String[][] roundsData = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            roundsData[i] = generateRoundData();
        }

        runGame(mainQuestion, roundsData, userName);
    }

    private static String[] generateRoundData() {
        final int MAX_NUMBER = 100;
        int number = RANDOM.nextInt(MAX_NUMBER + 1);

        String question = String.valueOf(number);
        String correctAnswer = isPrime(number) ? "yes" : "no";

        return new String[]{question, correctAnswer};
    }

    private static boolean isPrime(int number) {
        final int startDivisor = 3;
        final int step = 2;
        final int minPrimeNumber = 2;

        if ((number < minPrimeNumber) || (number % minPrimeNumber == 0)) {
            return false;
        }

        for (int i = startDivisor; i * i <= number; i += step) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
