import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            int minRange = 1;
            int maxRange = 100;
            int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attempts = 0;
            int maxAttempts = 5;
            boolean hasWon = false;

            System.out.println("Guess a number between " + minRange + " and " + maxRange + ":");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    hasWon = true;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                System.out.println("You have " + (maxAttempts - attempts) + " attempts left.");
            }

            if (hasWon) {
                System.out.println("Congratulations! You've guessed the right number: " + randomNumber);
            } else {
                System.out.println("Sorry! You've used all your attempts. The number was: " + randomNumber);
            }

            System.out.print("Would you like to play again? (yes/no): ");
            String response = scanner.next().toLowerCase();
            playAgain = response.equals("yes");

            System.out.println();
        }

        System.out.println("Thank you for playing the Number Guessing Game!");
        scanner.close();
    }
}
