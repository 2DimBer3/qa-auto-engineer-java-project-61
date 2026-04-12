package hexlet.code;

import java.util.Scanner;

import static hexlet.code.Cli.userGreeting;
import static hexlet.code.games.CalcGame.calcGame;
import static hexlet.code.games.EvenGame.evenGame;
import static hexlet.code.games.GcdGame.gcdGame;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                 Please enter the game number and press Enter.
                 1 - Greet
                 2 - Even
                 3 - Calc
                 4 - GCD
                 0 - Exit
                """
        );
        System.out.print("Your choice: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1" -> userGreeting();
            case "2" -> evenGame(userGreeting());
            case "3" -> calcGame(userGreeting());
            case "4" -> gcdGame(userGreeting());
            default -> {
            }
        }
    }
}
