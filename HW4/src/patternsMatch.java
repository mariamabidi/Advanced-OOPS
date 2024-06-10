/**
 * It is a class that helps to identify which string belongs to which pattern.
 *
 *
 * @author      Mariam Abidi
 * @author      Dhruv Dave
 *
 */
public class patternsMatch {
    static int errorState = -1; // State when there is no other state.

    /**
     * This method is for the first pattern to check if the string is only ab
     * or not.
     *
     * @param charRepresentation A variable to store the character
     *                           representation of the string.
     * @return  Returns true if the string matches the pattern, otherwise
     *          false.
     */
    static boolean pattern1(char[] charRepresentation){
        int state = 0;

        //checks every character of the string with pattern.
        for ( int index = 0; ( state != errorState ) &&
                ( index < charRepresentation.length ); index++ ) {
            if (state == 0) {
                if (charRepresentation[index] == 'a' ){
                    state = 1;
                    if (charRepresentation[index+1] == 'b' &&
                            charRepresentation.length == 2){
                        return true;
                    }
                } else {
                    state = errorState;
                }
            }
        }
        return false;
    }

    /**
     * This method is to check if the string matches the second pattern i.e.
     * .a+b.
     *
     * @param charRepresentation2 A variable to store the character
     *                            representation of the string.
     *@return  Returns true if the string matches the pattern, otherwise
     *         false.
     */
    static boolean pattern2(char[] charRepresentation2){
        int state = 0;

        //enters the pattern only if the second index is a.
        if (charRepresentation2[1] == 'a'){
            for (int index = 2; index < charRepresentation2.length-1; index++){
                if (charRepresentation2[index] == 'a'){
                    state = 1;
                } else if (charRepresentation2[index] == 'b' &&
                        charRepresentation2.length == index+2){
                    return true;
                } else {
                    state = errorState;
                }
            }
        }
        return false;
    }

    /**
     * This method is to check if the string matches the third pattern i.e.
     * .ab.
     *
     * @param charRepresentation3 A variable to store the character
     *                            representation of the string.
     *@return  Returns true if the string matches the pattern, otherwise
     *         false.
     */
    static boolean pattern3(char[] charRepresentation3){
        int state = 0;

        // checks if the length of the string is 4 to enter the loop.
        if (state != errorState && charRepresentation3.length == 4){
            if (charRepresentation3[1] == 'a'){
                state = 1;
                if (charRepresentation3[2] == 'b'){
                    state = 2;
                    return true;
                }
            } else {
                state = errorState;
            }
        }
        return false;
    }

    /**
     * This method is to check if the string matches the fourth pattern i.e.
     * ^[ab]c$
     *
     * @param charRepresentation4 A variable to store the character
     *                            representation of the string.
     *@return  Returns true if the string matches the pattern, otherwise
     *         false.
     */
    static boolean pattern4(char[] charRepresentation4){
        int state = 0;
        // checks if string length is 2 and if a or b is present in first index
        if (charRepresentation4.length == 2 && charRepresentation4[0] == 'a'
                || charRepresentation4[0] == 'b'){
            state = 1;
            if (charRepresentation4[1] == 'c'){
                state = 2;
                return true;
            }
        }
        else {
            state = errorState;
        }
        return false;
    }

    /**
     * This method is to check if the string matches the fifth pattern i.e.
     * ^[ab]?c$
     *
     * @param charRepresentation5 A variable to store the character
     *                            representation of the string.
     *@return  Returns true if the string matches the pattern, otherwise
     *         false.
     */
    static boolean pattern5(char[] charRepresentation5){
        int state = 0;

        /* checks if the length of the string is 1 to enter the pattern
        recognition. */
        if (new String(charRepresentation5).length() == 1 &&
                charRepresentation5[0] == 'c'){
            state = 0;
            return true;
        }

        /* checks if the length of the string is 2 to enter the pattern
        recognition. */
        if (new String(charRepresentation5).length() == 2 &&
                (charRepresentation5[0] == 'a' ||
                        charRepresentation5[0] == 'b')){
            state = 1;
            if (charRepresentation5[1] == 'c'){
                state = 0;
                return true;
            }
            else {
                state = errorState;
                return false;
            }
        }
        return false;
    }

    /**
     * This method is to check if the string matches the sixth pattern i.e.
     * ^[ab]?|c?$
     *
     * @param charRepresentation6 A variable to store the character
     *                            representation of the string.
     *@return  Returns true if the string matches the pattern, otherwise
     *         false.
     */
    static boolean pattern6(char[] charRepresentation6){
        int state = 0;
        if (charRepresentation6.length > 1){
            return false;
        }

        /* checks if the length of the string is 1 to enter the pattern
        recognition. */
        else {
            if (charRepresentation6[0] == 'a'){
                return true;
            }
            if (charRepresentation6[0] == 'b'){
                return true;
            }
            if (charRepresentation6[0] == 'c'){
                return true;
            }
            else {
                state = errorState;
                return false;
            }
        }
    }

    /**
     * This method is to check if the string matches the seventh pattern i.e.
     * ^..\2\1$
     *
     * @param charRepresentation7 A variable to store the character
     *                            representation of the string.
     *@return  Returns true if the string matches the pattern, otherwise
     *         false.
     */
    static boolean pattern7(char[] charRepresentation7){
        int state = 0;

        // For loop to check for palindrome
        for (int i = 0; i < charRepresentation7.length /2; i++){
            if (charRepresentation7[i] ==
                    charRepresentation7[charRepresentation7.length - 1 - i]){
                return true;
            } else {
                state = errorState;
                return false;
            }
        }
        return false;
    }

}
