import java.util.Random;
import java.util.Scanner;

public class task1 {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BG_BLUE = "\u001B[44m";
    public static final String ANSI_BG_GREEN = "\u001B[42m";
    public static final String ANSI_BG_RED = "\u001B[41m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int roundsWon = 0;
        int roundsPlayed = 0;
        boolean playAgain = true;

        System.out.println(ANSI_BG_BLUE + ANSI_WHITE);
        System.out.println("==============================================");
        System.out.println("         WELCOME TO THE NUMBER GAME!          ");
        System.out.println("==============================================" + ANSI_RESET);

        while (playAgain) {
            roundsPlayed++;
            int numberToGuess = random.nextInt(100) + 1; 
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI'm thinking of a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println(ANSI_BG_GREEN + "Congratulations! You guessed the number in " + attempts + " attempts." + ANSI_RESET);
                    guessedCorrectly = true;
                    roundsWon++;
                } else if (guess < numberToGuess) {
                    System.out.println(ANSI_BG_BLUE + "Too low! Try again." + ANSI_RESET);
                } else {
                    System.out.println(ANSI_BG_RED + "Too high! Try again." + ANSI_RESET);
                }
            }

            if (!guessedCorrectly) {
                System.out.println(ANSI_BG_RED + "Sorry, you've used all your attempts. The number was " + numberToGuess + "." + ANSI_RESET);
            }

            System.out.println("Your score: " + roundsWon + " wins out of " + roundsPlayed + " rounds.");

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("\nThanks for playing! Goodbye.");
        scanner.close();
    }
}
