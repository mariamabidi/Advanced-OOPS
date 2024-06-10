import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DiskDump {

    /**
     * This method handles the writing of data into the new file.
     * @param filename A variable to store the name of file to write.
     * @param input A variable to store the data that needs to be copied.
     * @param skips A variable to store the number of skips.
     * @param blockSize A variable to store the block size value.
     * @throws IOException throws IOException
     */
    public static void ofCommand(String filename, String input,
                                 int skips, int blockSize) throws IOException {
        int totalSkips = skips*blockSize;
        byte[] dataBytes = input.getBytes();
        try (OutputStream newFile = new FileOutputStream(filename)){
            newFile.write(dataBytes, totalSkips, dataBytes.length-totalSkips);
        }
    }

    /**
     * This method handles the reading of data from a file.
     * @param filename A variable to store the name of file that needs to be
     *      *         read.
     * @return the data from the file
     * @throws IOException throws IOException
     */
    public static StringBuilder ifCommand(String filename) throws IOException{
        try (BufferedReader input = new BufferedReader(
                new FileReader(filename))){
            StringBuilder fileLines = new StringBuilder();
            while (input.ready()) {
                fileLines.append(input.readLine() + "\n");
            }
            return fileLines;
        }
    }


    /**
     * The main program.
     * @param args User input commands
     */
    public static void main(String[] args) {
        try {
            if (args.length == 4){
                Pattern ifPattern = Pattern.compile("if=(.*?)\\.txt");
                Pattern ofPattern = Pattern.compile("of=(.*?)\\.txt");
                Pattern skipPattern = Pattern.compile("skip=(\\d+)");
                Pattern bsPattern = Pattern.compile("bs=(\\d+)");
                Matcher ifMatcher = ifPattern.matcher(args[0]);
                Matcher ofMatcher = ofPattern.matcher(args[1]);
                Matcher skipMatcher = skipPattern.matcher(args[2]);
                Matcher bsMatcher = bsPattern.matcher(args[3]);

                // Checks if the pattern of command for if is correct
                if (ifMatcher.find()){
                    String filename = ifMatcher.group(1) + ".txt";
                    String fileContent = String.valueOf(ifCommand(filename));
                    // Checks if the pattern of command for of, bs, skip is correct
                    if (ofMatcher.find() && skipMatcher.find() && bsMatcher.find()){
                        int skips = Integer.parseInt(skipMatcher.group(1));
                        int blockSize = Integer.parseInt(bsMatcher.group(1));
                        String newFilename = ofMatcher.group(1) + ".txt";
                        assert fileContent != null;
                        ofCommand(newFilename, fileContent, skips, blockSize);
                    }
                    else {

                    }
                } else {
                    throw new Exception("\nInvalid Command");
                }
            }
            else {
                throw new Exception("\nInvalid Command");
            }
        } catch (Exception e){
            System.out.println(e);
        }
    }
}