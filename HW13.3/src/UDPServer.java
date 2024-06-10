import java.io.BufferedReader;
import java.io.FileReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

/**
 * The UDPServer class represents a server for a simple word guessing game using UDP.
 */
public class UDPServer {
    private static final int PORT = 4242;
    private static int soManyWordToPLayWith = 0;
    private static final String[] theWords = new String[10231];
    private static String userGuess;
    private static String toGuess;

    /**
     * Constructor for UDPServer class.
     *
     * @param guess The user's guess for the word.
     */
    UDPServer(String guess) {
        userGuess = guess;
    }

    /**
     * Reads words from a file and initializes the game.
     *
     * @param fileName The name of the file containing words.
     */
    public static void readWordsFromFile(String fileName) {
        try (BufferedReader input = new BufferedReader(new FileReader(fileName))) {
            int counter = 0;
            while ((theWords[counter++] = input.readLine()) != null)
                soManyWordToPLayWith++;
        } catch (Exception e) {
            System.out.println("ExceptionType occurred: " + e.getMessage());
        }
        toGuess = getWord();
    }

    /**
     * Gets a random word from the list of available words.
     *
     * @return A randomly selected word.
     */
    public static String getWord() {
        return theWords[new Random().nextInt(soManyWordToPLayWith)];
    }

    /**
     * Compares the user's guess with the correct word and generates a result string.
     *
     * @return A StringBuilder object representing the result of the word comparison.
     */
    public static StringBuilder compareWords() {
        String theWord = toGuess;
        StringBuilder result = new StringBuilder();

        String usersWord = userGuess;

        for (int i = 0; i < 5; i++) {
            if (usersWord.regionMatches(i, theWord, 0, 1)) {
                if (i == 0) {
                    result.append("*");
                    System.out.print("*");
                } else {
                    result.append("_");
                    System.out.print("_");
                }
            } else if (usersWord.regionMatches(i, theWord, 1, 1)) {
                if (i == 1) {
                    result.append("*");
                    System.out.print("*");
                } else {
                    result.append("_");
                    System.out.print("_");
                }
            } else if (usersWord.regionMatches(i, theWord, 2, 1)) {
                if (i == 2) {
                    result.append("*");
                    System.out.print("*");
                } else {
                    result.append("_");
                    System.out.print("_");
                }
            } else if (usersWord.regionMatches(i, theWord, 3, 1)) {
                if (i == 3) {
                    result.append("*");
                    System.out.print("*");
                } else {
                    result.append("_");
                    System.out.print("_");
                }
            } else if (usersWord.regionMatches(i, theWord, 4, 1)) {
                if (i == 4) {
                    result.append("*");
                    System.out.print("*");
                } else {
                    result.append("_");
                    System.out.print("_");
                }
            } else {
                result.append("x");
                System.out.print("x");
            }
        }

        return result;
    }

    /**
     * The main method that runs the UDP Server for the word guessing game.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        try {
            System.out.println("Waiting for Clients");
            readWordsFromFile("5_char_word.txt");

            DatagramSocket serverSocket = new DatagramSocket(PORT);

            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                String userGuess = new String(receivePacket.getData(), 0, receivePacket.getLength());

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                if (userGuess.charAt(userGuess.length()-1) == '0'){
                    toGuess = getWord();
                    new UDPServer(userGuess.substring(0, userGuess.length()-1));
                    System.out.println(toGuess);
                    System.out.println(userGuess.substring(0, userGuess.length()-1));
                } else {
                    new UDPServer(userGuess);
                    System.out.println(toGuess);
                    System.out.println(userGuess);
                }
                String result = String.valueOf(compareWords());

                byte[] sendData = result.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}