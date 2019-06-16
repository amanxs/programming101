package programming2018.geeksForGeeks.arrays;

public class LargestSubarrayOf0sAnd1s {
    /**
     * Given an array containing only 0s and 1s, find the largest subarray which contain equal no of 0s and 1s.
     * Expected time complexity is O(n).
     */

    public static void main(String[] args) {
        int arr[] = {0, 0, 1, 1, 0};
        //Input: arr[] = {1, 0, 1, 1, 1, 0, 0}

    }

    // this can be done by creating a new array with all the 0s replaced with -1.
    // So this basically becomes a question of max subarray with sum 0

    static void largestSubarray(int arr[], int n){

        int start = 0;
        int largestSubArray = 0;

        int count0s =0;
        int count1s =0;

        for(int end=0;end<n;end++){
            switch (arr[end]){
                case 0:
                    count0s++;
                    break;

                case 1:
                    count1s++;
                    break;
            }

            if(count0s==count1s){
                largestSubArray++;
            }
        }
    }
}
