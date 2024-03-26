import java.util.Scanner;
import java.util.Random;

 class NumberGuessingGame{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1; // Generate a random number between 1 and 100
        int attempts = 0;
        final int MAX_ATTEMPTS = 5; // Maximum number of attempts allowed
        
        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Try to guess the number between 1 and 100.");
        
        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;
            
            if (guess == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                break;
            } else if (guess < randomNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }
        
        if (attempts == MAX_ATTEMPTS) {
            System.out.println("Sorry, you've used all your attempts. The correct number was " + randomNumber + ".");
        }
        
        scanner.close();
    }
}