public class UsedLetters {

    public String[] usedLetters;

    public UsedLetters() {
        this.usedLetters = new String[0];
    }

    public void displayUsedLetters(String[] theUsedLetters) {
        System.out.print("Used letters: ");
        if (theUsedLetters.length != 0) {
            for (int i = 0; i < theUsedLetters.length; i++) {
                System.out.print(theUsedLetters[i] + " ");
            }
        } else {
            System.out.print("(None)");
        }
        
        System.out.println();
        System.out.println();
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

    public void addToUsedLetters(String[] currUsedLetters, String theNewLetter) {
        boolean isUniqueLetter = true;
        String[] res = new String[currUsedLetters.length];

        if (currUsedLetters.length != 0) {
            for (int i = 0; i < currUsedLetters.length; i ++) {
                if (theNewLetter.equals(currUsedLetters[i])) {
                    isUniqueLetter = false;
                }
            }
        }

        if (isUniqueLetter) {
            res = new String[currUsedLetters.length + 1];

            for (int j = 0; j < res.length; j++) {
                if (j < currUsedLetters.length) {
                    res[j] = currUsedLetters[j];
                } else {
                    res[j] = theNewLetter;
                }
            }
        } else {
            for (int j = 0; j < res.length; j++) {
                res[j] = currUsedLetters[j];
            }
        }

        this.usedLetters = res;

    }

}