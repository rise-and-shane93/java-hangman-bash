public class Hangman {
    public static void main(String[] args) {
        String[] theWords = {"HELLO", "WORLD"};
        printGameBoard();

        RandomWord theRandomWord = new RandomWord(theWords);
        theRandomWord.displaySpaces(theRandomWord.theWords);
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
}