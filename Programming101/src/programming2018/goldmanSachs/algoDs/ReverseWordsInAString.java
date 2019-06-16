package programming2018.goldmanSachs.algoDs;

import java.util.Scanner;

public class ReverseWordsInAString {


    public static void main (String[] args) {
        //code
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N ; i++) {
            String s = in.next();
            reverse(s);
        }
    }

    private static void reverse(String s) {
        /*
        split() method takes a regular expression as argument.
        Regular expressions have a bunch of special characters, one of which is the dot "." character.
        ( '.' refers to -any- character in a regExp).
        Therefore if you wish to search for a dot character you need to escape it. This is done with '\\'
         */
        String split[] = s.split("\\.");
        for (int i = split.length-1; i >=0 ; i--) {
            System.out.println(split[i]+".");
        }
        System.out.println("");
    }
}
