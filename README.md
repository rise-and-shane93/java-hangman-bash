# Java Hangman - Bash
I made this fun hangman game to keep up with my Java skills. Although it is run via the terminal and not JavaFX, the game design is simple enough to recreate in the terminal.

## How to run
1. After cloning the repository, navigate to it via CMD, Bash or ZSH and run the following command:
```javac Hangman.java```
This should compile all of the program files.
2. Run the following command:
```java Hangman```
This will start up the game.

## How to stop the program
Hold the CTRL key and press the C key.

## How to add or remove words
1. Navigate to the Hangman.java file.
2. On line 7, you will see an array of words that are used in the game.
3. Feel free to add/remove words as you wish, but please ensure that all of the words are capitalized and follow the format below:
```{"HELLO", "WORLD"}```
Notice how each word is wrapped in double quote marks and separated by a comma (except for the last word).
4. Run the following commands to compile and run the game:
```javac Hangman.java```
```java Hangman```