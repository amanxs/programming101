package programming2020;

import java.util.Arrays;

/**
 * Check whether two strings are anagram of each other
 */
public class Anagram {

    private static int ASCII = 256;

    public static void main(String[] args) {
        String s1 = "Listens";
        String s2 = "Silence";
        boolean isAnagram = isAnagram(s1, s2);
        System.out.println(isAnagram);
    }

    /**
     * This method assumes that the set of possible characters in both strings is small.
     * In the following implementation, it is assumed that the characters are stored using 8 bit
     * and there can be 256 possible characters.
     * @param s1
     * @param s2
     * @return
     */
    private static boolean isAnagram(String s1, String s2) {
        if(s1.length()!=s2.length())
            return false;

        char arr1[] = s1.toCharArray();
        char arr2[] = s2.toCharArray();

        int arr[] = new int[ASCII];
        Arrays.fill(arr, 0);
        for(int i =0; i<arr1.length; i++){
            arr[arr1[i]] = 1;
        }

        for(int i =0; i<arr2.length; i++){
            if(arr[arr2[i]]==0){
                return false;
            }
        }
        return true;
    }
}
