/*
 * StringIntegerArrays.java
 *
 * Version:
 *     1.0
 *
 * Revisions:
 *     0
 */
import java.util.Arrays;

/**
 * It is a class that helps to understand if two strings are identical or equal
 * to each other.
 *
 * @author Mariam Abidi
 * @author Dhruv Dave
 *
 */
class StringIntegerArrays {
    static boolean firstTime = true;

    /**
     * This method returns a string according to the if condition.
     *
     * @param arg A variable to store a string
     * @return Returns a string value.
     */
    static String resturnsAstring(String arg)	{
        String rValue;

        if ( firstTime )
            rValue = "";
        else
            rValue = arg;
        firstTime = false;
        return rValue;
    }

    /**
     * The main program.
     *
     * @param    args    command line arguments.
     */
    public static void main( String args[] ) {
        String a, b;
        String aString= null;
        String bString= null;
        String cString= null;
        String dString= null;
        String eString= null;
        String fString= null;
        String gString= null;
        String hString= null;
        String iString= null;

        if ( args.length == 1 ) {
            /*
            * I. is aString equal to bString = Yes, the content inside aString
            * and bString is equal to each other.
            * II. is aString identical to bString = Yes, since we have already
            * created a literal with value "Abba", in the memory model, the
            * bString will be pointing towards the existing literal.
            * III. is cString equal to dString = No, the content inside cString
            * is not equal to dString.
            * IV. is cString identical to dString = No, they are not identical
            * since the value of both the strings are completely different.
            * V. is gString equal to hString = Yes, gString and hString are
            * equal to each other since the content is same.
            * VI. is gString identical to hString = No, since both the strings
            * are performing concatenation using a method hence they are not
            * referring to the same literal and instead creating different new
            * strings. */
            aString = "Ab" + "ba";
            bString = "Abba";
            cString = "A";
            dString = cString + "b" + "b" +
                    aString.substring(aString.length() - 1);
            fString = "Pink FLoyd";
            gString = "Abba" + resturnsAstring("");
            hString = "Ab" + resturnsAstring("ba");

        } else {
            /*
            * I. is aString equal to bString = Yes, both aString and bString
            * have the same content inside.
            * II. is aString identical to bString = Yes, in this case, a
            * literal is created for aString and bString references to that
            * same literal.
            * III. is cString equal to dString = No, the cString content is
            * completely different from the dString.
            * IV. is cString identical to dString = No, cString can't be
            * identical to dString since the content is completely different
            * and the dString is made by concatenation.
            * V. is gString equal to hString = Yes, gString and hString are
            * equal to each other since the content is same.
            * VI. is gString identical to hString = No, since both the strings
            * are performing concatenation using a method hence they are not
            * referring to the same literal and instead creating different new
            * strings. */
            aString = "Ot" + "to";
            bString = "Otto";
            cString = "O";
            dString = cString + "t" + "t" +
                    aString.substring(aString.length() - 1);
            fString = "Led ZeppeLin";
            gString = "Otto" + resturnsAstring("");
            hString = "Ot" + resturnsAstring("to");
        }

        // This line replaces the two characters.
        String replacedF = fString.replace("L", "l");

        // Converting all the strings to character arrays.
        char[] arrayA = aString.toCharArray();
        char[] arrayB = bString.toCharArray();
        char[] arrayC = cString.toCharArray();
        char[] arrayD = dString.toCharArray();
        char[] arrayF = replacedF.toCharArray();
        char[] arrayG = gString.toCharArray();
        char[] arrayH = hString.toCharArray();

        // Sorting all the arrays and printing a string.
        Arrays.sort(arrayA);
        System.out.println(new String(arrayA));
        Arrays.sort(arrayB);
        System.out.println(new String(arrayB));
        Arrays.sort(arrayC);
        System.out.println(new String(arrayC));
        Arrays.sort(arrayD);
        System.out.println(new String(arrayD));
        Arrays.sort(arrayF);
        System.out.println(new String(arrayF));
        Arrays.sort(arrayG);
        System.out.println(new String(arrayG));
        Arrays.sort(arrayH);
        System.out.println(new String(arrayH));

    }
}