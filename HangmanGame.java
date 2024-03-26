import java.util.Scanner;
import java.util.Random;

public class HangmanGame {
    private static final String[] WORDS = {"apple", "banana", "orange","papaya","mango","grape","muskmelon","watermelon","dragonfruit","guava","strawberry"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String word = WORDS[random.nextInt(WORDS.length)];
        char[] guessedLetters = new char[word.length()];
        boolean[] guessedLettersMask = new boolean[word.length()];
        int incorrectGuesses = 0;
        boolean wordGuessed = false;

        // Initialize guessedLettersMask to false
        for (int i = 0; i < word.length(); i++) {
            guessedLettersMask[i] = false;
        }

        // Game loop
        while (incorrectGuesses < 6 && !wordGuessed) {
            // Display current state of the word
            for (int i = 0; i < word.length(); i++) {
                if (guessedLettersMask[i]) {
                    System.out.print(word.charAt(i) + " ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();

            // Prompt user for a letter
            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            // Check if the letter is in the word
            boolean correctGuess = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    guessedLettersMask[i] = true;
                    correctGuess = true;
                }
            }

            // If the guess is incorrect, increment incorrectGuesses
            if (!correctGuess) {
                incorrectGuesses++;
                // Display hangman figure based on incorrect guesses
                displayHangman(incorrectGuesses);
            }

            // Check if the word has been guessed
            wordGuessed = true;
            for (boolean letterGuessed : guessedLettersMask) {
                if (!letterGuessed) {
                    wordGuessed = false;
                    break;
                }
            }
        }

        // Display the outcome of the game
        if (wordGuessed) {
            System.out.println("Congratulations! You guessed the word: " + word);
        } else {
            System.out.println("Sorry, you didn't guess the word. The word was: " + word);
        }

        scanner.close();
    }

    // Method to display hangman figure based on incorrect guesses
    private static void displayHangman(int incorrectGuesses) {
        String[] hangmanFigures = {
            "  +---+\n" +
            "  |   |\n" +
            "      |\n" +
            "      |\n" +
            "      |\n" +
            "      |\n" +
            "=========",
            "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            "      |\n" +
            "      |\n" +
            "      |\n" +
            "=========",
            "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            "  |   |\n" +
            "      |\n" +
            "      |\n" +
            "=========",
            "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|   |\n" +
            "      |\n" +
            "      |\n" +
            "=========",
            "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|\\  |\n" +
            "      |\n" +
            "      |\n" +
            "=========",
            "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|\\  |\n" +
            " /    |\n" +
            "      |\n" +
            "=========",
            "  +---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|\\  |\n" +
            " / \\  |\n" +
            "      |\n" +
            "========="
        };

        System.out.println(hangmanFigures[incorrectGuesses - 1]);
    }
}