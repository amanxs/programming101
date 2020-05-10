package programming2020;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string a a b c c c c c a a a would become a2blc5a3
 * If the "compressed" string would not become smaller than the original string, your method should return the original string
 */
public class StringCompression {

    public static void main (String args[]) {
        String compressed = compress("aabcccccaaa");
        System.out.println(compressed);
        System.out.println(compressed.length());
    }

    private static String compress(String str) {
        String compressed;
        StringBuilder builder = new StringBuilder();

        char arr[] = str.toCharArray();

        int count=0;
        char curr=arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==curr && i != arr.length-1){
                count++;
            }
            else{
                builder.append(curr);
                builder.append(count);
                curr=arr[i];
                count=1;
            }
        }
        compressed = builder.toString();

        return str.length()> compressed.length()? compressed : str;
    }

}


