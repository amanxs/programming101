package programming2020.leetcode.april_challenge;

public class LonelyInteger {

    public static void main(String[] args) {
        int arr[] = {4,1,2,1,2};//[2,2,1]
        int arr2[] = {2,2,1};
        int x = singleNumber(arr2);
        System.out.println(x);
    }

    public static int singleNumber(int[] nums) {
        int output = 0;
        for(int i=0; i< nums.length; i++){
            output = output^nums[i];
        }

        return output;
    }
}
