package programming2020;

/**
 *
 arr[] = {1, 10, 5, 2, 7}
 x  = 9
 Output: 1
 Minimum length subarray is {10}

 arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}
 x = 280
 Output: 4
 Minimum length subarray is {100, 1, 0, 200}

 arr[] = {1, 2, 4}
 x = 8
 Output : Not Possible
 Whole array sum is smaller than 8.
 */
public class SmallestSubarrayWithSumGreaterThanX {

    public static void main(String args[]){
        int arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
        int arr2[] = {1, 10, 5, 2, 7};
        int subarray = minSubArray(arr, 280);

        minSubArray(arr2, 9);

        if (-1 == subarray){
            System.out.println("No Subarray found");
        }
    }

    public static int minSubArray(int arr[], int x){
        int subArraySum = 0;
        int minSubArray = arr.length;
        int subArray = arr.length;
        for(int end =0; end < arr.length; end ++){
            subArraySum += arr[end];
            int start = 0;
            while(subArraySum> x && end> start){
                subArraySum -= arr[start];
                subArray = end - start;
                start ++;
            }
            minSubArray  = Math.min(subArray, minSubArray);

        }
        System.out.println(minSubArray);
        return minSubArray;
    }
    /**
     * How to handle negative numbers?
     * The above solution may not work if input array contains negative numbers.
     * For example arr[] = {-8, 1, 4, 2, -6} and x=6.
     * To handle negative numbers, add a condition to ignore subarrays with negative sums.
     */

    public static int minSubArrayHandlesNegativeNumber(int arr[], int x){
        int minSubArray = arr.length;
        int subArraySum = 0;

        for(int end =0; end < arr.length; end ++){
            if (subArraySum + arr[end]<0){

            };
        }

        return minSubArray;
    }
}
