import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    private static final int MAX_ATTEMPTS = 7;
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalScore = 0;
        int round = 1;

        System.out.println("🎯 Welcome to the Number Guessing Game!");

        boolean playAgain;
        do {
            int targetNumber = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + round + " - Guess the number between " + LOWER_BOUND + " and " + UPPER_BOUND);

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Attempt " + (attempts + 1) + "/" + MAX_ATTEMPTS + " - Enter your guess: ");
                int guess;

                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("⚠️ Invalid input. Please enter a number.");
                    continue;
                }

                attempts++;

                if (guess == targetNumber) {
                    System.out.println("🎉 Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    totalScore += (MAX_ATTEMPTS - attempts + 1) * 10; // Higher score for fewer attempts
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ You've run out of attempts. The correct number was: " + targetNumber);
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.nextLine().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");
            round++;

        } while (playAgain);

        System.out.println("\n🏁 Game Over! Your total score: " + totalScore);
        scanner.close();
    }
}
