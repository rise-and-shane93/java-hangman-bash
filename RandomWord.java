import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RandomWord {

    public String randomWord;
    public int numLettersToSolve;
    public int numGuesses;
    public int[] indexesOfSolvedLetters;
    public String indexesOfSolvedLettersStr;

    public RandomWord(String randomWord) {
        this.randomWord = randomWord;
        this.numLettersToSolve = randomWord.length();
        this.numGuesses = 0;
        this.indexesOfSolvedLettersStr = "";
    }

    // checks if a letter does not contain numbers, spaces, nor special characters, and has not already been used

    public String checkLetterValidity(UsedLetters theUsedLetters, String[] theUsedLettersArr, String theLetter) {
        String res = "";

        boolean validLetter = letterValidity(theLetter);
        boolean isLetterUsed = checkIsUsedLetter(theUsedLettersArr, theLetter);

        if (validLetter && !isLetterUsed) {
            res = "valid";
        } else if (!validLetter && !isLetterUsed) {
            // res = "invalid letter";
            res = "Pick one letter from A-Z. No numbers, spaces, nor special characters: ";
        } else if (!validLetter && isLetterUsed) {
            // res = "invalid letter and letter is already used";
            res = "The letter is invalid and has already been used. Please pick another one: ";
        } else if (validLetter && !isLetterUsed) {
            res = "That letter is already used. Please pick another one: ";
        }

        return res;
    }

    public boolean checkIsUsedLetter(String[] theUsedLetters, String theLetter) {
        boolean res = false;

        for (int i = 0; i < theUsedLetters.length; i++) {
            if (theUsedLetters[i].equals(theLetter)) {
                res = true;
            }
        }

        return res;
    }

    public void playGame(int numLettersToSolve, int numGuesses, Scanner theScanner, boolean isCorrect, String theWord, UsedLetters theUsedLetters) {
        // UsedLetters theUsedLetters = new UsedLetters();

        if (numLettersToSolve == 0) {
            // display congrats message, non-base case
            System.out.println("You win!");
            return;
        } else if (numGuesses == 3) {
            // display message saying you lost, non-base case
            System.out.println("You lost, the word was " + theWord);
            return;
        } else {
            // play the game, non-base case

            // get the letter
            System.out.print("Pick one letter from A-Z. No numbers, spaces, nor special characters: ");
            String theLetter = theScanner.next().toUpperCase();

            // check for letter validity
            // boolean checkIfLetterIsValid = letterValidity(theLetter);
            // while (!checkIfLetterIsValid) {
            //     System.out.print("Pick one letter from A-Z. No numbers, spaces, nor special characters: ");
            //     theLetter = theScanner.next().toUpperCase();
            //     checkIfLetterIsValid = letterValidity(theLetter);
            // }

            // check if the letter is already used
            // boolean isUsedLetter = theUsedLetters.checkIsUsedLetter(theUsedLetters.usedLetters, theLetter);
            // while (!isUsedLetter) {
            //     System.out.print("You have already used this letter. Please pick another one.");
            //     theLetter = theScanner.next().toUpperCase();
            //     isUsedLetter = theUsedLetters.checkIsUsedLetter(theUsedLetters.usedLetters, theLetter);
            // }

            // check if the letter is valid and has not already been used
            String result = checkLetterValidity(theUsedLetters, theUsedLetters.usedLetters, theLetter);
            while (!result.equals("valid")) {
                System.out.print(result);
                theLetter = theScanner.next().toUpperCase();
                result = checkLetterValidity(theUsedLetters, theUsedLetters.usedLetters, theLetter);
            }
            
            
            // check if user guessed correctly
            boolean isGuessCorrect = checkLetterGuess(theLetter, theWord);
            
            if (isGuessCorrect) {
                // reveal letters
                System.out.println("correct");

                // figure out how many letters to reveal
                int currNumLettersToSolve = numLettersToSolve;
                int numDuplicateLetters = getDuplicateLetters(theWord, theLetter);
                theUsedLetters.addToUsedLetters(theUsedLetters.usedLetters, theLetter);
                theUsedLetters.displayUsedLetters(theUsedLetters.usedLetters);
                displaySpaces(theWord, false);
                playGame(numLettersToSolve - numDuplicateLetters, numGuesses, theScanner, isCorrect, theWord, theUsedLetters);
            } else {
                System.out.println("incorrect");
                theUsedLetters.addToUsedLetters(theUsedLetters.usedLetters, theLetter);
                theUsedLetters.displayUsedLetters(theUsedLetters.usedLetters);
                // display a body part
                playGame(numLettersToSolve, numGuesses + 1, theScanner, isCorrect, theWord, theUsedLetters);
            }

        }
    }

    // public void assignIndeces() {

    // }

    public int getDuplicateLetters(String theWord, String theLetter) {
        int res = 0;
        int[] theSolvedIndeces = new int[0];
        String theSolvedIndecesStr = "";
        // int theSolvedIndecesCounter = 0;

        String[] wordArr = theWord.split("");

        for (int i = 0; i < wordArr.length; i++) {
            String letterInArr = wordArr[i];
            if (theLetter.equals(letterInArr)) {
                // theSolvedIndeces = new int[theSolvedIndeces.length + 1];
                theSolvedIndecesStr += i;
                theSolvedIndecesStr += ",";
                res++;
                // theSolvedIndeces[res - 1] = i;
            }
        }

        indexesOfSolvedLettersStr += theSolvedIndecesStr;

        return res;
    }

    public boolean checkLetterGuess(String theLetter, String theWord) {
        boolean result = true;

        if (theWord.contains(theLetter)) {
            result = true;
        } else {
            result = false;
        }

        return result;
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

    public void displaySpaces(String randomWord, boolean startOfGame) {
        String[] randomWordAsArr = randomWord.split("");
        // String[] indexesOfSolvedLettersArr = "";

        if (startOfGame) {

            for (int i = 0; i < randomWord.length(); i++) {
                System.out.print("___ ");
            }

        } else {

            String[] indexesOfSolvedLettersArr = indexesOfSolvedLettersStr.split(",");

            indexesOfSolvedLetters = new int[indexesOfSolvedLettersArr.length];

            for (int h = 0; h < indexesOfSolvedLetters.length; h++) {
                indexesOfSolvedLetters[h] = Integer.parseInt(indexesOfSolvedLettersArr[h]);
            }

            for (int i = 0; i < randomWord.length(); i++) {
                boolean outputLetter = false;
                String theLetterToOutput = "";

                for (int j = 0; j < indexesOfSolvedLetters.length; j++) {
                    if (i == indexesOfSolvedLetters[j]) {
                        outputLetter = true;
                        theLetterToOutput = randomWordAsArr[indexesOfSolvedLetters[j]];
                    }
                }

                if (outputLetter) {
                    System.out.print("_" + theLetterToOutput + "_ ");
                } else {
                    System.out.print("___ ");
                }
            }

        }
        
        System.out.println();
        System.out.println();
    }

    public void displayUsedLetters() {
        System.out.println();
        System.out.print("Used Letters: ");
        // Function to display used letters will go here.
        // theUsedLetters.displayUsedLetters();
        System.out.println();
        System.out.println();
    }
}