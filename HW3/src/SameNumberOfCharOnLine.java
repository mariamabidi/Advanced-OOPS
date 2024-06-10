import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * In this class we read from a file of strings.
 * Then we apply operations to remove the spaces and convert it lowercase.
 * We sort the characters and then sort the strings according to first sort.
 * After sorting we print out the original statements.
 *
 * @author      Mariam Abidi
 * @author      Dhruv Dave
 *
 */

class SameNumberOfCharOnLine {

    /**
     * The method printStringArray is used to print various arrays.
     * We used this function multiple times in our
     * development to the track progress.
     *
     * @param       arrayToPrint    The array we need to print.
     *
     */
    public static void printStringArray(String[] arrayToPrint){
        for(int o=0; o< arrayToPrint.length; o++){
            System.out.println(arrayToPrint[o]);
        }
    }

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
            //We use first scanner to count the number of lines.
            Scanner sc = new Scanner(new File(fileName));

            //count number of lines
            while (sc.hasNextLine()) {
                counter = counter + 1;
                sc.nextLine();
            }
            sc.close();
            String[] words = new String[counter];

            //We use the second one to add the elements to array.
            sc = new Scanner(new File(fileName));
            for (int i = 0; i < counter; i++) {
                words[i] = sc.nextLine();
            }
            sc.close();
            return words;
        }
        catch (FileNotFoundException e) {
        }
        return null;
    }
    /**
     * The sortlist method is used to sort the string/array.
     * It has two nested for loops for traversing and comparing the
     * two elements that we need to compare.
     * Once an element higher than the first one is found we replace it.
     *
     * @param       tosort    A variable for the string/array to be sorted.
     *
     */
    public static String[] sortlist(String[] toSort) {
        String rep;
        String[] forsort = Arrays.copyOf(toSort, toSort.length);
        for (int x = 0; x < forsort.length; x++) {
            for (int y = x + 1; y < forsort.length; y++) {
                if (forsort[x].compareTo(forsort[y]) > 0) {

                    // replacing the elements according to the hierarchy.
                    rep = forsort[x];
                    forsort[x] = forsort[y];
                    forsort[y] = rep;

                }
            }
        }
        return forsort;
    }


    /**
     * The lowercase method is used to remove whitespaces and
     * convert the uppercase characters to lowercase by traversing
     * in a loop.
     *
     */
    public static String[] lowercase(String[] words) {
        String[] newWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            // converting to lowercase  and next to remove whitespace.
            newWords[i] = words[i].toLowerCase();
            newWords[i] = newWords[i].replaceAll(" ", "");
        }
        return newWords;
    }


    /**
     * The main method is used to call various function from the file.
     *
     *
     *
     */
    public static void main(String[] args)

    {
        String[] words = readWords("words.txt");
        String[] cleanedWords = lowercase(words);
        // We create a copy of the orignal words for back tracking.
        String[] sortedWords = new String[words.length];

        // We convert the copy to characters before sorting.
        for(int i=0; i< cleanedWords.length; i++){
            char forsort[] = cleanedWords[i].toCharArray();

            String[] stringForSort = new String[forsort.length];
            // here we add the characters to string array to sort them.
            for (int j = 0; j < forsort.length; j++) {
                stringForSort[j] = "" + forsort[j];
            }
            // sorting
            String[] sortedString = sortlist(stringForSort);
            //converting back to char array
            for (int j = 0; j < sortedString.length; j++) {
                forsort[j] = sortedString[j].charAt(0);
            }
            // stored in a new string
            String sortString = new String(forsort);
            sortedWords[i] = (sortString);
        }
        //   Sort for the second time
        String[] secondSort = sortlist(sortedWords);

        /*
        We check the values of the secondsort array to sortedwords
        for backtracking to the original strings. */
        for(int i=0; i< secondSort.length; i++){
            for(int j=0; j < sortedWords.length; j++){
                if (secondSort[i] == sortedWords[j]){
                    System.out.println(words[j]);
                }
            }
        }

    }

}