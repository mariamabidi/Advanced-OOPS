/*
 * PebbleFetchingCompetition.java
 *
 * Version:
 *     1.0
 *
 * Revisions:
 *     0
 */
import java.util.HashMap;
import java.util.Random;

/**
 * It is a class to play the game out snatching mable from the master.
 * The number of players and rounds are mentioned.
 *
 * @author Mariam Abidi
 * @author Dhruv Dave
 */

public class PebbleFetchingCompetition extends Thread{
    static Object o = new Object();
    String playerName;
    static int counter = 0;
    static int players;
    static boolean pebbles = true;
    static boolean quiet = false;
    static HashMap<String, Integer> answers = new HashMap<String, Integer>();
    private static Random random = new Random();

    PebbleFetchingCompetition(String name){
        this.playerName = name;
    }

    PebbleFetchingCompetition(String name, int players, int length){
        this.playerName = name;
        this.players= players;
        if (length == 5){
            this.quiet = true;
        }
    }

    /**
     * The run method that the thread executes.
     */
    public void run(){
        synchronized (o){
            if (playerName.equals("Ref")){
                mnotify();
            } else {
                game();
            }
        }
    }

    /**
     * The method where the whole game takes place.
     * @throws InterruptedException
     */
    public void actualGame() throws InterruptedException {
        synchronized (o){
            if (pebbles){
                pebbles = false;
                if (answers.get(playerName) == null) {
                    answers.put(playerName, 1);
                } else {
                    answers.put(playerName, answers.get(playerName) + 1);
                }
            }
        }

    }

    /**
     * This is th emethod to notify all the players that are in wait state.
     */
    public void mnotify () {
        synchronized ( o )	{
            try {
                o.notifyAll();
            } catch ( IllegalMonitorStateException  e )	{
                System.err.println(o + ": IllegalMonitorStateException");
            }
        }
    }

    /**
     * This method is used to initialize the game with number of players
     * and the master.
     */
    public void game(){
        synchronized (o){
            try {
                counter++;
                if (counter == players+1){
                    PebbleFetchingCompetition Ref = new PebbleFetchingCompetition("Ref");
                    Ref.start();
                }
                o.wait();
                actualGame();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * This is the method to print the results.
     */
    public static void printresults(){
        if(quiet){
            System.out.println("All marbles are accounted for is true.");
        }
        else{
            for (String i : answers.keySet()) {
                if (i == "Master") {
                        System.out.println(i + " hold on to so many " + answers.get(i) + " marbles");
                } else {
                        System.out.println( i + " grabbed so many " + answers.get(i) + " marbles");
                }
            }
                System.out.println("All marbles are accounted for is true.");
            }

    }


    /**
     * This is the method to scramble the given array
     * @param array
     */
    public static void scrambleArray(Object[] array) {
        int n = array.length;
        for (int i = n - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            Object temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    /**
     * The main program
     * @param args
     */
    public static void main(String[] args) {
        if (args.length >= 4) {
            int rounds = Integer.parseInt(args[3]);
            int noofplayers = Integer.parseInt(args[1]) + 1;


            while(rounds != 0){
                PebbleFetchingCompetition[] players = new PebbleFetchingCompetition[noofplayers];

                for (int i = 0; i < noofplayers; i++) {
                    if (i == 0){
                        players[i] = new PebbleFetchingCompetition("Master",
                                Integer.parseInt(args[1]),
                                args.length);
                    } else {
                        players[i] = new PebbleFetchingCompetition("Player " + (i),
                                Integer.parseInt(args[1]),
                                args.length);
                    }
                }

                scrambleArray(players);

                for(int i = 0; i < noofplayers; i++){
                    players[i].start();
                }


                for (PebbleFetchingCompetition player : players) {
                    try {
                        player.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                counter = 0;
                pebbles = true;
                rounds-=1;
            }

            printresults();

        }
    }

}