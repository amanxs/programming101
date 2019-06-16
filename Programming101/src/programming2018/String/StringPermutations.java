package programming2018.String;

public class StringPermutations {

    public static void main(String[] args) {
        String str = "abc";
        printPermutations(str, 0, str.length());
    }

    static void printPermutations(String s, int l, int r){

        for(int i=l; i<=r; i++){
            s = swap(s,l,i);
            printPermutations(s,l,i);
        }

    }

    static String swap(String s, int l, int r){
        char arr[] = s.toCharArray();
        char temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        return String.valueOf(arr);
    }
}
