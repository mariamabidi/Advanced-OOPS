import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyScramble {

    /**
     * This is method to scramble the file provided and create a new file with
     * the scrambled content.
     * @param filename A variable to store the name of file to read.
     * @param newFileName A variable to store the name of file to store
     *                    scrambled data.
     * @throws IOException throws IOException.
     */
    public static void scrambleFile(String filename, String newFileName)
            throws IOException {
        try (BufferedReader input = new BufferedReader
                (new FileReader(filename)))
        {
            StringBuilder fileLines = new StringBuilder();

            while (input.ready()) {
                fileLines.append((char)input.read());
            }

            String scrambledString = fileLines.reverse().toString();

            try (OutputStream newFile = new FileOutputStream(newFileName)){
                newFile.write(scrambledString.getBytes());
            }

        } catch (FileNotFoundException e){
            System.out.println(e);
        }
    }

    /**
     * This is a method to descramble a given file.
     * @param filename A variable to store the name of file to read.
     * @param newFileName A variable to store the name of file to store
     *      *            descrambled data.
     * @throws IOException throws IOException.
     */
    public static void descrambleFile(String filename, String newFileName)
            throws IOException {
        try (BufferedReader input = new BufferedReader
                (new FileReader(filename)))
        {
            StringBuilder fileLines = new StringBuilder();

            while (input.ready()) {
                fileLines.append((char)input.read());
            }

            String descrambledString = fileLines.reverse().toString();

            try (OutputStream newFile = new FileOutputStream(newFileName)){
                newFile.write(descrambledString.getBytes());
            }

        } catch (FileNotFoundException e){
            System.out.println("Invalid Filename");
        }
    }

    /**
     * The main program.
     * @param args user given commands
     */
    public static void main(String[] args) {
        try {
            if (args.length == 4){
                Pattern pattern = Pattern.compile("(.*?)\\.txt");
                Pattern arrowPattern = Pattern.compile(">");
                Matcher inputMatcher = pattern.matcher(args[1]);
                Matcher outputMatcher = pattern.matcher(args[3]);
                Matcher matcher = arrowPattern.matcher(args[2]);
                if (inputMatcher.find() && outputMatcher.find() && matcher.find()) {
                    if (args[0].equals("-scramble")) {
                        String filename = args[1];
                        String newFilename = args[3];
                        scrambleFile(filename, newFilename);
                    } else if (args[0].equals("-descramble")) {
                        String filename = args[1];
                        String newFilename = args[3];
                        descrambleFile(filename, newFilename);
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
