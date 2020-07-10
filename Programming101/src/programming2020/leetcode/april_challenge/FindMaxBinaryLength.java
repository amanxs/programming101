package programming2020.leetcode.april_challenge;

import java.util.HashMap;
import java.util.Map;

public class FindMaxBinaryLength {

    public int findMaxLengthOpt(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxlen = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(count)) {
                maxlen = Math.max(maxlen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxlen;
    }

    public int findMaxLength(int[] nums) {
        for(int i=0 ; i< nums.length; i++){
            if(nums[i] ==0){
                nums[i] =-1;
            }
        }

        return maxSubarrayWithGivenSum(nums, 0);
    }

    public static int maxSubarrayWithGivenSum(int arr[], int X){
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max_len = 0; // Initialize result
        int ending_index = -1;
        int start_index = 0;
        int sum =0;
        int n = arr.length;
        for(int i=0 ; i< n; i++){
            sum += arr[i];

            if (sum == 0)
            {
                max_len = i + 1;
                ending_index = i;
            }

            if (map.containsKey(sum + n))
            {
                if (max_len < i - map.get(sum + n))
                {
                    max_len = i - map.get(sum + n);
                    ending_index = i;
                }
            }
            else // Else put this sum in hash table
                map.put(sum + n, i);
        }

        for (int i = 0; i < n; i++)
        {
            arr[i] = (arr[i] == -1) ? 0 : 1;

        }

        int end = ending_index - max_len + 1;
        System.out.println(end + " to " + ending_index);

        return max_len;}


}
