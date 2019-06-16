package programming2018.jpMorgan;

import java.util.HashSet;
import java.util.Set;

public class GenerateAnagrams {
    /**
     * Write a program to generate the anagrams of a word
     */

    public static void main(String args[]){
         
        //This would be similar to finding all the unique permutations of the programming2018.String and thus Set to store the result
        Set<String> anagrams = generateAnagrams("ABCD");
        System.out.println(anagrams.size());
        for(String s : anagrams){
            System.out.println(s);
        }
    }

    static Set generateAnagrams(String str){
        Set<String> anagrams = new HashSet<String>();

        getPermutations(str, 0, str.length(), anagrams);
        return anagrams;
    }
    
    static void getPermutations(String str, int l, int r, Set<String> anagrams){
        if(l==r)
            anagrams.add(str);

        for (int i = l; i < r ; i++) {
            str = swap(str,i,l);
            getPermutations(str, l+1, r, anagrams);//BACD,
        }
    }

    static String swap(String s, int a, int b){
        char arr[] = s.toCharArray();
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return String.valueOf(arr);
    }
}
