package programming2018.crackingTheCodingInterview.arrays;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string a a b c c c c c a a a would become a2blc5a3
 * If the "compressed" string would not become smaller than the original string, your method should return the original string
 */
public class StringCompression {

    public static void main (String args[]){
            String compressed = compress("aabcccccaaa");
            System.out.println(compressed);
            System.out.println(compressed.length());

    }

    static int countCompression(String str){
        if (str == null | str.isEmpty()) return 0;
        int count =1;
        char curr = str.charAt(0);
        for (int i = 1; i <str.length() ; i++) {
            if(curr!=str.charAt(i)){
                count+=2;
                curr = str.charAt(i);
            }

        }return ++count;
    }

    private static String compress(String input){

        //Check if compression would create a longer programming2018.String
        int size = countCompression(input);
        System.out.println(size);

        if(input.length()<size)
            return input;


        char arr[] = input.toCharArray();
        char curr = arr[0];
        int count = 1;
        StringBuilder sb = new StringBuilder();
        //programming2018.String result = "";

        for(int i=1; i<input.length(); i++){
            if(arr[i]==curr){
                count++;
            }
            else{
                sb.append(curr);
                sb.append(count);
                //result += curr + ""+count;
                count=1;
                curr=arr[i];
            }
        }
        /* In lines 15 - 16 above, characters are inserted when the
        * repeated character changes. We need to update the string at  the end of the method as well, since the very last set of
        * repeated characters wouldn't be set in the compressed string yet */

        sb.append(curr);
        sb.append(count);
        //result += curr + ""+count;
        //return result;
        return  sb.toString();
    }

    /*
    When just using programming2018.String concatenation
    The runtime is 0(p + k^2), where p is the size of the original string and k is the number of character sequences.
    For example, if the string is aabccdeeaa, then there are six character sequences.
    It's slow because string concatenation operates in 0(n^2) time
    */
}
