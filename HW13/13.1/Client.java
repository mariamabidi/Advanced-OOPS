import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

/**
 * The Client class represents a client for a simple wordle game.
 */
public class Client {
    private static final int PORT = 4242;
    private static final String SERVER_IP = "localhost";

    static final Scanner readGuess = new Scanner(new InputStreamReader(System.in));


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
    }


    /**
     * The main method that initiates the word guessing game.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {

        try {
            System.out.println("\nClient Started");
            playWordle();

            for(int m=0; m<5; m++){
                Socket soc = new Socket(SERVER_IP, PORT);
                String userGuess = readUserInput();
                PrintWriter out = new PrintWriter(soc.getOutputStream(), true);

                if (m == 0){
                    out.println(userGuess + "0");
                } else {
                    out.println(userGuess);
                }

                BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
                String result = in.readLine();
                if (Objects.equals(result, "*****")){
                    System.out.println(result + "\nCONGRATULATIONS, YOU WON!");
                    main(null);
                }
                // This if condition checks the number of tries.
                if (m==4){
                    System.out.println(result + "\nSorry! Exhausted all tries.");
                    main(null);
                }
                System.out.println(result);
                soc.close();
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
