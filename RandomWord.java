import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RandomWord {

    public String randomWord;
    public int numLettersToSolve;
    public int numGuesses;

    public RandomWord(String randomWord) {
        this.randomWord = randomWord;
        this.numLettersToSolve = randomWord.length();
        this.numGuesses = 0;
    }

    public void playGame(int numLettersToSolve, Scanner theScanner, boolean isCorrect) {
        if (numLettersToSolve == 0) {
            // display congrats message, non-base case
            return;
        } else if (numGuesses == 3) {

            // display message saying you lost, non-base case
            return;
        } else {
            // play the game, non-base case
            // if ()
            System.out.print("Pick one letter from A-Z. No numbers, spaces, nor special characters: ");
            String theLetter = theScanner.next().toUpperCase();
            boolean checkIfLetterIsValid = letterValidity(theLetter);
            // check for letter validity
            while (!checkIfLetterIsValid) {
                System.out.print("Pick one letter from A-Z. No numbers, spaces, nor special characters: ");
                theLetter = theScanner.next().toUpperCase();
                checkIfLetterIsValid = letterValidity(theLetter);
            }
            System.out.print("Your letter is: " + theLetter);
            System.out.println();
        }
    }

    public boolean letterValidity(String theLetter) {

        Pattern pattern = Pattern.compile("[a-zA-Z]", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(theLetter);
        boolean matchFound = matcher.find();

        boolean result = true;
        if (theLetter.length() != 1) {
            System.out.println("You entered more than one character. Please try again.");
            result =  false;
        } else if (!matchFound) {
            System.out.println("You did not enter a letter. Please try again.");
            result = false;
        }
        return result;
    }

    public void displaySpaces(String randomWord) {
        for (int i = 0; i < randomWord.length(); i++) {
            System.out.print("___ ");
        }
        System.out.println();
        System.out.println();
    }

    public void displayUsedLetters() {
        System.out.println();
        System.out.print("Used Letters:");
        // Function to display used letters will go here.
        System.out.println();
        System.out.println();
    }
}