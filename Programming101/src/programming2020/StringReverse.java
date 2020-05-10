package programming2020;

public class StringReverse {

    public static void main(String[] args) {
        String s = "Solution arora";
        reverse(s);

    }

    public static void reverse(String s){
        char arr[] = s.toCharArray();
        int length = s.length();
        int l =0;
        int r = length-1;
        while(l<r){
            swap(arr, l, r);
            l++;
            r--;
        }
        String revers = String.valueOf(arr);
        System.out.println(revers);

        System.out.println(String.valueOf(arr));
    }

    public static void swap(char arr[], int l, int r){
        char temp = arr[r];
        arr[r] = arr[l];
        arr[l] = temp;
    }
}
