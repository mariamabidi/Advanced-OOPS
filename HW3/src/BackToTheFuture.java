/*
 * BackToTheFuture.java
 *
 * Version:
 *     1.0
 *
 * Revisions:
 *     0
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 * It is a class that allows user to guess a word character by character. For
 * every wrong guess a part of the scene, on screen, disappears. The user gets
 * only nine wrong guesses.
 *
 *
 * @author      Mariam Abidi
 * @author      Dhruv Dave
 *
 */

public class BackToTheFuture {
    static String[] theWords;
    static Scanner guess = new Scanner(System.in);
    static String userFileName;

    /**
     * This method is used to scan a file and store every line of the file in a
     * string array.
     *
     * @param filename A variable to store the name of the file.
     * @return  Returns the string array with the file contents.
     */
    private static String[] scanFile(String filename){
        int ctr = 0; // Stores the number of lines in the file.
        try (BufferedReader input =
                     new BufferedReader(new FileReader(filename)))
        {
            while  (input.readLine() != null ) {
                ctr+=1;
            }
        }
        catch ( Exception e )	{
            System.out.println("ExceptionType occurred: " + e.getMessage() );
        }

        //Creates a string array with the length equal to the number of lines.
        String[] file = new String[ctr];
        if (ctr!=0){
            try (BufferedReader input = new BufferedReader(
                    new FileReader(filename))) {
                int i  = 0;
                while  ( i < ctr) {
                    file[i] = input.readLine();
                    i+=1;
                }
            }
            catch ( Exception e )	{
                System.out.println("ExceptionType occurred:"+  e.getMessage());
            }
        }

        // Returns the string array.
        return file;
    }


    /**
     * This method is used to pick a random word from the dictionary for the
     * user to guess.
     *
     * @return Returns a string which is the random word picked from the
     * dictionary.
     */
    public static String getWord() {
        return theWords[new Random().nextInt(theWords.length)];
    }

    /**
     * This method is used to update the string array and remove the word which
     * has been once chosen.
     * @param wordArray A variable to store a string array.
     * @param usedWord  A variable to store the used chosen word.
     * @return
     */
    private static String[] removedCharacterArray(String[] wordArray, String usedWord){
        String[] updatedArray = new String[wordArray.length-1];

        for (int indexNumber=0; indexNumber < wordArray.length; indexNumber++){
            if (!Objects.equals(theWords[indexNumber], usedWord)){
                updatedArray[indexNumber] = theWords[indexNumber];
            }
        }
        return updatedArray;
    }


    /**
     * This method is used to get the user's input.
     *
     * @return If user input is found, the input is returned else an empty
     * string is returned.
     */
    public static String readUserInput() {
        if (guess.hasNext()) {
            return guess.nextLine();
        }
        return "";
    }


    /**
     * This method prints the scene according to the number of wrong guesses.
     *
     * @param car  A variable to store the array containing the scene.
     * @param wrongGuess A variable to store the number of wrong guesses.
     */
    private static void printScene(String[] car, int wrongGuess) {
        if (wrongGuess < car.length) {
            for (int i = wrongGuess; i < car.length; i++) {
                System.out.println(car[i]);
            }
        }
    }


    /**
     * The main program.
     *
     * @param    args    command line arguments.
     */
    public static void main( String args[] ) {

        boolean codeBreak = false;

        // This if statements checks if a command line argument is given.
        if (args.length == 1) {

            /* if a file name is given by user then it is stored inside the
            variable userFileName. */
            userFileName = args[0];
        } else {

            // If a file name is not provided, an error is thrown.
            codeBreak = true;
            System.out.println("CommandLine input error!");
        }
        theWords = scanFile(userFileName);

        while (!codeBreak) {
            if(theWords.length == 0){
                break;
            }
            int count = 0;

            // Prints the file name containing the random chosen word.
            System.out.println("Filename: " + userFileName);


            // Stores the random chosen word in a string variable.
            String theWord = getWord();

            /* A character array is created with the length equal to the chosen
             word's length. */
            char[] rightGuess = new char[theWord.length()];
            StringBuilder wordBuild = new StringBuilder();

            /*
            A for loop to create modify the wordBuild, that assigns the
            character at the specified index else appends a dot.
             */
            for (int m = 0; m < rightGuess.length; m++) {
                if (!Character.isWhitespace(rightGuess[m])) {
                    wordBuild.append(".");
                } else {
                    wordBuild.append(rightGuess[m]);
                }
            }

            String[] Car = scanFile("scene.txt");
            String usersChar = "";
            boolean gameOver = false;
            while (!gameOver) {
                printScene(Car, count);
                System.out.println("Wrong Guesses: " + count + " The Word: "
                        + wordBuild);
                System.out.print("Guess a word: ");
                usersChar = readUserInput();

                boolean charFound = false;

                /* for loop to check if the user input is present in the chosen
                 word. */
                for (int d = 0; d < theWord.length(); d++) {
                    if (usersChar.regionMatches(0, theWord, d, 1)) {
                        wordBuild.setCharAt(d, usersChar.charAt(0));
                        charFound = true;
                    }
                }

                /* Increases the count of wrong guesses if the user's character
                 is not present in the chosen word. */
                if (!charFound) {
                    count += 1;
                }

                // If loop to check the number of wrong guesses.
                if(count > 9){
                    System.out.println("Better luck next time :p");
                    gameOver = true;
                }

                // Checks if the completed matches the chosen word.
                else if(theWord.contentEquals(wordBuild)) {
                    System.out.println("Yay!!! You won!!!");
                    gameOver = true;
                }
            }

            // Updated the String array by removing the used word.
            if(theWords.length>=1){
                theWords = removedCharacterArray(theWords,theWord);
            }
            else {
                codeBreak = true;
            }
        }
    }
}
