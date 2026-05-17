package hexlet.code.games;

import java.util.random.RandomGenerator;

import static hexlet.code.Engine.ROUNDS_COUNT;
import static hexlet.code.Engine.runGame;

public class PrimeGame {

    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();
    private static final int RANDOM_NUMBER_BOUND = 100;

    public static void primeGame(String userName) {
        final String mainQuestion = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        String[][] questionsAndAnswers = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int number = RANDOM.nextInt(RANDOM_NUMBER_BOUND);

            String question = String.valueOf(number);
            String correctAnswer = isPrime(number) ? "yes" : "no";

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = correctAnswer;
        }

        runGame(mainQuestion, questionsAndAnswers, userName);
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
