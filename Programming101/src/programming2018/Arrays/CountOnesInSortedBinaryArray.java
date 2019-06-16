package programming2018.Arrays;

public class CountOnesInSortedBinaryArray {
	
	/*The array is assumed to be sorted in non-increasing order */
	
	int countOnesInSortedBinary(int arr[], int low, int high){
	      if (high >= low)
	      {
	        // get the middle index
	        int mid = low + (high - low)/2;
	 
	        // check if the element at middle index is last 1
	        if ( (mid == high || arr[mid+1] == 0) &&
	             (arr[mid] == 1))
	          return mid+1;
	 
	        // If element is not last 1, recur for right side
	        if (arr[mid] == 1)
	          return countOnesInSortedBinary(arr, (mid + 1), high);
	 
	        // else recur for left side
	        return countOnesInSortedBinary(arr, low, (mid -1));
	      }
	      return 0;
	    }

	   
	/* Driver program to test above functions */
    public static void main(String args[])
    {
    	CountOnesInSortedBinaryArray ob = new CountOnesInSortedBinaryArray();
       int arr[] = {1, 1, 1, 1, 0, 0, 0};
       int n = arr.length;
       System.out.println("Count of 1's in given array is " +
                           ob.countOnesInSortedBinary(arr, 0, n-1) );
    }
}
