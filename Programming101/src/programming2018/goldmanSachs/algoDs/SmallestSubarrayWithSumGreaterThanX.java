package programming2018.goldmanSachs.algoDs;

public class SmallestSubarrayWithSumGreaterThanX {

    public static void main(String args[]){
        int test1[] = {1,4,15,6,10,19};
        int length = subArrayWithSumX(test1, test1.length,25);
        if(length==-1)
            System.out.println("Not possible");
        else
            System.out.print("length of subarray :"+ length );

        int test2[] = {1,10,5,2,7};
        int length2 = subArrayWithSumXBruteForce(test2, test2.length,9);
        if(length2==-1)
            System.out.print("Not possible");

    }

    /**
     * We can solve this problem by using a sliding window. The idea is to maintain a window that ends at the current element
     * and the sum of its element is less than or equal to the given sum. if current windows sum becomes more than the given sum than
     * the window is unstable and continue removing element from the window  till it becomes stable again.
     * We also update the result if the unstabnle window's length is less that one found so far.
     * @param arr
     * @param n
     * @param x
     * @return
     */
    static int subArrayWithSumX(int arr[], int n, int x){
        int currSum = 0;
        int result = n+1;

        int left= 0; // stores windows starting index

        //maintain a window from [left...righ]
        for(int right=0; right<n; right++){
            if(arr[right]>x)
                return 1;

            currSum += arr[right];

            //Kadane's algorithm
            if(currSum<=0){
                left=right;
                currSum=0;
            }

            while(currSum>x&&left<right){
                //remove elements from windows left side till window becomes stable again
                result=Integer.min(result,right-left+1);
                currSum -=arr[left];
                left++;
            }
        }
        return result;
    }
/*
Time complexity of method 2 looks more than O(n), but if we take a closer look at the program, then we can figure out the time complexity is O(n).
There are at most 2 operations performed on every element: (a) the element is added to the curr_sum (b) the element is subtracted from curr_sum.
So the upper bound on number of operations is 2n which is O(n).
 */


    static int subArrayWithSumXBruteForce(int arr[], int n, int x){
        int count =0;
        int minSubArray=n;
        for(int i=0;i<n;i++){
            int currSum = arr[i];
                count = 1;

            if(currSum>x)
                return count;

            for (int j = i+1; j < n; j++) {
                currSum+=arr[j];
                count++;

                if(currSum>x && count<minSubArray)
                    minSubArray=count;
            }
        }
        return minSubArray;
    }

}
