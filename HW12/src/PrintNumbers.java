/*
 * PrintNumbers.java
 *
 * Version:
 *     1.0
 *
 * Revisions:
 *     0
 */

/**
 * It is a class that uses n numbers of threads for n number of rounds to print
 * the numbers sequentially.
 */
public class PrintNumbers extends Thread {
    private String info;
    private static int nThreads;
    private static int soOften;
    static Object o = new Object();
    private static int currentNumber = 0;
    private static int currentRound = 1;


    /**
     * A constructor for the class.
     * @param info
     */
    public PrintNumbers(String info) {
        this.info = info;
    }

    /**
     * A function that prints the numbers sequentially.
     * @throws InterruptedException
     */
    public void in_between() throws InterruptedException {
        synchronized (o){
            if (currentRound > soOften){
                return;
            }

            if (!info.equals(String.valueOf(currentNumber))){
                if (currentNumber >= nThreads){
                    currentNumber = 0;
                    currentRound +=1;
                    in_between();
                }
                else {
                    o.wait();
                    in_between();
                }
            }
            else{
                if (info.equals("0")){
                    System.out.println("# of Rounds: " + currentRound + " --------");
                }
                System.out.println(info);
                currentNumber += 1;
                o.notifyAll();
                in_between();
            }
        }
    }

    /**
     * The run function executed by every thread.
     */
    public void run() {
        synchronized (o) {
            try {
                in_between();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * The main program function.
     * @param args
     */
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Usage: java PrintNumbers -nThreads <number_of_threads> -soOften <times_to_print>");
            System.exit(1);
        }
        if (args[0].equals("-nThreads")) {
                nThreads = Integer.parseInt(args[1]);
            }
        if (args[2].equals("-soOften")) {
                soOften = Integer.parseInt(args[3]);
            }

        PrintNumbers[] threads = new PrintNumbers[nThreads];
        for (int i = 0; i < nThreads; i++) {
            threads[i] = new PrintNumbers(String.valueOf(i));
            threads[i].start();
        }

    }
}
