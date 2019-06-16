package programming2018.geeksForGeeks.arrays;

import java.util.Arrays;

public class ChocolateDistributionProblem {

    /**
     * Given an array of n integers where each value represents number of chocolates in a packet.
     * Each packet can have variable number of chocolates.
     * There are m students, the task is to distribute chocolate packets such that:

     Each student gets one packet.
     The difference between the number of chocolates in packet with maximum chocolates and packet with minimum chocolates
     given to the students is minimum.

     */

    /*

    Input : arr[] = {3, 4, 1, 9, 56, 7, 9, 12}
        m = 5
    Output: Minimum Difference is 6
T   he set goes like 3,4,7,9,9 and the output
    is 9-3 = 6
     */

    public static void main(String[] args) {
        int arr[] = {3, 4, 1, 9, 56, 7, 9, 12};
        System.out.println(getMinDiff(arr,5,arr.length));
    }

    //We first sort the array arr[0..n-1], then find the subarray of size m with minimum difference between last and first elements.
    static int getMinDiff(int arr[], int m, int n){
        if(m==0 || n==0)
            return 0;

        if(n<m)
            return -1;

        Arrays.sort(arr);//1 3 4 7 9 9 12 56

        int minDiff = arr[n-1] - arr[0];
        int subArrayStartIndex=0;
        for(int i=0; i<n-m; i++){
            int diff = arr[i+m-1]-arr[i];
            if( diff < minDiff){
                minDiff=diff;
                subArrayStartIndex=i;
            }
        }

        System.out.println("First packet at " + subArrayStartIndex + " and last packet at " + (subArrayStartIndex+m-1));
        return minDiff;
    }
}
