import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * In this class we read from a file of strings.
 * Then compare it to the patterns and print out the resulting boolean.
 *
 * @author      Mariam Abidi
 * @author      Dhruv Dave
 *
 */
public class GrepRegEx {

    /**
     * The readWords method is used to read a file and detects the
     * number of words in the file.
     * It throws an exception if the file is empty.
     *
     * @param       fileName    A variable to assign the name of the file.
     *
     * @exception      e        If the file is empty, an exception is thrown.
     *
     */
    public static String[] readWords(String fileName){
        int counter = 0;
        try {
//            We use first scanner to count the number of lines.
            Scanner sc = new Scanner(new File(fileName));
//                count number of lines
            while (sc.hasNextLine()) {
                counter = counter + 1;
                sc.nextLine();
            }
            sc.close();
            String[] words = new String[counter];

//          We use the second one to add the elements to array.
            sc = new Scanner(new File(fileName));
            for (int i = 0; i < counter; i++) {
                words[i] = sc.nextLine();
            }
            sc.close();
            return words;
        }
        catch (FileNotFoundException e) {}
        return null;
    }

    public static void main(String[] args) {
        /**
         * The readWords method is used to read a file and detects the
         * number of words in the file.
         * It throws an exception if the file is empty.
         *
         * @param       words    An array of all the strings read from the file.
         *
         * @param      patterns  All the patterns that need to
         *                       be defined are stored in an array.
         *
         */

        //Here we define the patterns which we will be comparing to.

        String[] patterns = {
                //Pattern 1
                "a[^aeiou]?e[^aeiou]?i[^aeiou]?o[^aeiou]?u",
                //Pattern 2
                "^(.)(.)(.?)\\2\\1$",
                //Pattern 3
                "(.)(.?)\\1|(.)(.)(.?)\\4\\3|" +
                        "(.)(.)(.)(.?)\\8\\7\\6|" +
                        "(.)(.)(.)(.)(.?)\\13\\12\\11\\10|" +
                        "(.)(.)(.)(.)(.)(.?)\\19\\18\\17\\16|" +
                        "(.)(.)(.)(.)(.)(.)(.?)\\26\\25\\24\\23|" +
                        "(.)(.)(.)(.)(.)(.)(.)(.?)\\34\\33\\34\\31\\30\\29\\28|" +
                        "(.)(.)(.)(.)(.)(.)(.)(.)(.?)\\43\\42\\41\\40\\39\\38\\37\\36|" +
                        "(.)(.)(.)(.)(.)(.)(.)(.)(.)(.?)\\53\\52\\51\\50\\49\\48\\47\\46\\45|" +
                        "(.)(.)(.)(.)(.)(.)(.)(.)(.)(.)(.?)\\64\\63\\62\\61\\60\\59\\58\\57\\56\\55|" +
                        "(.)(.)(.)(.)(.)(.)(.)(.)(.)(.)(.)(.?)\\76\\75\\74\\73\\72\\71\\70\\69\\68\\67\\66|" +
                        "(.)(.)(.)(.)(.)(.)(.)(.)(.)(.)(.)(.)(.?)\\89\\88\\87\\86\\85\\84\\83\\82\\81\\80\\79\\78|" +
                        "(.)(.)(.)(.)(.)(.)(.)(.)(.)(.)(.)(.)(.)(.?)\\103\\102\\101\\100\\99\\98\\97\\96\\95\\94\\93\\92\\91|" +
                        "(.)(.)(.)(.)(.)(.)(.)(.)(.)(.)(.)(.)(.)(.)(.?)\\118\\117\\116\\115\\114\\113\\112\\111\\110\\109\\108\\107\\106\\105|" +
                        "(.)(.)(.)(.)(.)(.)(.)(.)(.)(.)(.)(.)(.)(.)(.)\\133\\132\\131\\130\\129\\128\\127\\126\\125\\124\\123\\122\\121\\120|" +
                        "(.)",
                //Pattern 4
                "(0[1-9]|[12][0-9]|3[01])\\/(0[1-9]|1[1,2])\\/\\d{2}|(0[1-9]|1[1,2])\\/(0[1-9]|[12][0-9]|3[01])\\/\\d{2}",
                //Pattern 5
                "\\[((\\d))\\-\\d\\]\\|\\(\\2\\d\\)"  };

        //Here we are reading the words from the patterns.txt file.
        String[] words = readWords("patterns.txt");

        //We have a for loop for comparing each word to each and
        // every pattern and then printing it out with the result.
        for ( int i = 0; i < words.length; i ++ )	{
            for ( int j = 0; j < patterns.length; j ++ )	{
                System.out.println(words[i] + " and pattern number "
                        +(j+1)+ " are " + Pattern.matches(patterns[j], words[i]));
            }
        }
    }
}
