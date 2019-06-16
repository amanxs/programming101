package programming2018.jpMorgan;

import java.util.*;

public class PangramChecking {
    /**
     * Given a string check if it is Pangram or not. A pangram is a sentence containing every letter in the English Alphabet.
     * Examples : The quick brown fox jumps over the lazy dog ” is a Pangram [Contains all the characters from ‘a’ to ‘z’]
     */

    static String stringAlphabet  = "abcdefghijklmnopqrstuvwxyz";
    public static void main(String[] args) {
        String str = "The quick brown fox jumps over the dog";

        if (checkPangram(str) == true)
            System.out.print(str + " is a pangram.");
        else
            System.out.print(str+ " is not a pangram.");
    }

    static boolean checkPangram(String str){
        HashSet<Character> charSet = new HashSet<>();
        char arr[] = str.toLowerCase().toCharArray();
        for(int i=0; i< str.length(); i++){
            if(Character.isLetter(arr[i]))
                charSet.add(arr[i]);
        }
        Set<Character> testSet = new HashSet<Character>();
        for(int i=0 ; i<stringAlphabet.length(); i++){
            testSet.add(stringAlphabet.charAt(i));
        }

        for(Character c : charSet ){
            testSet.remove(c);
        }

        if(testSet.isEmpty())
            return true;
        else
            return false;


    }
}
