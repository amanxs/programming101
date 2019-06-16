package programming2018.goldmanSachs.algoDs;

public class SubarrayWithGivenSum {

    public static void main(String args[]){

    }

    static int subrraySum(int arr[], int sum, int n){
        int subarray = n;
        int currSum =0;
        int start = 0;

        for(int end=0; end<n;end++){

            if(arr[end]>sum) {
                System.out.println("Sum found between indexes " + start
                        + " and " + end);
                return 1;
            }
            currSum =+ arr[end];

            while(currSum>sum && start<end){
                currSum -= arr[start];
                start++;
            }

            if(currSum == sum){
                subarray = Integer.min(subarray,end-start);
                System.out.println("Sum found between indexes " + start
                        + " and " + end);
                return subarray;
            }
        }

        return -1;
    }

    /**
     * Time complexity of method 2 looks more than O(n), but if we take a closer look at the program,
     * then we can figure out the time complexity is O(n).
     * We can prove it by counting the number of operations performed on every element of arr[] in worst case.
     * There are at most 2 operations performed on every element: (a) the element is added to the curr_sum
     * (b) the element is subtracted from curr_sum. So the upper bound on number of operations is 2n which is O(n).
     */
}
