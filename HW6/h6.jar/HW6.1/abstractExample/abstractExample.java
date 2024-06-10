/*
 * abstractExample.java
 *
 * Version:
 *     1.0
 *
 * Revisions:
 *     0
 */

import java.io.*;
import java.util.Random;
import java.util.Scanner;
/**
 * It is a class that makes a game for the users to play the game wordle.
 * It creates an abstract class to have a few compulsory methods and variables.
 *
 * @author      Mariam Abidi
 * @author      Dhruv Dave
 *
 */
abstract class abstractExample {
    /**
     * This method is where we import the words and read from a file.
     *
     */
    static int soManyWordToPLayWith = 0;
    static String[] theWords = new String[10231];
    Scanner readGuess = new Scanner(System.in);
    public static void readWordsFromFile(String fileName) {
        try (
                BufferedReader input =
                        new BufferedReader( new FileReader(fileName))
        ) {
            int counter = 0;
            while  ( ( theWords[counter++] = input.readLine() )  != null )
                soManyWordToPLayWith ++;
        }
        catch ( Exception e)	{
            System.out.println("ExceptionType occurred: " + e.getMessage() );
        }
    }

    /**
     * This method is used to get a random word from the file
     *
     * @return Returns the word string.
     */
    public static String getWord() {
        return theWords[new Random().nextInt(soManyWordToPLayWith)];
    }

    /**
     * This is an abstract method is used to take input from the user.
     *
     */
    public abstract String readUserInput();
}

/**
 * This class is used to play the actual wordle game.
 * This is a subclass that inherits features from the above abstract class.
 *
 */
class Wordle extends abstractExample{
    /**
     * This method is the abstract method overriding the superclass method
     * to read user input.
     *
     * @return Returns the user input.
     */
    @Override
    public String readUserInput() {
        String guess = "";   // A variable to store the user's input.
        do {
            System.out.print("> ");
            if  ( readGuess.hasNext() )	{
                guess = readGuess.nextLine();
            }
        }
        // Checks if the input is 5 character long.
        while ( guess.length() != 5 );
        // Returns the user's input in capitals only.
        return guess.toUpperCase();
    }
    /**
     * This method is used to compare the words from user input to
     * the actual word print the correct and incorrect positions.
     *
     */
    public void compareWords() {

        // A variable to store the random word picked from the file.
        String theWord = getWord();

        for (int m=0; m<5; m++){
            System.out.println();
            // A variable to store the user's input value.
            String usersWord = readUserInput();

            /* This for loop compares each character of the user's input to the
            word picked from the file. And displays the assigned symbol. It
            exits the loop when the user has guessed the right word. If not,
            then allows the user to guess five times.*/
            for (int i=0; i<5; i++){
                if (usersWord.regionMatches(i, theWord, 0 , 1)){
                    if (i==0){
                        System.out.print("*");
                    }
                    else {
                        System.out.print("_");
                    }
                }
                else if (usersWord.regionMatches(i, theWord, 1 , 1)){
                    if (i==1){
                        System.out.print("*");
                    }
                    else {
                        System.out.print("_");
                    }
                }
                else if (usersWord.regionMatches(i, theWord, 2 , 1)){
                    if (i==2){
                        System.out.print("*");
                    }
                    else {
                        System.out.print("_");
                    }
                }
                else if (usersWord.regionMatches(i, theWord, 3 , 1)){
                    if (i==3){
                        System.out.print("*");
                    }
                    else {
                        System.out.print("_");
                    }
                }
                else if (usersWord.regionMatches(i, theWord, 4 , 1)){
                    if (i==4){
                        System.out.print("*");
                    } else {
                        System.out.print("_");
                    }

                    /* This if condition checks if the user's has guessed the
                     correct word. */
                    if (usersWord.equals(theWord)) {
                        System.out.println();
                        System.out.println("CONGRATULATIONS, YOU WON!");
                        System.exit(1);
                    }
                }
                else {
                    System.out.print("x");
                }

                // This if condition checks the number of tries.
                if (i==4 && m==4){
                    System.out.println();
                    System.out.println("Sorry! Exhausted all tries.");
                }
            }
        }
    }

    /**
     * This method is used to display the string of how to play the games.
     *
     */
    public void playWordle() {
        System.out.println("_ indicates the letter is in the word but in the "
                + "wrong spot.");
        System.out.println("* indicates the letter is in the word and correct"
                + " spot.");
        System.out.println("x indicates the letter is not in the word.");
        System.out.println("Try to guess the word in 5 tries.");
        compareWords();
    }

    /**
     * This is the main method used to call various functions and run the game.
     *
     */
    public static void main(String[] args) {
        // reads the text file - this file has to be in the local directory
        readWordsFromFile("5_char_word.txt");
        Wordle obj = new Wordle();
        obj.playWordle();
    }
}


