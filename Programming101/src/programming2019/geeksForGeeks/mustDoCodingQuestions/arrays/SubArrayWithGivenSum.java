package programming2019.geeksForGeeks.mustDoCodingQuestions.arrays;

/**
 * Given an unsorted array of non negative integers, find a continuous subarray which adds to a given number.
 */
public class SubArrayWithGivenSum {
    /**
     * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
     * Ouptut: Sum found between indexes 2 and 4
     */

    public static void main(String[] args) {
        int arr[] = {1, 4, 20, 3, 10, 5};
        int sum =33;
        subArrayWitGivenSum(arr, sum);

    }

    //Sliding window solution
    private static void subArrayWitGivenSum(int[] arr, int sum) {
        int subArraySum=0;
        int start=0;
        int end=0;
        for (;end < arr.length; end++) {
            subArraySum += arr[end];
            while(subArraySum>=sum && end>start ){
                if(subArraySum==sum){
                    System.out.println("Sum found between indexes " + start + " and " + end);
                    return;
                }
                subArraySum -= arr[start];
                start++;
            }

        }
    }

}
