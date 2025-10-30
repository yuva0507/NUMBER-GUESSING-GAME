import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        int score = 0; // total score across rounds
        boolean playAgain = true;

        System.out.println("=== Welcome to the Number Guessing Game ===");

        while (playAgain) {
            int number = rand.nextInt(100) + 1; // random number between 1 and 100
            int attemptsAllowed = 7;
            int attempts = 0;
            boolean guessed = false;

            System.out.println("\nI have picked a number between 1 and 100.");
            System.out.println("You have " + attemptsAllowed + " attempts to guess it.");

            while (attempts < attemptsAllowed) {
                System.out.print("Enter your guess: ");

                if (!scan.hasNextInt()) {
                    System.out.println("Please enter a valid number!");
                    scan.next(); // clear invalid input
                    continue;
                }

                int guess = scan.nextInt();
                attempts++;

                if (guess == number) {
                    System.out.println("Correct! You guessed the number in " + attempts + " attempts.");
                    int roundScore = (attemptsAllowed - attempts + 1) * 10;
                    score += roundScore;
                    System.out.println("You earned " + roundScore + " points this round.");
                    26guessed = true;
                    break;
                } else if (guess < number) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessed) {
                System.out.println("You've used all attempts! The correct number was " + number + ".");
            }

            System.out.println("Your total score so far: " + score);

            System.out.print("\nDo you want to play another round? (yes/no): ");
            String response = scan.next().toLowerCase();
            if (!response.equals("yes") && !response.equals("y")) {
                playAgain = false;
            }
        }

        System.out.println("\nThanks for playing!");
        System.out.println("Final Score: " + score);
        scan.close();
    }
}
