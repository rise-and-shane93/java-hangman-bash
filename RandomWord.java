public class RandomWord {

    public String[] theWords;

    public RandomWord(String[] theWords) {
        this.theWords = theWords;
    }

    // public void setRandomWords() {
    //     String[] wordsToSet = {"HELLO", "WORLD"};
    //     this.theWords = wordsToSet;
    // }

    public void displaySpaces(String[] wordsToDisplay) {
        int random = (int)(Math.random() * wordsToDisplay.length);
        for (int i = 0; i < wordsToDisplay[random].length(); i++) {
            System.out.print("___ ");
        }
        System.out.println();
        System.out.println();
    }
}