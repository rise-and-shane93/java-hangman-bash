import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean isCorrect = true;
        String[] theWords = {"HELLO", "WORLD", "HOUSE", "COMPUTER", "BEDROOM", "MONITOR", "BICYCLE", "PORCH", "GASOLINE", "SMARTPHONE", "HOMEWORK", "SNOW", "JAVA", "COLLEGE", "UNIVERSITY", "TELEVISION", "COFFEE", "KEYBOARD", "SPEAKER"};
        printGameBoard();

        String randomWord = getRandomWord(theWords);
        RandomWord theRandomWordObj = new RandomWord(randomWord);
        UsedLetters theUsedLetters = new UsedLetters();
        // System.out.println(theRandomWordObj.randomWord);
        theRandomWordObj.displaySpaces(randomWord, true, randomWord.length());
        // theRandomWordObj.displayUsedLetters();
        theRandomWordObj.playGame(theRandomWordObj.numLettersToSolve, theRandomWordObj.numGuesses ,input, isCorrect, theRandomWordObj.randomWord, theUsedLetters);
    }

    public static void printGameBoard() {
        System.out.println();
        System.out.println("\t\tHangman");
        System.out.println();
        System.out.println("\t ________");
        System.out.println("\t|\t |");
        System.out.println("\t|\t |");
        System.out.println("\t|");
        System.out.println("\t|");
        System.out.println("\t|");
        System.out.println("\t|");
        System.out.println("\t|");
        System.out.println("\t|");
        System.out.println("  ______|______");
        System.out.println();
        System.out.println();
    }

    public static String getRandomWord(String[] theWords) {
        int random = (int)(Math.random() * theWords.length);
        String res = theWords[random];
        return res;
    }
}