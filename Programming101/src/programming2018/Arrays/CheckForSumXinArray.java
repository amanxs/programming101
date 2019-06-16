package programming2018.Arrays;

/**
 * Given a sorted array and a number x, find the pair in array whose sum is
 * closest to x
 * 
 * @author amanarora
 *
 */
public class CheckForSumXinArray {

	// Driver program to test above function
	public static void main(String[] args) {
		int arr[] = { 10, 14, 22, 28, 29, 30, 40 }, x = 52;
		int n = arr.length;
		printClosest(arr, n, x);
	}



	private static void printClosest(int[] arr, int length, int x) {
		int res_l = 0;
		int res_r = 0; // To store indexes of result pair

		int diff = Integer.MAX_VALUE;

		int left = 0, right = length - 1;

		while (left < right) {
			int tempDiff = Math.abs(arr[left] + arr[right] - x);

			if (diff > tempDiff) {
				diff = tempDiff;
				res_l = left;
				res_r = right;

			}
			if (tempDiff < 0)
				left++;
			else
				right--;

		}

		System.out.println(" The closest pair is " + arr[res_l] + " and " + arr[res_r]);

		/*
		 * if(arr[length-1] >x && arr[0]> x ) System.out.println(arr[0] &
		 * arr[1]);
		 * 
		 * for (int i = length-1; i >0; i--) { if(arr[i] > x && arr[0] < x)
		 * continue; diff = x - arr[i] + arr[i-1];
		 * 
		 * }
		 */

	}
}
