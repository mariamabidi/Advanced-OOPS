import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The Server class represents a server for a simple word guessing game.
 */
public class Server {
    private static final int PORT = 4242;
    private static final int THREAD_POOL_SIZE = 10;

    private static int soManyWordToPLayWith = 0;
    private static final String[] theWords = new String[10231];
    private static String toGuess;

    private static class ClientHandler implements Runnable {
        private Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        /**
         * The run method
         */
        @Override
        public void run() {
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
            ) {
                String userGuess = in.readLine();
                if(userGuess.charAt(userGuess.length() -1)== '0'){
                    toGuess = getWord();
                }
                System.out.println("\nReceived guess from " + clientSocket.getInetAddress() + ": " + userGuess);

                String result = compareWords(userGuess).toString();
                out.println(result);

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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
    public static StringBuilder compareWords(String userGuess) {
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
            } else if (usersWord.regionMatches(i, theWord, 1 , 1)){
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

            } else {
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
    public static void main(String[] args) {
        try {
            System.out.println("Waiting for Clients");
            readWordsFromFile("5_char_word.txt");

            ServerSocket serverSocket = new ServerSocket(PORT);

            ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

            try {
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("\nAccepted connection from " + clientSocket.getInetAddress());

                    // Handle each client connection in a separate thread
                    executorService.submit(new ClientHandler(clientSocket));
                }
            } finally {
                serverSocket.close();
                executorService.shutdown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}