package programming2020.leetcode.april_challenge;

public class MaximumSubarray {
    public static void main(String[] args) {
        int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
    public static int maxSubArray(int nums[]){

        int curr_sum = 0;
        int max_sum = nums[0];
        for(int num : nums){
            curr_sum = Math.max(curr_sum+ num, num);
            max_sum = Math.max(max_sum, curr_sum);

        }

        return max_sum;
    }
}
