package hexlet.code.games;

import java.util.random.RandomGenerator;

import static hexlet.code.Engine.ROUNDS_COUNT;
import static hexlet.code.Engine.runGame;

public class CalcGame {
    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();

    public static void playCalcGame(String userName) {
        final String mainQuestion = "What is the result of the expression?";
        final String[][] roundsData = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            roundsData[i] = generateRoundData();
        }

        runGame(mainQuestion, roundsData, userName);
    }

    private static String[] generateRoundData() {
        final int maxNumber = 20;

        int x = RANDOM.nextInt(maxNumber + 1);
        int y = RANDOM.nextInt(maxNumber + 1);
        char operator = generateRandomMathOperator();

        String question = x + " " + operator + " " + y;
        String correctAnswer = String.valueOf(calcByOperator(x, y, operator));

        return new String[]{question, correctAnswer};
    }

    private static char generateRandomMathOperator() {
        final char[] operators = {'+', '-', '*'};
        int indexOperator = RANDOM.nextInt(0, operators.length);
        return operators[indexOperator];
    }

    private static int calcByOperator(int x, int y, char operator) {
        return switch (operator) {
            case '+' -> x + y;
            case '-' -> x - y;
            case '*' -> x * y;
            default -> throw new IllegalStateException("Unexpected operator: " + operator);
        };
    }
}
