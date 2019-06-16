package programming2019.geeksForGeeks.mustDoCodingQuestions.string;

public class ReverseWordsInAString {
    /**
     * Given a String of length S, reverse the whole string without reversing the individual words in it.
     * Words are separated by dots.
     */
    public static void main(String[] args) {
        /**
         * Input:
         2
         i.like.this.program.very.much
         pqr.mno

         Output:
         much.very.program.this.like.i
         mno.pqr
         */

        String s1 = "i.like.this.program.very.much";
        String s2 = "pqr.mno";

        reverseWords(s1);

        String output = "much.very.program.this.like.i" +
                "mno.pqr";
    }

    private static void reverseWords(String str) {
        String words[] = str.split("\\.");
        /*
        split() method takes a regular expression as argument. Regular expressions have a bunch of special characters,
        one of which is the dot "." character. ( '.' refers to -any- character in a regExp).
        Therefore if you wish to search for a dot character you need to escape it. This is done with '\\'
         */

        int left=0;
        int right = words.length -1;

        while(left<right){
            swap(words, left, right);
            left++;
            right--;
        }

        String reversed = "";
        System.out.println("Done");

        for(int i =0 ; i<words.length-1; i++){
             reversed = reversed + words[i] + ".";
        }

        reversed = reversed + words[words.length-1];

        System.out.println(reversed);
    }

    private static void swap(String arr[], int left, int right){
        String temp = arr[left];
        arr[left] = arr[right];
        arr[right]= temp;
     }
}
