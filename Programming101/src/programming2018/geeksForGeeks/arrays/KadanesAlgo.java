package programming2018.geeksForGeeks.arrays;

public class KadanesAlgo {
    /*
    Given an array containing both negative and positive integers. Find the contiguous sub-array with maximum sum.
     */

    public static void main(String args[]){
        int arr[] = {-2,-3,4,-1,-2,1,5,-3};
    }

    static int getSubarrayWithMaxSum(int arr[], int n){
        int localMax = arr[0];
        int maxSoFar = arr[0];

        for(int i=1; i<n ; i++){
            localMax = Math.max(localMax + arr[i], arr[i]);
            maxSoFar = Math.max(maxSoFar,localMax);

        }

        return maxSoFar;
    }

    static void printSubarrayWithMaxSum(int arr[], int n){

    }
}
