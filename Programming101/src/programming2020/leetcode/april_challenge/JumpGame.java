package programming2020.leetcode.april_challenge;

public class JumpGame {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{3,2,1,0,4}));
    }

    public  static boolean canJump(int[] nums) {
        int jump= 0;
        int n= nums.length-1;
        for(int i=0; i<nums.length; i++){
            jump = Integer.max(nums[i], jump);

            if(n-jump<=0){
                return true;
            }
            else if(jump==0){
                return false;
            }
            n--;
            jump--;
        }

        return false;

    }
}
