package programming2018.crackingTheCodingInterview.arrays;

import java.util.Arrays;

// Given 2 programming2018.String check if one is permutation of the other
public class Anagram {

    public static void main(String args[]){

    }

    //We should confirm some details with our interviewer
    // Like if the Anagram comparison is case sensitive

    // We will assume that the comparison is case sensitive and the white space is significannt
    private static boolean isAnagram(String s1, String s2){

        // you may want to start off with asking your interviewer if u can use a Hashmap
        // if not then if the programming2018.String is an ASCII string or a Unicode string

        int count [] = new int[256];// Assumption
        ///With extended ASCII codes, there are a total 256 characters. That's the reason for 256.
        //check with your interviewer about the size of the character set.We assumed that the character set was ASCII.


        Arrays.fill(count,0);
        char str1 [] = s1.toCharArray();
        char str2 [] = s1.toCharArray();

        if (str1.length != str2.length)
            return false;

        for (int i = 0; i < str1.length; i++) {
            count[str1[i]]++;
            count[str2[i]]--;
        }

        for (int i = 0; i < 256; i++) {
            if (count[i]!=0)
                return false;
        }

        return true;
    }
}
