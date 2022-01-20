public class Hangman {
    public static void main(String[] args) {
        String[] theWords = {"HELLO", "WORLD"};
        printGameBoard();

        String randomWord = getRandomWord(theWords);
        RandomWord theRandomWordObj = new RandomWord(randomWord);
        theRandomWordObj.displaySpaces(randomWord);
        theRandomWordObj.displayUsedLetters();
        // theRandomWordObj.playGame(theRandomWordObj.numLettersToSolve);
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