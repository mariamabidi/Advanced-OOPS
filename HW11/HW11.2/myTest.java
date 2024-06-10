import java.util.Iterator;

/**
 * It is a class that helps to understand that two threads cannot
 * modify the same object at the same time.
 *
 *
 * @author      Mariam Abidi
 * @author      Dhruv Dave
 *
*/

public class myTest extends Thread {

    /**
     * The main program.
     *
     * @param    args    command line arguments.
     */
    public static void main(String[] args) throws InterruptedException {
        SortedStorage<Integer> aStorageInterfaceInteger =
                new SortedStorage<Integer>(false);
        Iterator<Integer> aIterator =  aStorageInterfaceInteger.iterator();
        Thread toAdd = new Thread(() -> aStorageInterfaceInteger.add(1));
        Thread toAdd2 = new Thread(() -> aStorageInterfaceInteger.add(2));
        Thread toDelete = new Thread(() -> aStorageInterfaceInteger.delete(1));
        Thread toDelete2 = new Thread(() ->aStorageInterfaceInteger.delete(3));
        Thread toFind = new Thread(() -> aStorageInterfaceInteger.find(1));
        Thread toIterate = new Thread(aIterator::hasNext);
        Thread toIterateNext = new Thread(aIterator::next);

        toAdd.start();
        Thread.sleep(1000);
        toAdd2.start();
        toDelete.start();
        toDelete2.start();
        Thread.sleep(1000);
        toFind.start();
        Thread.sleep(1000);
        toIterate.start();
        Thread.sleep(1000);
        toIterateNext.start();

    }


}
