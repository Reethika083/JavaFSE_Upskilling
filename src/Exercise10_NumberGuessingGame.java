import java.util.Scanner;
import java.util.Random;

public class Exercise10_NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Generate a random number between 1 and 100 🎯
        int secretNumber = random.nextInt(100) + 1;
        int guess;
        int attempts = 0;

        System.out.println("🎮 Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 100...");

        // Keep looping until the guess is correct
        do {
            System.out.print("Enter your guess: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < secretNumber) {
                System.out.println("Too low! 📉 Try again.");
            } else if (guess > secretNumber) {
                System.out.println("Too high! 📈 Try again.");
            } else {
                System.out.println("🎉 Correct! You guessed it in " + attempts + " tries! 🔥");
            }

        } while (guess != secretNumber);

        scanner.close();
    }
}
