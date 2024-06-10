/*
 * ConsumerProducer.java
 *
 * Version:
 *     1.0
 *
 * Revisions:
 *     0
 */
import java.util.ArrayList;
import java.util.Vector;
import java.util.Date;

/**
 * The main class representing the Consumer-Producer program.
 */
public class ConsumerProducer extends Thread {

    static int soManyC;
    static int soManyP;
    static int kValue;

    /**
     * The main method
     * @param args Command-line arguments
     */
    public static void main(String[] args)	{
        if (args.length < 4) {
            System.out.println("Usage: java ConsumerProducers " +
                    "-nConsumers <no.of.Consumers> -nProducers " +
                    "<no.of.Producers> -nkValue <nkValue>");
            System.exit(1);
        }

        soManyC = Integer.parseInt(args[1]);
        soManyP = Integer.parseInt(args[3]);
        kValue = Integer.parseInt(args[5]);

        Storage theStorage = new Storage();
        Storage.k = kValue;

        System.err.println("# producer = " + soManyP );
        System.err.println("# consumer = " + soManyC );

        for (int id = 1 ; id <= soManyP ; id ++)	{
            new Producer(id, theStorage).start();
        }
        for (int id = 1 ; id <= soManyC ; id ++)	{
            new Consumer(id, theStorage).start();
        }
    }
}

/**
 * Class representing the storage shared between producers and consumers.
 */
class Storage {
    static final int N = 100;
    static int soManyAreIn = 0;
    static int counter = 0;
    static int k = 0;
    int soMany = 0;
    private ArrayList theStorage = new ArrayList(N);
    private Object sync = new Object();

    /**
     * Method to check the integrity of the storage.
     */
    void test()	{
        if ( soManyAreIn != 1  )	{
            System.err.println("soManyAreIn " + soManyAreIn );
            System.exit(0);
        }
        if ( soMany > N  )	{
            System.err.println("overflow " + soMany );
            System.exit(0);
        }
        if ( soMany < 0 )	{
            System.err.println("underflow " + soMany );
            System.exit(0);
        }
        try {
            Thread.sleep(1000);
        } catch ( Exception e ) { }
    }


    /**
     * Method to add items to the storage.
     * @param addTheseItems A Vector of items to be added to the storage.
     */
    void addItems(Vector addTheseItems)	{
        synchronized ( sync ) {
            if(!(counter == k)){
                System.err.println("--->");
                soManyAreIn++;
                while (soMany + addTheseItems.size() > N) {
                    try {
                        System.err.println("  waiting");
                        soManyAreIn--;
                        sync.wait();
                        if (counter == k) {
                            break;
                        }
                        System.err.println("  woke up");
                        soManyAreIn++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            if (!(counter == k)){
                for (int index = 0; index < addTheseItems.size(); index++) {
                    theStorage.add(addTheseItems.elementAt(index));
                    counter++;
                    if(counter==k){
                        System.err.println("hit limit");
                        break;
                    }
                }
                soMany += addTheseItems.size();
                test();
                soManyAreIn--;
                sync.notifyAll();
                System.err.println("<---");

            }
        }
    }

    /**
     * Method to consume items from the storage.
     * @param id The ID of the consumer.
     * @return A Vector of consumed items.
     */
    Vector consume(int id)	{
        Vector aVector = new Vector(id);
        synchronized ( sync ) {
            System.err.println("	---->");
            soManyAreIn++;


                while (soMany - id < 0) {
                    try {
                        soManyAreIn--;
                        System.err.println("	 waiting ");
                        if(!(counter==k)) {
                            sync.wait();
                        }
                        if (counter == k) {
                            break;
                        }
                        System.err.println("	 woke up");
                        soManyAreIn++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            if (!(counter == k)) {
                soMany -= id;
                for (int index = 0; index < id; index++) {
                    aVector.add(theStorage.remove(0));
                }
                test();
                soManyAreIn--;
            }
                sync.notifyAll();
                System.err.println("	<---");
        }
        return aVector;
    }
}

/**
 * Class representing a consumer thread.
 */
class Consumer extends Thread {
    int id;
    Storage thisStorage;
    final int SO_MANY;

    /**
     * Constructor for the Consumer class.
     * @param id The ID of the consumer.
     * @param thisStorage The storage shared between consumers and producers.
     */
    Consumer(int id, Storage thisStorage)	{
        this.id = id;
        this.thisStorage = thisStorage;
        SO_MANY = id* 1;
        setName("Consumer: " + id );
//        System.err.println("C: " + id );
    }

    /**
     * Run method for the consumer thread.
     */
    public void run()	{
            Vector aVector = thisStorage.consume(id);
            if(!(thisStorage.counter == thisStorage.k)){
                this.run();
            }
        }
}

/**
 * Class representing a producer thread.
 */
class Producer extends Thread {
    int id;
    final int SO_MANY;
    Storage thisStorage;

    /**
     * Constructor for the Producer class.
     * @param id The ID of the producer.
     * @param thisStorage The storage shared between consumers and producers.
     */
    Producer(int id, Storage thisStorage)	{
        this.id = id;
        this.thisStorage = thisStorage;
        SO_MANY = id*  1;
        setName("Producer: " + id );
        System.err.println("P: " + id );
    }

    /**
     * Run method for the producer thread.
     */
    public void run()	{
         System.err.println("P id: " + id );
         System.err.println("P SO_MANY: " + SO_MANY );
            Vector aVector = new Vector();
            for ( int counter = 0; counter < SO_MANY; counter ++ )	{
                aVector.add(id + "_" + new Date () );
            }
            thisStorage.addItems(aVector);
            if(!(thisStorage.counter == thisStorage.k)){
                this.run();
            }
        }
}