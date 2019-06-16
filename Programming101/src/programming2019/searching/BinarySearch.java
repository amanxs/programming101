package programming2019.searching;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        Scanner In = new Scanner(System.in);
        int[] whitelist = {1,3,2,6,8,5,3,9,4};
        // 10 11 12 16 18 23 29 33 48 54 57 68 77 84 98
        int key = 0;
        Arrays.sort(whitelist);
        rank(key, whitelist);
    }

    //Binary search without recursion
    public static int rank(int key, int arr[]){
        int l = 0;
        int r = arr.length;

        while(l<r){
            int m = (l+r)/2;
            if(key<arr[m])
                r = m-1;
            else if(key>arr[m])
                l = m+1;
            else
                return m;
        }

        return -1;
    }

    public static int rank(int key, int arr[], int l, int r){
        if(l>r)
            return -1;

        int m = (l+r)/2;
        if(arr[m]>key) return  rank(key, arr, l, m-1);
        else if(arr[m]<key) return  rank(key,arr, m+1, r);
        else return m;
    }
}
