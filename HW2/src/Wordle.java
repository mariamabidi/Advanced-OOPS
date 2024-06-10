/*
 * Wordle.java
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
 * It is a class that allows user to guess a five character word and displays
 * "_" if the letter is in the word but in the wrong spot.
 * "*" if the letter is in the word and correct spot.
 * "x" if the letter is not in the word.
 * The user gets only five tries to guess the word.
 *
 *
 * @author      Mariam Abidi
 * @author      Dhruv Dave
 *
 */
public class Wordle {
    static int soManyWordToPLayWith = 0;
    static final String[] theWords = new String[10231];
    static final Scanner readGuess = new Scanner(System.in);


    /**
     * The readWordsFromFile method is used to read a file and detects the
     * number of words in the file and increments soManyWordToPLayWith. It
     * throws an exception if the file is empty.
     *
     * @param       fileName    A variable to assign the name of the file.
     *
     * @exception      e        If the file is empty, an exception is thrown.
     *
     */
    public static void readWordsFromFile(String fileName) {
        try (
                BufferedReader input =
                        new BufferedReader( new FileReader(fileName));
        ) {
            int counter = 0;
            while  ( ( theWords[counter++] = input.readLine() )  != null )
                soManyWordToPLayWith ++;
        }
        catch ( Exception e )	{
            System.out.println("ExceptionType occurred: " + e.getMessage() );
        }
    }


    /**
     * The readUserInput method is used to read the user's input and store it
     * in the string guess. It checks the length of user's input if it is 5 or
     * not. If not, then asks the user to enter a word again.
     *
     */
    public static String readUserInput() {	//
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
     *
     * The getWord method is used to pick a random word from the file which
     * will be the word that the user has to guess.
     *
     */
    public static String getWord() {

        return theWords[new Random().nextInt(soManyWordToPLayWith)];
    }


    /**
     *
     * The compareWords method is used to compare each character of the user's
     * word to the random word picked from the file. It displays
     * "_" if the letter is in the word but in the wrong spot.
     * "*" if the letter is in the word and correct spot.
     * "x" if the letter is not in the word.
     * And the user gets only five tries to guess the word.
     *
     */
    public static void compareWords() {

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
     *
     * The playWordle method is used to display all the instructions to the
     * user and call the compareWords method to start the game.
     *
     */
    public static void playWordle() {
        System.out.println("_ indicates the letter is in the word but in the "
                + "wrong spot.");
        System.out.println("* indicates the letter is in the word and correct"
                + " spot.");
        System.out.println("x indicates the letter is not in the word.");
        System.out.println("Try to guess the word in 5 tries.");
        compareWords();
    }


    /**
     * The main program.
     *
     * @param    args    command line arguments.
     */
    public static void main( String args[] ) {
        // reads the text file - this file has to be in the local directory
        readWordsFromFile("5_char_word.txt");
        playWordle();
    }
}