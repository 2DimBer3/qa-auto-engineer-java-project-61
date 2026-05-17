package hexlet.code.games;

import java.util.random.RandomGenerator;

import static hexlet.code.Engine.ROUNDS_COUNT;
import static hexlet.code.Engine.runGame;

public class EvenGame {

    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();
    private static final int RANDOM_BOUND = 20;

    public static void evenGame(String userName) {
        final String mainQuestion = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        String[][] questionsAndAnswers = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int number = RANDOM.nextInt(RANDOM_BOUND);

            String question = String.valueOf(number);
            String correctAnswer = number % 2 == 0 ? "yes" : "no";

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = correctAnswer;
        }

        runGame(mainQuestion, questionsAndAnswers, userName);
    }

}
