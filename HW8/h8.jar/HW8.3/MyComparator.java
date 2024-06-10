import java.util.Comparator;

public class MyComparator<T extends Comparable<T>> implements Comparator<T> {
    /**
     * This method is used to compare two objects.
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return An integer
     */
    @Override
    public int compare(T o1, T o2) {
        return o2.compareTo(o1);
    }
}