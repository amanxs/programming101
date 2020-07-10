package programming2020.leetcode.june_challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

    public static void main(String[] args) {

    }


    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();

        if(nums==null||nums.length==0)
            return result;

        int n = nums.length;

        if(n==1) {
            result.add(nums[0]);
            return result;
        }

        //Step 1 : sort | nlogn
        Arrays.sort(nums);

        int count[] = new int[n];

        int indexTo[] = new int[n];

        Arrays.fill(count, 1);
        Arrays.fill(indexTo, -1);

        int maxSubset =0;
        int maxSubsetIndex = -1;

        for(int i=1; i<n; i++){
            for(int j=i-1; j>=0; j--){
                if(nums[i]%nums[j]==0){
                    if(count[j] + 1 > count[i]){
                        count[i] = count[j] + 1;
                        indexTo[i] = j;
                    }
                }
            }

            if(maxSubset<count[i]){
                maxSubset=count[i];
                maxSubsetIndex=i;
            }
        }

        for (int i = maxSubsetIndex ; i >=0 ; i = indexTo[i]) {
            result.add(nums[i]);
        }

        return result;
    }
}
