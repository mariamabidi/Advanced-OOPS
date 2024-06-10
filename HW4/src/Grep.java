/*
 * Grep.java
 *
 * Version:
 *     1.0
 *
 * Revisions:
 *     0
 */

/**
 * It is a class that helps to identify which string belongs to which pattern
 * by reading the file from command line.
 *
 *
 * @author      Mariam Abidi
 * @author      Dhruv Dave
 *
 */

public class Grep {
    static String userFileName;
    static String[] theWords;

    /**
     * The main program.
     *
     * @param    args    command line arguments.
     */
    public static void main(String[] args) {
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

        // A string array to store the words from the file.
        theWords = scanFile.readFile(userFileName);

        /* For Loop to check each word in the array and which pattern it
           belongs to. */
        for (String theWord : theWords) {
            if (theWord.length() == 2 && patternsMatch.pattern1(theWord.toCharArray())) {
                System.out.println("Word :" + theWord + " Pattern :^ab$ ");
            }
            if (theWord.length() >= 5 && patternsMatch.pattern2(theWord.toCharArray())) {
                System.out.println("Word :" + theWord + " Pattern :.a+b. ");
            }
            if (theWord.length() == 4 && patternsMatch.pattern3(theWord.toCharArray())) {
                System.out.println("Word :" + theWord + " Pattern :.ab. ");
            }
            if (theWord.length() == 2 && patternsMatch.pattern4(theWord.toCharArray())) {
                System.out.println("Word :" + theWord + " Pattern :^[ab]c$ ");
            }
            if (patternsMatch.pattern5(theWord.toCharArray())) {
                System.out.println("Word :" + theWord + " Pattern :^[ab]?c$ ");
            }
            if (patternsMatch.pattern6(theWord.toCharArray())) {
                System.out.println("Word :" + theWord + " Pattern :^[ab]?|c?$ ");
            }
            if (patternsMatch.pattern7(theWord.toCharArray())) {
                System.out.println("Word :" + theWord + " Pattern : ^..\\2\\1$");
            }

        }

    }
}

