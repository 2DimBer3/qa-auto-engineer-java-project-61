package hexlet.code.games;

import java.util.Arrays;
import java.util.random.RandomGenerator;

import static hexlet.code.Engine.ROUNDS_COUNT;
import static hexlet.code.Engine.runGame;

public class ProgressionGame {

    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();
    private static final int RANDOM_NUMBER_BOUND = 10;
    private static final int LENGTH_START = 5;
    private static final int LENGTH_END = 10;

    public static void progressionGame(String userName) {
        System.out.println("What number is missing in the progression?");

        String[] questions = new String[ROUNDS_COUNT];
        String[] correctAnswers = new String[ROUNDS_COUNT];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int start = RANDOM.nextInt(RANDOM_NUMBER_BOUND);
            int step = RANDOM.nextInt(1, RANDOM_NUMBER_BOUND);
            int length = RANDOM.nextInt(LENGTH_START, LENGTH_END + 1);
            String[] progression = fillProgression(start, step, length);

            int hiddenIndex  = RANDOM.nextInt(progression.length);
            String correctAnswer = progression[hiddenIndex ];
            progression[hiddenIndex ] = "..";

            questions[i] = Arrays.toString(progression);
            correctAnswers[i] = correctAnswer;
        }

        runGame(questions, correctAnswers, userName);
    }
    private static String[] fillProgression(int start, int step, int length) {
        String[] progression = new String[length];
        for (int i = 0; i < length; i++) {
            progression[i] = String.valueOf(start + i * step);
        }
        return progression;
    }

}
