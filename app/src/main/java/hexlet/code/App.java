package hexlet.code;

import java.util.Scanner;

import static hexlet.code.Cli.userGreeting;
import static hexlet.code.Games.evenGame;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                 Please enter the game number and press Enter.
                 1 - Greet
                 2 - Even
                 0 - Exit
                """
        );
        System.out.print("Your choice: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1" -> userGreeting();
            case "2" -> evenGame(userGreeting());
            default -> {
            }
        }
    }
}
