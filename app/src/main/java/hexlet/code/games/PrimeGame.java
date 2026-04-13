package hexlet.code.games;

import java.util.random.RandomGenerator;

import static hexlet.code.Engine.ROUNDS_COUNT;
import static hexlet.code.Engine.runGame;

public class PrimeGame {

    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();
    private static final int RANDOM_NUMBER_BOUND = 100;

    public static void primeGame(String userName) {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        String[] questions = new String[ROUNDS_COUNT];
        String[] correctAnswers = new String[ROUNDS_COUNT];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int number = RANDOM.nextInt(RANDOM_NUMBER_BOUND);
            String correctAnswer = isPrime(number) ? "yes" : "no";

            questions[i] = String.valueOf(number);
            correctAnswers[i] = correctAnswer;
        }

        runGame(questions, correctAnswers, userName);
    }

    private static boolean isPrime(int number) {
        if ((number < 2) || (number % 2 == 0)) {
            return false;
        }

        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

}
