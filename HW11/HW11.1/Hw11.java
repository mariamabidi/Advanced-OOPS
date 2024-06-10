/**
 * This is a class to understand threads.
 *
 * @author: Mariam Abidi
 * @author: Dhruv Dave
 */
public class Hw11 extends Thread {

    private String info;
    static Object o = new Object();
    public Hw11 (String info) {
        this.o = new Object();
        this.info    = info;
    }


    /**
     * The run method which a ready to run thread executes.
     */
    public void run () {
        synchronized ( o ) {
            o.notify();
            System.out.println(info);
            /*
            Before modification, the program would not terminate.
            It would enter the wait method and no other thread calls the
            notify method. Hence, we have added an if condition with the sleep
            statement to make the probability of the program to terminate
            higher.
             */
            if(info == "0") {
                try {
                    Thread.sleep(1000);
                    o.wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * The main program
     * @param args command line arguments
     */
    public static void main (String args []) {
        new Hw11("0").start();
        new Hw11("1").start();
    }
}