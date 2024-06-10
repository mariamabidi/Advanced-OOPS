/*
 * SortedStorage.java
 *
 * Version:
 *     1.0
 *
 * Revisions:
 *     0
 */

import java.util.Iterator;

/**
 * It is a class that helps to store strings and null values in a linked list.
 * Functions like toString, add, delete, find, includesNull can be implemented.
 *
 *
 * @author      Mariam Abidi
 * @author      Dhruv Dave
 *
 */

public class SortedStorage<T extends Comparable> implements Comparable, SortedStorageInterface<T> {

    public List linkedList;


    public SortedStorage(boolean b){
        linkedList = null;
    }

    /**
     * This method is used to display the string representation of the storage.
     *
     * @return Returns the string representation of the storage.
     */
    public String toString(){
        List firstNode = linkedList;
        String fullTree = "";

        // Traverses the whole facility.
        while (firstNode.nextElement != null){
            fullTree += firstNode.value + " ";
            firstNode = firstNode.nextElement;
        }
        // Checks if there are null values in the storage facility.
        if (firstNode.value == null){
            System.out.println("Null Values inside: 1");
            firstNode = firstNode.nextElement;
        }

        if (firstNode != null){
            fullTree += firstNode.value;
        }
        return fullTree;
    }

    /**
     * This method is used to add the string provided by the user in the
     * facility.
     *
     * @param x A variable to store the user input.
     * @return Returns true if the input is added successfully, otherwise false
     */
    public boolean add(T x){

        // checks if the value to be added is null
        if (x == null && linkedList != null){
            if (linkedList.value != null) {
                List newPosition = new List(x);
                newPosition.nextElement = linkedList;
                linkedList = newPosition;
                return true;
            }
        }

        // Checks if the facility itself is empty.
        else if(linkedList == null){
            linkedList = new List(x);
        }

        else{
            List firstNode = linkedList;

            // Traverses the facility to decide where to add the element.
            if(firstNode.nextElement != null) {
                while (firstNode.nextElement != null &&
                        firstNode.nextElement.value.compareTo(x) < 0) {
                    firstNode = firstNode.nextElement;
                }
            }

            // Adds the element in the right position.
            List newPosition = new List(x);
            if (firstNode.nextElement != null &&
                    firstNode.nextElement.value != x){
                newPosition.nextElement = firstNode.nextElement;
                firstNode.nextElement = newPosition;
            }
            else if (firstNode.nextElement == null){
                newPosition.nextElement = firstNode.nextElement;
                firstNode.nextElement = newPosition;
            }
        }
        return true;
    }

    /**
     * This method is used to delete the string provided by the user in the
     * facility.
     *
     *  @param x A variable to store the user input.
     *  @return Returns true if the input is deleted successfully, otherwise
     *          false
     */
    public boolean delete(T x){

        // Checks if the user input is null.
        if (x == null){
            if (linkedList != null && linkedList.value == null){
                linkedList = linkedList.nextElement;
                return true;
            }
        }

        //Checks if there is anything to delete.
        else if (linkedList == null){
            return false;
        }
        else {
            List firstNode = linkedList;
            if(linkedList != null && linkedList.value == x){
                linkedList = linkedList.nextElement;
                return true;
            }
            // Traverses the whole facility to find the element
            while (firstNode.nextElement != null &&
                    firstNode.nextElement.value.compareTo(x) < 0) {
                firstNode = firstNode.nextElement;
            }
            if (firstNode.nextElement != null &&
                    firstNode.nextElement.value == x){
                if (firstNode.nextElement.nextElement != null){
                    firstNode.nextElement =
                            firstNode.nextElement.nextElement;
                    return true;
                }
                else {
                    firstNode.nextElement = null;
                    return true;
                }
            }

        }
        return false;
    }

    /**
     * This method is used to find the string provided by the user in the
     * facility.
     *
     *  @param x A variable to store the user input.
     *  @return Returns true if the input is found successfully, otherwise
     *          false
     */
    public boolean find(T x){

        // Checks if the user input is null.
        if (x == null){
            if (linkedList != null && linkedList.value == x){
                return true;
            }
        }

        // Checks if the user input is present in the facility
        else {
            List firstNode = linkedList;
            while (firstNode != null ){
                if(firstNode.value == x ){
                    return true;
                }
                firstNode = firstNode.nextElement;
            }
        }
        return false;
    }

    /**
     * This method is used to find if there is null in the facility.
     *
     * @return Returns true if null is found successfully, otherwise
     *          false
     */
    public boolean includesNull(){
        if (linkedList != null && linkedList.value == null){
            return true;
        }
        else if (linkedList == null){
            return false;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new myIterator<>();
    }

    private class myIterator<T> implements Iterator<T>{

        @Override
        public boolean hasNext() {
            if (linkedList != null){
                if (linkedList.value == null && linkedList.nextElement == null){
                    return false;
                } else {
                    return true;
                }
            } else {
                return false;
            }

        }

        @Override
        public T next() {
            List next_element = linkedList;
            if(next_element.value == null){
                linkedList = linkedList.nextElement;
                next_element = linkedList;
            }
            linkedList = linkedList.nextElement;
            return (T) next_element.value;
        }

        @Override
        public void remove(){
        }
    }

    public int getLengthOfList(List linkedList){
        int length = 0;
        while (linkedList.nextElement != null){
            length++;
            linkedList = linkedList.nextElement;
        }
        return length;
    }

    public int compareTo(SortedStorage s){
        int l1 = getLengthOfList(s.linkedList);
        int l2 = getLengthOfList(this.linkedList);
        if (l1 == l2){
            return 0;
        } else if (l1 < l2) {
            return -1;
        }else {
            return 1;
        }
    }

    /**
     * The main program.
     *
     * @param    args    command line arguments.
     */
    public static void main(String[] args) {
        SortedStorage s = new SortedStorage(false);
        s.add("1");
        s.add("2");
        s.add("3");
        s.add("3");
//        s.add(null);
        System.out.println(s.toString());
        System.out.println(s.delete("1"));
//        System.out.println(s.toString());
        System.out.println(s.find("1"));
//        System.out.println(includesNull());

    }

    @Override
    public int compareTo(Object o) {
        SortedStorage s = (SortedStorage) o;
        int l1 = getLengthOfList(s.linkedList);
        int l2 = getLengthOfList(this.linkedList);
        if (l1 == l2){
            return 0;
        } else if (l1 < l2) {
            return -1;
        } else {
            return 1;
        }
    }
}


/**
 * It is a class to store linked list elements.
 */
class List<T extends Comparable<T>> implements Comparable<List<T>>{
    T value;
    List nextElement;
    List(T element){
        value = element;
        nextElement = null;

    }
    @Override
    public int compareTo(List<T> other) {
        return 0;
    }
}
