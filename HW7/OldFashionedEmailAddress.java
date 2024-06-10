public class OldFashionedEmailAddress implements Comparable<OldFashionedEmailAddress>{
    /**
     * It is a class to store AddressStorage elements like house, street,
     * town, state and zip code in various formats. This class implements
     * Comparable interface to compare the values and store them in a sorted
     * manner and so that it can perform add, remove and other functionality.
     */
    int houseNumber;
    String streetName;
    String nameOfTown;
    String state;
    int zipCode;

    OldFashionedEmailAddress(int house, String street, String town, String state, int zip){
        /**
         * This is a constructor for the class OldFashionedEmailAddress.
         */
        this.houseNumber = house;
        this.streetName = street;
        this.nameOfTown = town;
        this.state = state;
        this.zipCode = zip;
    }

//        to String method for the same.
    public String toString(){return "[" +this.houseNumber + " | "+ this.streetName + " | " +this.nameOfTown + " | "+ this.state+" | "+this.zipCode+ "]";}

    @Override
    public int compareTo(OldFashionedEmailAddress o) {
        /**
         * This is an override of the abstract class from comaparable
         * which needs to be overridden for the class OldFashionedEmailAddress.
         * We compare the various values entered in the storage to sort and
         * store them.
         */
        if (this.state.compareTo(o.state) == 0) {
            if (this.zipCode == o.zipCode) {
                if (this.streetName.compareTo(o.streetName) == 0) {
                    if (this.houseNumber == o.houseNumber) {
                        return 0;
                    } else if (this.houseNumber > o.houseNumber) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else if (this.streetName.compareTo(o.streetName) > 0) {
                    return 1;
                } else {
                    return -1;
                }
            } else if (this.zipCode > o.zipCode) {
                return 1;
            } else {
                return -1;
            }
        } else if (this.state.compareTo(o.state) > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
