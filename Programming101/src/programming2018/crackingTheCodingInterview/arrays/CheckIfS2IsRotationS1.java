package programming2018.crackingTheCodingInterview.arrays;

/**
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, si and s2, write code to check If s2 isa rotation of si using only one call to isSubstring
 * (e.g., "waterbottLe" is a rotation of "erbottLewat").
 */
public class CheckIfS2IsRotationS1 {

    /**
     s1 = xy = waterbottle
     x = wat
     y = erbottle
     s2 = yx = erbottlewat
     So,we need to check if there's a way to split s1 into x and y such that xy=s1 and yx= s2.
     Regardless of where the division between x and y is, we can see that yx will always be a substring of xyxy.
     That is,s2 will always be a substring of s1s1.
     * @param s1
     * @param s2
     * @return
     */
    static boolean isRotation(String s1, String s2){

        if(s1.length()==s2.length() && s1.length()>0){
            String slsl = s1 + s1;
            return isSubString(slsl, s2 );
        }
        else
            return false;
    }

    static boolean isSubString(String s, String subString){
        return true;
    }

}
