package hexlet.code;

import java.util.Scanner;

import static hexlet.code.Cli.userGreeting;
import static hexlet.code.games.CalcGame.playCalcGame;
import static hexlet.code.games.EvenGame.playEvenGame;
import static hexlet.code.games.GcdGame.playGcdGame;
import static hexlet.code.games.PrimeGame.primeGame;
import static hexlet.code.games.ProgressionGame.progressionGame;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                 Please enter the game number and press Enter.
                 1 - Greet
                 2 - Even
                 3 - Calc
                 4 - GCD
                 5 - Progression
                 6 - Prime
                 0 - Exit
                """
        );
        System.out.print("Your choice: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "0" -> { }
            case "1" -> userGreeting();
            case "2" -> playEvenGame(userGreeting());
            case "3" -> playCalcGame(userGreeting());
            case "4" -> playGcdGame(userGreeting());
            case "5" -> progressionGame(userGreeting());
            case "6" -> primeGame(userGreeting());
            default -> System.out.println("Unknown user choice: " + choice);
        }
    }
}
