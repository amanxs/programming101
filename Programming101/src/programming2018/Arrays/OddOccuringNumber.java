package programming2018.Arrays;

public class OddOccuringNumber {

	/**
	 * A Simple Solution is to run two nested loops. 
	 * The outer loop picks all elements one by one and inner loop counts number
	 * of occurrences of the element picked by outer loop. Time complexity of this solution is O(n2).
	 * 
	 * A Better Solution is to use Hashing. Use array elements as key and their counts as value.
	 *  Create an empty hash table.One by one traverse the given array elements and store counts.
	 *  Time complexity of this solution is O(n).But it requires extra space for hashing.
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void OddOccurenceCheck(int[] arr) {
		
		int oddNumber = 0;
		
		int maxValue = 0;
		
		for (int i : arr) {
			if (i > maxValue) maxValue = i;
		}
		
		int[] hashedArray = hashArray(arr, maxValue);
		
		for (int i : hashedArray) {
			if(hashedArray[i] % 2 != 0) oddNumber = i;
		}
		
	}

	private int[] hashArray(int[] arr, int maxValue) {
		
		int[] a = new int[maxValue];
		for (int j = 0; j < arr.length; j++) {	
			a[arr[j]]++ ;
		}
		return a;

		
	}

}
