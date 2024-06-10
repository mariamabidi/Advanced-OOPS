/*
 * LargestDistance.java
 *
 * Version:
 *     1.0
 *
 * Revisions:
 *     0
 */
/**
 * A program that finds the CloseFermatNumber Set with the largest
 * CloseFermatNumber Set distance for a MINIMUM and MAXIMUM value.
 *
 * @author      Mariam Abidi
 * @author      Dhruv Dave
 */
public class LargestDistance {
    static int MAXIMUM = 50;
    static int MINIMUM = 1;

    /**
     * The testProperty method validates if the values for the a, b, c
     * variables satisfies the conditions of the formula and prints the output.
     *
     * @param     a         A variable to store the first value.
     * @param     b         A variable to store the second value.
     * @param     c         A variable to store the third value.
     *
     * @return              void
     *
     */

    public static void testProperty(int a, int b, int c) {

        // The variables x, y ,z store the a^3, b^3, c^2 values respectively.
        int x = a * a * a;
        int y = b * b * b;
        int z = c * c;

        // This if statement checks if the variables satisfies the formula.
        if (x + y == z) {
            System.out.println(x + " + " + y + " = " + z);
            System.out.println(a + "^3" + " + " + b + "^3" + " = " + c + "^2");
        }
    }

    /**
     * The findAllNumbers method has a nested for loop to check all the numbers
     * from the minimum value till the maximum value and then calls the
     * testProperty method.
     *
     * @return              void
     *
     */
    public static void findAllNumbers() {

        /* The nested for loops are to verify each number from the minimum value
           till the maximum value. */
        for(int a = MINIMUM; a<= MAXIMUM; a++){
            for (int b = MINIMUM; b<= MAXIMUM; b++){
                for (int c = MINIMUM; c<= MAXIMUM; c++) {
                    testProperty(a, b, c);
                }
            }
        }
    }

    /**
     * The main program.
     *
     * @param    args    command line arguments
     */

    public static void main (String[]args ){
        findAllNumbers();
    }
}

