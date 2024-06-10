import java.util.Iterator;

public class TestNonSet {
    public static void testInteger0(SortedStorageInterface<Integer> aStorageInterfaceInteger)	{
        System.out.println("Test 0");
        Iterator<Integer> aIterator =  aStorageInterfaceInteger.iterator();
        aStorageInterfaceInteger.add(null);

        aStorageInterfaceInteger.add(Integer.valueOf("2"));
        aStorageInterfaceInteger.add(Integer.valueOf("3"));
        aStorageInterfaceInteger.add(Integer.valueOf("4"));
        System.out.println("3: " + aStorageInterfaceInteger);
        while ( aIterator.hasNext() )
            System.out.println("in Test: " + aIterator.next());
        aStorageInterfaceInteger.add(Integer.valueOf("5"));
    }
    public static void testInteger1(SortedStorageInterface<Integer> aStorageInterfaceInteger)	{
        System.out.println("Test 2");
        Iterator<Integer> aIterator =  aStorageInterfaceInteger.iterator();

        aStorageInterfaceInteger.add(Integer.valueOf("1"));
        aStorageInterfaceInteger.add(Integer.valueOf("2"));
        aStorageInterfaceInteger.add(Integer.valueOf("3"));
        aIterator.hasNext();
        aIterator.remove();
        System.out.println("in Test removed: " + aIterator.next());
        while ( aIterator.hasNext() )
            System.out.println("in Test: " + aIterator.next());
    }
    public static void testInteger2(SortedStorageInterface<Integer> aStorageInterfaceInteger) throws StorageHasBeenModifiedException {
        System.out.println("Test 1");
        Iterator<Integer> aIterator =  aStorageInterfaceInteger.iterator();

        aStorageInterfaceInteger.add(Integer.valueOf("1"));
        aStorageInterfaceInteger.add(Integer.valueOf("2"));

        /* Stores the toString value of the collection just before
         hasNext method */
        String old_toString = aStorageInterfaceInteger.toString();
        aIterator.hasNext();
        aStorageInterfaceInteger.add(Integer.valueOf("3"));

        /* Stores the toString value of the collection after
         hasNext method */
        String new_toString = aStorageInterfaceInteger.toString();
        System.out.println("in Test: " + aIterator.next());

        /* Checks if the value before and after hasNext has been changed or not
         and throws error accordingly. */
        if (!old_toString.equals(new_toString)){
            throw new StorageHasBeenModifiedException("Storage was Modified.");
        }
        System.out.println("This line should not be printed");

    }
    public static void main(String args[] )	{
        try {
            SortedStorageInterface<Integer> aStorageInterfaceInteger = new SortedStorageNonSet<Integer>(false);
            testInteger0(aStorageInterfaceInteger);

            aStorageInterfaceInteger = new SortedStorageNonSet<Integer>(false);
            testInteger1(aStorageInterfaceInteger);

            aStorageInterfaceInteger = new SortedStorageNonSet<Integer>(false);
            testInteger2(aStorageInterfaceInteger);

        } catch ( StorageHasBeenModifiedException e )	{
            System.out.println(e);
        }
    }
}