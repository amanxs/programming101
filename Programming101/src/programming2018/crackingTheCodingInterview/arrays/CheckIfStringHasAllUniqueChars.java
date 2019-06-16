package programming2018.crackingTheCodingInterview.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class CheckIfStringHasAllUniqueChars {

    public static void main(String args[]){

    }

    // without using any other DS
    // you may want to start off with asking your interviewer if u can use a Hashmap
    // if not then if the programming2018.String is an ASCII string or a Unicode string

    private static boolean checkIfAllUnique(String s){
        int count [] = new int[256];//With extended ASCII codes, there are a total 256 characters. That's the reason for 256.
        // and so the condition too
        if(s.length()>256) return false;

        Arrays.fill(count,0);

        for (char c: s.toCharArray()) {
            count[c]++;
            if (count[c]>1)
                return false;
        }
        return true;
    }
//check with your interviewer about the size of the character set. We assumed that the character set was ASCII.

    //Solution : Almost same approach
    private static boolean isUniqueChars2(String s){
        boolean char_set [] = new boolean[256];//With extended ASCII codes, there are a total 256 characters. That's the reason for 256.
        // and so the condition too
        if(s.length()>256) return false;

        for (char c: s.toCharArray()) {
            if (char_set[c])
                return false;
            char_set[c]=true;

        }
        return true;
    }


    //Solution : Using HashMap
    private static boolean isUniqueCharsChecker(String s){

        HashMap<Character,Boolean> map = new HashMap<>();
        for (char c : s.toCharArray()){
            if(map.containsKey(c))
                return false;
            else
                map.put(c, true);
        }


        return true;
    }

}
