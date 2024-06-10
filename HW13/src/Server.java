import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * The Server class represents a server for a simple word guessing game.
 */
public class Server {
    private static final int PORT = 4242;
    static int soManyWordToPLayWith = 0;
    static final String[] theWords = new String[10231];
    static String userGuess;
    static String toGuess;

    Server(String guess){
        userGuess = guess;
    }
    /**
     * The readWordsFromFile method is used to read a file and detects the
     * number of words in the file and increments soManyWordToPLayWith. It
     * throws an exception if the file is empty.
     *
     * @param       fileName    A variable to assign the name of the file.
     *
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
        toGuess = getWord();
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
     * The compareWords method is used to compare each character of the user's
     * word to the random word picked from the file. It displays
     * "_" if the letter is in the word but in the wrong spot.
     * "*" if the letter is in the word and correct spot.
     * "x" if the letter is not in the word.
     * And the user gets only five tries to guess the word.
     *
     * @return
     */
    public static StringBuilder compareWords() {

        // A variable to store the random word picked from the file.
        String theWord = toGuess;
        StringBuilder result = new StringBuilder();


            // A variable to store the user's input value.
            String usersWord = userGuess;

            /* This for loop compares each character of the user's input to the
            word picked from the file. And displays the assigned symbol. It
            exits the loop when the user has guessed the right word. If not,
            then allows the user to guess five times.*/
        for (int i=0; i<5; i++){
            if (usersWord.regionMatches(i, theWord, 0 , 1)){
                if (i==0){
                    result.append("*");
                    System.out.print("*");
                }
                else {
                    result.append("_");
                    System.out.print("_");
                }
            }
            else if (usersWord.regionMatches(i, theWord, 1 , 1)){
                if (i==1){
                    result.append("*");
                    System.out.print("*");
                }
                else {
                    result.append("_");
                    System.out.print("_");
                }
            }
            else if (usersWord.regionMatches(i, theWord, 2 , 1)){
                if (i==2){
                    result.append("*");
                    System.out.print("*");
                }
                else {
                    result.append("_");
                    System.out.print("_");
                }
            }
            else if (usersWord.regionMatches(i, theWord, 3 , 1)){
                if (i==3){
                    result.append("*");
                    System.out.print("*");
                }
                else {
                    result.append("_");
                    System.out.print("_");
                }
            }
            else if (usersWord.regionMatches(i, theWord, 4 , 1)){
                if (i==4){
                    result.append("*");
                    System.out.print("*");
                } else {
                    result.append("_");
                    System.out.print("_");
                }

            }
            else {
                result.append("x");
                System.out.print("x");
            }

        }

        return result;
    }


    /**
     * The main method that initiates the word guessing game.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args){
        try {
            System.out.println("Waiting for Clients");
            readWordsFromFile("5_char_word.txt");

            ServerSocket serverSocket = new ServerSocket(PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket.getInetAddress());

                try (
                        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
                ) {
                    String userGuess = in.readLine();
                    if (userGuess.charAt(userGuess.length() - 1) == '0'){
                        toGuess = getWord();
                    }
                    new Server(userGuess);
                    String result = String.valueOf(compareWords());
                    out.println(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}