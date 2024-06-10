import java.util.LinkedList;
public class MyList<T> {

    LinkedList<T> l1;

    MyList(){
        l1 = new LinkedList<>();    }

    /**
     * This method is to add an object in the collection.
     * @param word A variable to store element to add.
     */
    public void add(T word) {
        l1.add(word);
    }

    /**
     * This is the toString to print the collection.
     * @return A string representation of the collection.
     */
    public String toString() {
        if (l1 != null){
            String answer = "";
            for(int i=0; i< l1.size(); i++){
                answer += l1.get(i) + " ";
            }
            return answer + "/ " + l1.size();
        } else {
            return null;
        }
    }
}