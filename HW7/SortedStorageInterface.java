/**
 * This interface provides the structure for sortedstorage
 * functions like tostring, add, delete, find, includesnull
 * using generics.
 *
 */
public interface SortedStorageInterface <T> {

    String toString();

    boolean add(T x);

    boolean delete(T x);

    boolean find(T x);

    boolean includesNull();

}
