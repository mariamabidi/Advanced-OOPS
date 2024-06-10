public class SortedStorageNonSet<T extends Comparable> implements Comparable, SortedStorageInterface<T>  {
    private List linkedList;
    int nullCounter;
    public SortedStorageNonSet(){
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

        // Checks if there are null values in the storage facility.
        if (firstNode.value == null){
            System.out.println("Null Values inside: 1");
            firstNode = firstNode.nextElement;
        }

        // Traverses the whole facility.
        while (firstNode.nextElement != null){
            fullTree += firstNode.value + " ";
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
        if (x == null ){
            nullCounter++;
            return true;
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
            if(nullCounter > 0){            nullCounter--;
                return true;}
            else {return false;}

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
            if (nullCounter > 0){
                return true;
            }
            else {return false;}
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
        if (nullCounter>0){
            return true;
        }
        return false;
    }

    public int getLengthOfList(List linkedList){
        int length = 0;
        while (linkedList.nextElement != null){
            length++;
        }
        return length;
    }

    public int compareTo(SortedStorageNonSet s){
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

    @Override
    public int compareTo(Object o) {
        SortedStorageNonSet s = (SortedStorageNonSet) o;
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

}



