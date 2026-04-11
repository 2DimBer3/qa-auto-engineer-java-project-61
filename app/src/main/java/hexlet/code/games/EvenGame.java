package hexlet.code.games;

import java.util.random.RandomGenerator;

import static hexlet.code.Engine.ROUNDS_COUNT;
import static hexlet.code.Engine.runGame;

public class EvenGame {

    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();
    private static final int RANDOM_BOUND = 20;

    public static void evenGame(String userName) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        String[] questions = new String[ROUNDS_COUNT];
        String[] correctAnswers = new String[ROUNDS_COUNT];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int number = RANDOM.nextInt(RANDOM_BOUND);
            String correctAnswer = number % 2 == 0 ? "yes" : "no";

            questions[i] = String.valueOf(number);
            correctAnswers[i] = correctAnswer;
        }

        runGame(questions, correctAnswers, userName);
    }

}
