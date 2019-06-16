package programming2018.Arrays;

public class CommonElementsInSortedArrays {

	// Driver code to test above
	public static void main(String args[]) {
		CommonElementsInSortedArrays ob = new CommonElementsInSortedArrays();

		int ar1[] = { 1, 5, 10, 20, 40, 80 };
		int ar2[] = { 6, 7, 20, 80, 100 };
		int ar3[] = { 3, 4, 15, 20, 30, 70, 80, 120 };

		System.out.print("Common elements are ");
		ob.findCommon(ar1, ar2, ar3);
	}

	/**
	 * The idea is similar to intersection of two arrays. Like two arrays loop,
	 * we run a loop and traverse three arrays.
	 * 
	 * @param ar1
	 * @param ar2
	 * @param ar3
	 */
	private void findCommon(int[] ar1, int[] ar2, int[] ar3) {
		// Initialize starting indexes for ar1[], ar2[] and ar3[]
		int i = 0, j = 0, k = 0, min;

		for (int h = 0; h < ar3.length + ar2.length + ar1.length; h++) {
			if (ar1[i] == ar2[j] && ar2[j] == ar3[k]){
				System.out.print(ar1[i]+" "); i++; j++; k++;
			}else {
				min = min(ar1[i], ar2[j], ar3[k]);
				min++;
			}
		}
	}

	private int min(int i, int j, int k) {
		// x < y
        if (i<j)
          return  i;
        // y < z
        else if (j<k)
           return j;
        // We reach here when x > y and z < y, i.e., z is smallest
        else
           return k;
	}
}
