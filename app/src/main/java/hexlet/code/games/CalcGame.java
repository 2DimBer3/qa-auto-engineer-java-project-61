package hexlet.code.games;

import java.util.random.RandomGenerator;

import static hexlet.code.Engine.ROUNDS_COUNT;
import static hexlet.code.Engine.runGame;

public class CalcGame {

    private static final RandomGenerator RANDOM = RandomGenerator.getDefault();
    private static final int RANDOM_BOUND = 20;
    private static final int OPERATORS_COUNT = 3;
    private static final int OPERATOR_PLUS = 0;
    private static final int OPERATOR_MINUS = 1;
    private static final int OPERATOR_MULTIPLY = 2;

    public static void calcGame(String userName) {
        System.out.println("What is the result of the expression?");

        String[] questions = new String[ROUNDS_COUNT];
        String[] correctAnswers = new String[ROUNDS_COUNT];

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            int x = RANDOM.nextInt(RANDOM_BOUND);
            int y = RANDOM.nextInt(RANDOM_BOUND);
            char operator = randomMathOperator();

            int correctAnswer = switch (operator) {
                case '+' -> x + y;
                case '-' -> x - y;
                case '*' -> x * y;
                default -> throw new IllegalStateException("Unexpected operator: " + operator);
            };

            questions[i] = x + " " + operator + " " + y;
            correctAnswers[i] = String.valueOf(correctAnswer);
        }

        runGame(questions, correctAnswers, userName);
    }

    private static Character randomMathOperator() {
        int operator = RANDOM.nextInt(OPERATORS_COUNT);
        return switch (operator) {
            case OPERATOR_PLUS -> '+';
            case OPERATOR_MINUS -> '-';
            case OPERATOR_MULTIPLY -> '*';
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }

}
