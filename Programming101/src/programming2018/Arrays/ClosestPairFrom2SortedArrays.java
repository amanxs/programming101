package programming2018.Arrays;

/**
 * Given two sorted arrays and a number x, find the pair whose sum is closest to
 * x and the pair has an element from each array.
 * 
 * @author amanarora
 */
public class ClosestPairFrom2SortedArrays {

	// Driver program to test above functions
	public static void main(String args[]) {
		ClosestPairFrom2SortedArrays ob = new ClosestPairFrom2SortedArrays();
		int ar1[] = { 1, 4, 5, 7 };
		int ar2[] = { 10, 20, 30, 40 };
		int m = ar1.length;
		int n = ar2.length;
		int x = 38;
		ob.printClosest(ar1, ar2, m, n, x);
	}

	private void printClosest(int[] ar1, int[] ar2, int m, int n, int x) {
		int left = 0, right = 0;
		int l = 0;
		int r = ar2.length - 1;
		int tempDiff = 0;
		int diff = Integer.MAX_VALUE;
		while (l<r && r>=0) {
			tempDiff = Math.abs(ar1[l] + ar2[r] - x);
			if (tempDiff < diff){
				diff = tempDiff;
				left = l;
				right = r;
			}
			if (tempDiff < 0)
				l++;
			else
				r--;
		}
		// Print the result
        System.out.print("The closest pair is [" + ar1[left] +
                         ", " + ar2[right] + "]");
	}

}
