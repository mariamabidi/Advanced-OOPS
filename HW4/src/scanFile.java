import java.io.BufferedReader;
import java.io.FileReader;

/**
 * It is a class to read words from a file.
 *
 *
 * @author      Mariam Abidi
 * @author      Dhruv Dave
 *
 */
public class scanFile {
    static String[] readFile(String filename){
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
}
