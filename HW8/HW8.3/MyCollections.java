import java.util.Comparator;
import java.util.LinkedList;

public class MyCollections {
    /**
     * This method is the sorting algorithm which is a bubble sort.
     * @param list A variable to store the collection.
     * @param c A variable which is a comparator.
     * @param <T> This is the return type
     */
    public static <T> void sort(MyList<T> list, Comparator<? super T> c) {
        if (list != null && list.l1 != null) {
            LinkedList<T> linkedList = list.l1;

            int n = linkedList.size();
            boolean swapped;
            do {
                swapped = false;
                for (int i = 1; i < n; i++) {
                    if (c.compare(linkedList.get(i - 1), linkedList.get(i)) > 0) {
                        // Swap the elements
                        T temp = linkedList.get(i - 1);
                        linkedList.set(i - 1, linkedList.get(i));
                        linkedList.set(i, temp);
                        swapped = true;
                    }
                }
                n--;
            } while (swapped);
        }
    }

    /**
     * This method is the sorting algorithm which is a bubble sort.
     * @param list A variable to store the collection.
     * @param <T> This is the return type
     */
    public static <T extends Comparable<? super T>> void sort(MyList<T> list) {
        if (list != null && list.l1 != null) {
            LinkedList<T> linkedList = list.l1;

            int n = linkedList.size();
            boolean swapped;
            do {
                swapped = false;
                for (int i = 1; i < n; i++) {
                    if (linkedList.get(i - 1).compareTo(linkedList.get(i)) > 0) {
                        // Swap the elements
                        T temp = linkedList.get(i - 1);
                        linkedList.set(i - 1, linkedList.get(i));
                        linkedList.set(i, temp);
                        swapped = true;
                    }
                }
                n--;
            } while (swapped);
        }
    }
}

