package programming2020;

import java.util.HashMap;
import java.util.Map;

public class SubrarraysWithSumK {
    public static void main(String[] args) {
        int arr[] = {1,1,1};
        int k =2;
        System.out.println(subarraySum(arr, k));
    }

    public static int subarraySum(int[] nums, int k) {
        if(nums.length ==1){
            return nums[0] !=k ? 0 : 1;
        }
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        int curr_sum = 0;
        int count =0;
        countMap.put(curr_sum, 1);
        for(int num : nums){
            curr_sum += num;
            if(countMap.containsKey(curr_sum-k)){
                count += countMap.get(curr_sum-k);
            }
            if(countMap.containsKey(curr_sum)){
                countMap.put(curr_sum, countMap.get(curr_sum) + 1);
            }
            else countMap.put(curr_sum, 1);
        }

        return count;
    }
}
