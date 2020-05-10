package programming2020;


import java.util.HashMap;

/**
 * Case1:Given an unsorted array of non-negative integers, find a continuous subarray which adds to a given number.
 */
public class SubarrayWithGivenSum {
    public static void main(String args[]){
        int arr[] = {1, 4, 20, 3, 10, 5};
        int sum = 33;

        //subarrayWithGivenSum(arr, sum);

        subArraySum(new int[]{-1,-1,1}, 3, 0);
    }

    /**
     * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
     Output: Sum found between indexes 2 and 4
     * @param arr
     * @param sum
     */
    private static void subarrayWithGivenSum(int[] arr, int sum) {
        int subArray = arr.length;
        int subArraySum = 0;
        int start =0;

        for(int end =0;end<arr.length; end++){
            subArraySum += arr[end];

            while(subArraySum>sum && end > start){
                subArraySum = subArraySum-arr[start];
                start++;
            }

            if(sum == subArraySum){
                System.out.println("Sum found between : " + start + " & " + end);
            }

        }
    }

    /**
     * Above solution will fail for negative numbers. We can use hashing to compute this in O(n) time.
     *
     * Input: arr[] = {-20, 10, 2, -2, -20, 10}, sum = -10
     Output: Sum found between indexes 0 to 3
     Explantion: Sum of elements between indices
     0 and 3 is 10 + 2 - 2 - 20 = -10

     Input: arr[] = {-10, 0, 2, -2, -20, 10}, sum = 20
     Output: No subarray with given sum exists
     Explantion: There is no subarray with the given sum
     * @param arr
     * @param sum
     * @return
     */
    public static void subArraySum(int[] arr, int n, int sum) {
        //cur_sum to keep track of cummulative sum till that point
        int cur_sum = 0;
        int start = 0;
        int end = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            cur_sum = cur_sum + arr[i];
            //check whether cur_sum - sum = 0, if 0 it means
            //the sub array is starting from index 0- so stop
            if (cur_sum - sum == 0) {
                start = 0;
                end = i;
                break;
            }
            //if hashMap already has the value, means we already
            // have subarray with the sum - so stop
            if (hashMap.containsKey(cur_sum - sum)) {
                start = hashMap.get(cur_sum - sum) + 1;
                end = i;
                break;
            }
            //if value is not present then add to hashmap
            hashMap.put(cur_sum, i);

        }
        // if end is -1 : means we have reached end without the sum
        if (end == -1) {
            System.out.println("No subarray with given sum exists");
        } else {
            System.out.println("Sum found between indexes "
                    + start + " to " + end);
        }

    }
}
