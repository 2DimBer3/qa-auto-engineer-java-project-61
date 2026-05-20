package hexlet.code.games;

import java.util.random.RandomGenerator;

import static hexlet.code.Engine.ROUNDS_COUNT;
import static hexlet.code.Engine.runGame;

public class ProgressionGame {
    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();

    public static void playProgressionGame(String userName) {
        final String mainQuestion = "What number is missing in the progression?";
        final String[][] roundsData = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            roundsData[i] = generateRoundData();
        }

        runGame(mainQuestion, roundsData, userName);
    }

    private static String[] generateRoundData() {
        final int maxNumber = 10;
        final int minLength = 5;
        final int maxLength = 10;

        int start = RANDOM.nextInt(maxNumber + 1);
        int step = RANDOM.nextInt(1, maxNumber + 1);
        int length = RANDOM.nextInt(minLength, maxLength + 1);
        String[] progression = buildProgression(start, step, length);

        int hiddenIndex = RANDOM.nextInt(length);
        String correctAnswer = progression[hiddenIndex];
        progression[hiddenIndex] = "..";
        String question = String.join(" ", progression);

        return new String[]{question, correctAnswer};
    }

    private static String[] buildProgression(int start, int step, int length) {
        String[] progression = new String[length];
        for (int i = 0; i < length; i++) {
            progression[i] = String.valueOf(start + i * step);
        }
        return progression;
    }
}
