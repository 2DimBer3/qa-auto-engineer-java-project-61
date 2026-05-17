package hexlet.code.games;

import java.util.random.RandomGenerator;

import static hexlet.code.Engine.ROUNDS_COUNT;
import static hexlet.code.Engine.runGame;

public class ProgressionGame {

    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int LENGTH_START = 5;
    private static final int LENGTH_END = 10;

    public static void progressionGame(String userName) {
        final String mainQuestion = "What number is missing in the progression?";

        String[][] questionsAndAnswers = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int start = RANDOM.nextInt(RANDOM_NUMBER_BOUND);
            int step = RANDOM.nextInt(1, RANDOM_NUMBER_BOUND);
            int length = RANDOM.nextInt(LENGTH_START, LENGTH_END + 1);
            String[] progression = fillProgression(start, step, length);

            int hiddenIndex  = RANDOM.nextInt(progression.length);
            String correctAnswer = progression[hiddenIndex];
            progression[hiddenIndex] = "..";
            String question = String.join(" ", progression);

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = correctAnswer;
        }

        runGame(mainQuestion, questionsAndAnswers, userName);
    }

    private static String[] fillProgression(int start, int step, int length) {
        String[] progression = new String[length];
        for (int i = 0; i < length; i++) {
            progression[i] = String.valueOf(start + i * step);
        }
        return progression;
    }

}
