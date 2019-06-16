package programming2018.geeksForGeeks.arrays;

import java.util.Arrays;

public class PythagorasTriplet {
    /*
    Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.
     */


    public static void main(String[] args) {
        int ar[] = {3, 1, 4, 6, 5};
        int ar_size = ar.length;
    }

    static boolean isPythagorasTriplet(int arr[], int n){
        for(int i=0; i<n; i++)
            arr[i] = arr[i]*arr[i];

        Arrays.sort(arr);// 1 9 16 25 36

        for(int i=0; i<n; i++){
            int c = arr[n-1-i];
            // a + b = c

            for(i=0;i<n-1-i ; i++){

            }
        }

        return false;

    }

}
