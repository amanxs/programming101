package programming2020.leetcode.may_challenge;

public class MaxSumCircularSubarray {

    public static void main(String[] args) {
        int arr[] = {1,-2,3,-2};
        System.out.println(maxSubarraySumCircular(arr));
    }

    public static int maxSubarraySumCircular(int[] A) {
        int n = A.length;
        int curr_sum = A[0];
        int min_sum = A[0];

        //curr_sum=max_sum;
        for(int i =1; i<n; i++){
            curr_sum = Math.min(curr_sum+A[i], A[i]);
            System.out.println(curr_sum);
            min_sum = Math.min(curr_sum, min_sum);
            System.out.println(min_sum);
        }
        System.out.println(min_sum);
        int sum = 0;
        for(int i =0; i<n; i++){
            sum += A[i];
        }
        System.out.println(sum);
        int max_sum  = sum - min_sum;


        if(max_sum<0){
            max_sum = A[0];
            for(int i=0; i<n; i++){
                if(A[i]>max_sum){
                    max_sum= A[i];
                }
            }
        }

        return max_sum;
    }



}
