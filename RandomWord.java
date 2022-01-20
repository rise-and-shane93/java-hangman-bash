public class RandomWord {

    public String randomWord;
    public int numLettersToSolve;
    public int numGuesses;

    public RandomWord(String randomWord) {
        this.randomWord = randomWord;
        this.numLettersToSolve = randomWord.length();
        this.numGuesses = 0;
    }

    public void playGame(int numLettersToSolve) {
        if (numLettersToSolve == 0) {
            // display congrats message, non-base case
            return;
        } else if (numGuesses == 3) {
            // display message saying you lost, non-base case
            return;
        } else {
            // play the game, non-base case
        }
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