import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Wc {

    /**
     * This is the main function which reads user input from the commandline.
     * It also calls other methods to perform various tasks.
     * @param args - takes in the file name and the operations needed.
     */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java Wc [-l] [-w] [-c] filename");
            return;
        }

        // Setting booleans for the options needed
        boolean ifLine = true;
        boolean ifChars = true;
        boolean ifWords = true;

        int fileIndex = 0;

        // Check which options are not needed
        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-")) {
                if (args[i].contains("l")) {
                    ifLine = false;
                }
                if (args[i].contains("c")) {
                    ifChars = false;
                }
                if (args[i].contains("w")) {
                    ifWords = false;
                }
            } else {
                fileIndex = i;
                break;
            }
        }
        String filename = args[fileIndex];

        try {
            int[] counts = countFile(filename, ifLine, ifChars, ifWords);
            printFileStatistics(counts, filename);
        } catch (IOException e) {
            System.err.println("Error! File not found: " + e);
        }
    }

    /**
     * This method reads and counts all the lines, chars, words inside
     * and returns it in form of an array.
     * @param filename - stores the name of text file
     * @param ifLine - boolean if the user need the line count.
     * @param ifChars - boolean if the user needs the characters in the file.
     * @param ifWords - boolean if the user needs the words in the file.
     * @return int array of counts
     * @throws IOException - exception if the file is not found.
     */
    private static int[] countFile(String filename, boolean ifLine, boolean ifChars, boolean ifWords) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            int noOfLines = 0;
            int characters = 0;
            int words = 0;
            String line;

            // loops the file line by line and reads and counts the file.
            while ((line = reader.readLine()) != null) {
                if (ifLine) {
                    noOfLines++;
                }
                if (ifChars) {
                    characters += line.length();
                }
                if (ifWords) {
                    String[] wordsInside = line.split("\\s+");
                    words += wordsInside.length;
                }
            }

            return new int[] { noOfLines, characters, words };
        }
    }

    /**
     * Method used for printing the required output by the user from the array
     * of answers which was passed as a parameter.
     * @param counts - array for storing the count of lines, character, words.
     * @param filename - name of the file provided by the user to print it.
     */
    private static void printFileStatistics(int[] counts, String filename) {
        // prints the lines according to the requirement
        if (counts[0] > 0) {
            System.out.print(counts[0] + " ");
        }
        if (counts[2] > 0) {
            System.out.print(counts[2] + " ");
        }
        if (counts[1] > 0) {
            System.out.print(counts[1] + " ");
        }
        System.out.println(filename);
    }
}
