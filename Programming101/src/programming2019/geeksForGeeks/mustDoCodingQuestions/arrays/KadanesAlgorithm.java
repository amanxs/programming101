package programming2019.geeksForGeeks.mustDoCodingQuestions.arrays;

public class KadanesAlgorithm {
    //Given an array arr of N integers. Find the contiguous sub-array with maximum sum.

    public static void main(String[] args) {
        //int arr[] = {10, 8, -12, 5, -9, 100};
        int arr[] = {-1, 2, 3, -2, 5};

        int n = arr.length;
        maxSubArray(arr, n);

    }

    private static void maxSubArray(int[] arr, int n) {
        int curr_max =arr[0];
        int max_so_far = arr[0];

        for (int i = 1; i < n; i++) {
            System.out.println(max_so_far);


            curr_max = Integer.max(arr[i], curr_max+arr[i]);

            max_so_far = Integer.max(curr_max, max_so_far);

        }

        System.out.println("Max subarray is : " + max_so_far);
    }

}
