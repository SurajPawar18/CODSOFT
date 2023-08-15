import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int maxAttempts = 10, rounds = 0, totalAttempts = 0, bestScore = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have generated a number between 0 and 100.");
        System.out.println("You have " + maxAttempts + " attempts for each round.");

        boolean playAgain = true;
        while (playAgain) {
            int generatedNumber = (int) (Math.random() * 101);
            int attempts = 0;
            rounds++;

            boolean roundComplete = false;
            while (!roundComplete && attempts < maxAttempts) {
                System.out.print("Round " + rounds + ", Attempt " + (attempts + 1) + ": Enter your guess: ");
                int userGuess = sc.nextInt();
                attempts++;

                if (userGuess < generatedNumber) {
                    System.out.println("Your guess is low.");
                } else if (userGuess > generatedNumber) {
                    System.out.println("Your guess is high.");
                } else {
                    roundComplete = true;
                    System.out.println("Congratulations! You guessed the number " + generatedNumber + " correctly!");
                    attempts++;
                    bestScore += 10;
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = sc.next().equalsIgnoreCase("yes");
        }

        System.out.println("Game over! You played " + rounds + " rounds.");
        System.out.println("Your best score : " + bestScore);

        sc.close();
    }
}
