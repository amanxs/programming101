package programming2018.Arrays;


/**
 * The solution is to first separate positive and negative numbers using partition process of QuickSort.
 * In the partition process, consider 0 as value of pivot element so that all negative numbers are placed
 * before positive numbers. Once negative and positive numbers are separated,
 * we start from the first negative number and first positive number,
 * and swap every alternate negative number with next positive number.
 * @author amanarora
 *
 */
public class AlternatePositiveAndNegatives {

    // A utility function to print an array
    static void printArray(int arr[], int n)
    {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + "   ");
    }
	
    /*Driver function to check for above functions*/
	public static void main(String args[]){
        int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        int n = arr.length;
        rearrange(arr, n);
        System.out.println("Array after rearranging: ");
        printArray(arr,n);
	}

	/*
	 * The main function that rearranges the elements of the given array.
	 * It puts positive elements at the even positions and negative elements at odd positions 
	 */
	private static void rearrange(int[] arr, int n) {
		int partition = 0;

		segregatePositiveAndNegatives(arr, partition);
		
		int pos=0; int neg = partition ; 
		while(neg<n && pos<neg && arr[pos]>0)
		swap(arr, pos, neg);
		pos =+ 2;
		neg++;
	}

	private static void segregatePositiveAndNegatives(int[] arr, int partition) {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>0){
				swap(arr, i, partition);
				partition++;
			}
		}
	}

    private static void swap(int[] arr, int i, int j)
    {  int t = arr[i]; arr[i] = arr[j]; arr[j] = t;  }
    
    /**
     * 	Time Complexity: O(n) where n is number of elements in given array.
		Auxiliary Space: O(1)

		Note that the partition process changes relative order of elements.
     */
}
