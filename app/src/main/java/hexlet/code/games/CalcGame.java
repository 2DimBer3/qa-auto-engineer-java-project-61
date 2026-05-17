package hexlet.code.games;

import java.util.random.RandomGenerator;

import static hexlet.code.Engine.ROUNDS_COUNT;
import static hexlet.code.Engine.runGame;

public class CalcGame {

    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();
    private static final int RANDOM_BOUND = 20;

    public static void calcGame(String userName) {
        final String mainQuestion = "What is the result of the expression?";

        String[][] questionsAndAnswers = new String[ROUNDS_COUNT][2];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int x = RANDOM.nextInt(RANDOM_BOUND);
            int y = RANDOM.nextInt(RANDOM_BOUND);
            char operator = randomMathOperator();

            String question = x + " " + operator + " " + y;
            String correctAnswer = String.valueOf(calcByOperator(x, y, operator));

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = correctAnswer;
        }

        runGame(mainQuestion, questionsAndAnswers, userName);
    }

    private static Character randomMathOperator() {
        final char[] operators = {'+', '-', '*'};
        int indexOperator = RANDOM.nextInt(0, operators.length);
        return operators[indexOperator];
    }

    private static int calcByOperator(int x, int y, Character operator) {
        return switch (operator) {
            case '+' -> x + y;
            case '-' -> x - y;
            case '*' -> x * y;
            default -> throw new IllegalStateException("Unexpected operator: " + operator);
        };
    }

}
