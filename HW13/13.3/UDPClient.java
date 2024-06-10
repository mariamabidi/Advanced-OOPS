import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Objects;
import java.util.Scanner;

/**
 * The UDPClient class represents a client for a simple wordle game using UDP.
 */
public class UDPClient {
    private static final int PORT = 4242;
    private static final String SERVER_IP = "localhost";
    private static final Scanner readGuess = new Scanner(new InputStreamReader(System.in));

    /**
     * Reads user input for the word guessing game.
     *
     * @return A string representing the user's guess.
     */
    public static String readUserInput() {
        String guess = "";
        do {
            System.out.print("> ");
            if (readGuess.hasNext()) {
                guess = readGuess.nextLine();
            }
        } while (guess.length() != 5);
        return guess.toUpperCase();
    }

    /**
     * Displays instructions for playing the word guessing game.
     */
    public static void playWordle() {
        System.out.println("_ indicates the letter is in the word but in the wrong spot.");
        System.out.println("* indicates the letter is in the word and correct spot.");
        System.out.println("x indicates the letter is not in the word.");
        System.out.println("Try to guess the word in 5 tries.");
    }

    /**
     * The main method that initiates the word guessing game using UDP.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        try {
            System.out.println("Client Started");
            playWordle();

            for (int m = 0; m < 5; m++) {
                DatagramSocket socket = new DatagramSocket();
                String userGuess = readUserInput();

                if (m == 0){
                    userGuess = userGuess + "0";
                }

                byte[] sendData = userGuess.getBytes();
                InetAddress serverAddress = InetAddress.getByName(SERVER_IP);
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, PORT);
                socket.send(sendPacket);

                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);

                String result = new String(receivePacket.getData(), 0, receivePacket.getLength());

                if (Objects.equals(result, "*****")) {
                    System.out.println(result + "\nCONGRATULATIONS, YOU WON!");
                    main(null);
                }

                if (m == 4) {
                    System.out.println(result + "\nSorry! Exhausted all tries.");
                    main(null);
                }

                System.out.println(result);
                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
