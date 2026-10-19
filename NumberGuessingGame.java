
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int bestScore = Integer.MAX_VALUE;
        boolean playAgain = true;

        System.out.println("=== NUMBER GUESSING GAME ===");

        while (playAgain) {
            System.out.println("\nChoose difficulty:");
            System.out.println("1. Easy (1-50, 10 attempts)");
            System.out.println("2. Medium (1-100, 7 attempts)");
            System.out.println("3. Hard (1-200, 6 attempts)");
            System.out.print("Your choice: ");

            int choice = sc.nextInt();
            int max, attempts;

            switch (choice) {
                case 1:
                    max = 50;
                    attempts = 10;
                    break;
                case 2:
                    max = 100;
                    attempts = 7;
                    break;
                case 3:
                    max = 200;
                    attempts = 6;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    continue;
            }

            int target = random.nextInt(max) + 1;
            int used = 0;
            boolean won = false;

            System.out.println("Guess a number from 1 to " + max);

            while (used < attempts) {
                System.out.print("Enter guess: ");
                int guess = sc.nextInt();
                used++;

                if (guess == target) {
                    System.out.println("Correct! You won in " + used + " attempts.");
                    won = true;
                    break;
                } else if (guess < target) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                System.out.println("Attempts left: " + (attempts - used));
            }

            if (!won) {
                System.out.println("Game over! Number was " + target);
            } else if (used < bestScore) {
                bestScore = used;
                System.out.println("New best score!");
            }

            System.out.print("Play again? (1 = Yes, 0 = No): ");
            playAgain = sc.nextInt() == 1;
        }

        if (bestScore != Integer.MAX_VALUE) {
            System.out.println("Best score: " + bestScore + " attempts");
        }

        System.out.println("Thanks for playing!");
        sc.close();
    }
}
