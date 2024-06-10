/*
 * SortedStorage.java
 *
 * Version:
 *     1.0
 *
 * Revisions:
 *     0
 */

/**
 * It is a class that helps to store strings, integers and SortedStorage
 * in a linked list.
 * Functions like toString, add, delete, find, includesNull can be implemented.
 *
 *
 * @author      Mariam Abidi
 * @author      Dhruv Dave
 *
 */
public class SortedStorage {

    public ListString linkedList;
    public ListInt linkedListInt;
    public ListSS linkedListSS;

    public SortedStorage(){
        linkedList = null;
    }

    /**
     * This method is used to display the string representation of the storage.
     *
     * @return Returns the string representation of the storage.
     */
    public String toString(){
        ListString firstNodeString = null;
        ListInt firstNodeInt = null;
        ListSS firstNodeSS = null;

        if (linkedListInt != null) {
            firstNodeInt = linkedListInt;
            String fullTree = "";

            // Checks if there are null values in the storage facility.
            if (firstNodeInt.value == null){
                System.out.println("Null Values inside: 1");
                firstNodeInt = firstNodeInt.nextElement;
            }

            // Traverses the whole facility.
            while (firstNodeInt.nextElement != null){
                fullTree += firstNodeInt.value + " ";
                firstNodeInt = firstNodeInt.nextElement;
            }
            if (firstNodeInt != null){
                fullTree += firstNodeInt.value;
            }
            return fullTree;
        }
        else if (linkedList != null){
            firstNodeString = linkedList;
            String fullTree = "";

            // Checks if there are null values in the storage facility.
            if (firstNodeString.value == null){
                System.out.println("Null Values inside: 1");
                firstNodeString = firstNodeString.nextElement;
            }

            // Traverses the whole facility.
            while (firstNodeString.nextElement != null){
                fullTree += firstNodeString.value + " ";
                firstNodeString = firstNodeString.nextElement;
            }
            if (firstNodeString != null){
                fullTree += firstNodeString.value;
            }
            return fullTree;
        }
        else{
            firstNodeSS = linkedListSS;
            String fullTree = "";

            // Checks if there are null values in the storage facility.
            if (firstNodeSS.value == null){
                System.out.println("Null Values inside: 1");
                firstNodeSS = firstNodeSS.nextElement;
            }

            // Traverses the whole facility.
            while (firstNodeSS.nextElement != null){
                fullTree += firstNodeSS.value + " ";
                firstNodeSS = firstNodeSS.nextElement;
            }
            if (firstNodeSS != null){
                fullTree += firstNodeSS.value;
            }
            return fullTree;
        }
    }

    /**
     * This method is used to add the value provided by the user in the
     * facility.
     *
     * @param x A variable to store the user input.
     * @return Returns true if the input is added successfully, otherwise false
     */
     boolean add(String x){

         // checks if the value to be added is null
        if (x == null ){
            if (linkedList.value != null) {
                ListString newPosition = new ListString(x);
                newPosition.nextElement = linkedList;
                linkedList = newPosition;
                return true;
            }
        }

        // Checks if the facility itself is empty.
        else if(linkedList == null){
            linkedList = new ListString(x);
        }

        else{
            ListString firstNode = linkedList;

            // Traverses the facility to decide where to add the element.
            if(firstNode.nextElement != null) {
                while (firstNode.nextElement != null &&
                        firstNode.nextElement.value.compareTo(x) < 0) {
                    firstNode = firstNode.nextElement;
                }
            }

            // Adds the element in the right position.
            ListString newPosition = new ListString(x);
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
    boolean add(Integer x){

        // checks if the value to be added is null
        if (x == null ){
            if (linkedListInt.value != null) {
                ListInt newPosition = new ListInt(x);
                newPosition.nextElement = linkedListInt;
                linkedListInt = newPosition;
                return true;
            }
        }

        // Checks if the facility itself is empty.
        else if(linkedListInt == null){
            linkedListInt = new ListInt(x);
        }

        else{
            ListInt firstNode = linkedListInt;

            // Traverses the facility to decide where to add the element.
            if(firstNode.nextElement != null) {
                while (firstNode.nextElement != null &&
                        firstNode.nextElement.value.compareTo(x) < 0) {
                    firstNode = firstNode.nextElement;
                }
            }

            // Adds the element in the right position.
            ListInt newPosition = new ListInt(x);
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

    boolean add(SortedStorage x){

        // checks if the value to be added is null
        if (x == null ){
            if (linkedListSS.value != null) {
                ListSS newPosition = new ListSS(x);
                newPosition.nextElement = linkedListSS;
                linkedListSS = newPosition;
                return true;
            }
        }

        // Checks if the facility itself is empty.
        else if(linkedListSS == null){
            linkedListSS = new ListSS(x);
        }

        else{
            ListSS firstNode = linkedListSS;

            // Traverses the facility to decide where to add the element.
            if(firstNode.nextElement != null) {
                while (firstNode.nextElement != null && (
                        getLengthSS(firstNode) > getLengthAll(x))) {
                    firstNode = firstNode.nextElement;
                }
            }

            // Adds the element in the right position.
            ListSS newPosition = new ListSS(x);
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
     * This method is used to delete the value provided by the user in the
     * facility.
     *
     *  @param x A variable to store the user input.
     *  @return Returns true if the input is deleted successfully, otherwise
     *          false
     */
    boolean delete(String x){

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
            ListString firstNode = linkedList;
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
    boolean delete(Integer x){

        // Checks if the user input is null.
        if (x == null){
            if (linkedListInt != null && linkedListInt.value == null){
                linkedListInt = linkedListInt.nextElement;
                return true;
            }
        }

        //Checks if there is anything to delete.
        else if (linkedListInt == null){
            return false;
        }
        else {
            ListInt firstNode = linkedListInt;
            if(linkedListInt != null && linkedListInt.value == x){
                linkedListInt = linkedListInt.nextElement;
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
    boolean delete(SortedStorage x){

        // Checks if the user input is null.
        if (x == null){
            if (linkedListSS != null && linkedListSS.value == null){
                linkedListSS = linkedListSS.nextElement;
                return true;
            }
        }

        //Checks if there is anything to delete.
        else if (linkedListSS == null){
            return false;
        }
        else {
            ListSS firstNode = linkedListSS;
            if(linkedListSS != null && linkedListSS.value == x){
                linkedListSS = linkedListSS.nextElement;
                return true;
            }
            // Traverses the whole facility to find the element
            while (firstNode.nextElement != null &&
                    (getLengthSS(firstNode) < getLengthAll(x))) {
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
    boolean find(String x){

        // Checks if the user input is null.
        if (x == null){
            if (linkedList != null && linkedList.value == x){
                return true;
            }
        }

        // Checks if the user input is present in the facility
        else {
            ListString firstNode = linkedList;
            while (firstNode != null ){
                if(firstNode.value == x ){
                    return true;
                }
                firstNode = firstNode.nextElement;
            }
        }
        return false;
    }
    boolean find(Integer x){

        // Checks if the user input is null.
        if (x == null){
            if (linkedListInt != null && linkedListInt.value == x){
                return true;
            }
        }

        // Checks if the user input is present in the facility
        else {
            ListInt firstNode = linkedListInt;
            while (firstNode != null ){
                if(firstNode.value == x ){
                    return true;
                }
                firstNode = firstNode.nextElement;
            }
        }
        return false;
    }
    boolean find(SortedStorage x){

        // Checks if the user input is null.
        if (x == null){
            if (linkedListSS != null && linkedListSS.value == x){
                return true;
            }
        }

        // Checks if the user input is present in the facility
        else {
            ListSS firstNode = linkedListSS;
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
     boolean includesNull(){
         if (linkedList == null){
        if (linkedListInt != null && linkedListInt.value == null){
            return true;
        }
        else if (linkedListInt == null){
            return false;
        }
         }
         else if (linkedListInt == null){
             if (linkedList != null && linkedList.value == null){
                 return true;
             }
             else if (linkedList == null){
                 return false;
             }
         }
         else {
             if (linkedListSS != null && linkedListSS.value == null){
                 return true;
             }
             else if (linkedListSS == null){
                 return false;
             }
         }
             return false;
    }
    public int getLengthAll(SortedStorage storage){
        int length = 0;
        if(storage.linkedList != null){
            length = getLengthString(storage.linkedList);
        }
        else if(storage.linkedListInt != null){
            length = getLengthInt(storage.linkedListInt);
        }
        else if(storage.linkedListSS != null){
            length = getLengthSS(storage.linkedListSS);
        }
        return length;
    }
    public int getLengthSS(ListSS findThisLength){
        ListSS firstNode = findThisLength;
        int length = 0;
        if(firstNode != null && firstNode.value == null){
            length++;
            firstNode = firstNode.nextElement;
        }
        while(firstNode != null){
            firstNode = firstNode.nextElement;
            length++;
        }
        return length;
    }

    public int getLengthInt(ListInt findThisLength){
        ListInt firstNode = findThisLength;
        int length = 0;
        if(firstNode != null && firstNode.value == null){
            length++;
            firstNode = firstNode.nextElement;
        }
        while(firstNode != null){
            firstNode = firstNode.nextElement;
            length++;
        }
        return length;
    }

    public int getLengthString(ListString findThisLength){
        ListString firstNode = findThisLength;
        int length = 0;
        if(firstNode != null && firstNode.value == null){
            length++;
            firstNode = firstNode.nextElement;
        }
        while(firstNode != null){
            firstNode = firstNode.nextElement;
            length++;
        }
        return length;
    }

    /**
     * The main program.
     *
     * @param    args    command line arguments.
     */
    public static void main(String[] args) {
        SortedStorage s = new SortedStorage();
        s.add("1");
        s.add("2");
        s.add("3");
        s.add("3");
//        s.add(null);
        System.out.println(s.toString());
       System.out.println(s.delete("1"));
//        System.out.println(s.toString());
        System.out.println(s.find("1"));
        System.out.println(s.includesNull());

    }

}

/**
 * It is a class to store linked list elements.
 */
class ListString{
    String value;
    ListString nextElement;

    ListString(String element){
        value = element;
        nextElement = null;

    }
}
class ListInt{
    Integer value;
    ListInt nextElement;

    ListInt(Integer element){
        value = element;
        nextElement = null;

    }
}

class ListSS{
    SortedStorage value;
    ListSS nextElement;

    ListSS(SortedStorage element){
        value = element;
        nextElement = null;

    }
}

