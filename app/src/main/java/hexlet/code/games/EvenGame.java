package hexlet.code.games;

import java.util.random.RandomGenerator;

import static hexlet.code.Engine.ROUNDS_COUNT;
import static hexlet.code.Engine.runGame;

public class EvenGame {

    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();

    public static void playEvenGame(String userName) {
        final String mainQuestion = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        final String[][] questionsAndAnswers = generateRoundsData();

        runGame(mainQuestion, questionsAndAnswers, userName);
    }

    private static String[][] generateRoundsData() {
        final int MAX_NUMBER = 20;
        String[][] questionsAndAnswers = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int number = RANDOM.nextInt(MAX_NUMBER);

            String question = String.valueOf(number);
            String correctAnswer = isEvenNumber(number) ? "yes" : "no";

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = correctAnswer;
        }

        return questionsAndAnswers;
    }

    private static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }
}
