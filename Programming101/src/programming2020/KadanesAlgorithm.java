package programming2020;

/**
 * Write an efficient program to find the sum of contiguous subarray within a one-dimensional array
 * of numbers which has the largest sum.
 * Input {-2, -3, 4, -1, -2, 1, 5, -3}; Output : 7
 */
public class KadanesAlgorithm {
    public static void main(String[] args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int arr2[] = {13, -3, -25, -20, -3, 16, 7, -23, -12, -5, -22, -15, -4, -7};
        int max = maxSubarraySum(arr);
        System.out.println(max);
    }

    public static int maxSubarraySum(int arr[]){
        int maxSoFar = arr[0];
        int currMax = arr[0];
        for(int i=1; i< arr.length; i++){
            currMax = Math.max(currMax + arr[i], arr[i]);
            System.out.println(currMax);
            maxSoFar = Math.max(maxSoFar, currMax);
            System.out.println(maxSoFar);
        }

        return maxSoFar;
    }
}
