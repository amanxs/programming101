package programming2018.Arrays;


public class Reverse {
	
	
	/*Driver function to check for above functions*/
    public static void main (String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        printArray(arr, 6);
        rvereseArray(arr, 0, 5);
        System.out.println("Reversed array is ");
        printArray(arr, 6);
    }
    
    
    /**
     * Function to reverse an array recursively
     * @param arr
     * @param i
     * @param j
     */
	private static void rvereseArray(int[] arr, int i, int j) {

		if(i>j){
		
			swap(arr, i, j);
			
			rvereseArray(arr, i++, j--);
		}
	}



	public static void reverse(int[] a) {
		
		int N = a.length;
		
		for (int i = 0; i < N/2; i++) {
			swap(a,i,N-i-1);
		}
		
	}

	private static void swap(int[] a, int i, int j) {

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
	}
	
	  /* Utility that prints out an array on a line */
    static void printArray(int arr[], int size)
    {
        int i;
        for (i=0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

}
