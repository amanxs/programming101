package programming2018.geeksForGeeks.arrays;

public class SubarrayWithGivenSum {

    /**
     * Given an unsorted array of nonnegative integers, find a continous subarray which adds to a given number.
     */
    public static void main(String args[]){
        int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};;

        getSubarray(arr, 23);
    }

    static int getSubarray(int arr[], int sum){

        int start= 0;
        int result = 0;
        for(int end =0; end< arr.length ; end++){
            result += arr[end];

            while(result>sum && start<end){

                result -= arr[start];
                start++;

            }

            if(sum == result) {
                System.out.println("Sum found between indexes " + start
                        + " and " + end);
                return 1;
            }

        }

        System.out.println("No subarray found");
        return 0;
    }
}
