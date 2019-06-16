package programming2018.crackingTheCodingInterview.arrays;

public class reverseNullTerminatedString {

    public static void main(String args[]){

    }

    private static void reverse(String s){

        char arr[] = s.toCharArray();
        int l = 0;
        int r = arr.length-1;
        while (l<r){
            swap(l,r,arr);
            l++;
            r--;
        }

    }

    private static void swap(int l, int r, char[] arr){
        char temp = arr[l];
        arr[l]= arr[r];
        arr[r] =temp;
    }
}
