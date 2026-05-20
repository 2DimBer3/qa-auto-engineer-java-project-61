package hexlet.code.games;

import java.util.random.RandomGenerator;

import static hexlet.code.Engine.ROUNDS_COUNT;
import static hexlet.code.Engine.runGame;

public class EvenGame {
    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();

    public static void playEvenGame(String userName) {
        final String mainQuestion = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        final String[][] roundsData = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            roundsData[i] = generateRoundData();
        }

        runGame(mainQuestion, roundsData, userName);
    }

    private static String[] generateRoundData() {
        final int MAX_NUMBER = 20;
        int number = RANDOM.nextInt(MAX_NUMBER + 1);

        String question = String.valueOf(number);
        String correctAnswer = isEvenNumber(number) ? "yes" : "no";

        return new String[]{question, correctAnswer};
    }

    private static boolean isEvenNumber(int number) {
        return number % 2 == 0;
    }
}
