package programming2020;

public class StringPermutations {
    public static void main(String args[]){
        String s = "abcd";
        printPermutations(s, 0, s.length());
    }

    private static void printPermutations(String str, int start, int end) {
        if(start>=end){
            System.out.println(str);
            return;
        }
        for (int i = start; i <end ; i++) {
            str = swap(str, i, start);
            printPermutations(str, start+1, end);
        }
    }

    private static String swap(String str, int i, int start) {
        char arr[] = str.toCharArray();
        char temp =  arr[i];
        arr[i] = arr[start];
        arr[start] = temp;
        return String.valueOf(arr);
    }

}
