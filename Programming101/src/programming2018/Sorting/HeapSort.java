package programming2018.Sorting;

import java.util.Scanner;

public class HeapSort {

	/**
	 * This code sorts a[1] through a[N] using the sink() method (modified to take a[] and N as arguments).
	 * The for loop constructs the heap; then the while loop exchanges the largest element a[1] with a[N]
	 * and then repairs the heap, continuing until the heap is empty.
	 * Decrementing the array indices in the implementations of swap() and less() gives an implementation
	 * that sorts a[0] through a[N-1], consistent with our other sorts.
	 * @param a
	 */
	
	public static void sort(Comparable[] a)
    { 
		int N = a.length;
		
			heapify(a, N);
		
			while(N > 1){
			
				swap(a,1,N--);
				sink(a,1,N);
			}
		
		
    }
	
    
	 private static void heapify(Comparable[] a, int N) {

		 for (int k = N/2; k >= 1; k--)
		        sink(a, k, N);
		 
	}

	   private void swim(Comparable[] a, int k, int N){
	    	while(k>1 && less(k/2, k)){    			
	    		swap(a, k/2, k);
	    		k=k/2;
	    	}
	    }
	   
	    private static void sink(Comparable[] a, int k, int N){
	    
	    	while(2*k <= N){
	    		
	    		int j = 2*k;
	    	
	    		if (less(j, 2*k+1)) {
				j++;
	    		}
	            
	    		if (!less(k, j)) break;
	            
	    		swap(a, j, k);
	    		k = j;
			}
	    }	

	private static boolean less(Comparable v, Comparable w)
    {  return v.compareTo(w) < 0;  }
    
    private static void swap(Comparable[] a, int i, int j)
    {  Comparable t = a[i]; a[i] = a[j]; a[j] = t;  }
    
    private static void show(Comparable[] a)
    {  // Print the array, on a single line.
       for (int i = 0; i < a.length; i++)
          System.out.print(a[i] + " ");
       System.out.println();
}
    
    public static boolean isSorted(Comparable[] a)
    {  // atoi whether the array entries are in order.
       for (int i = 1; i < a.length; i++)
          if (less(a[i], a[i-1]))  return false;
       return true;
    }
    
    public static void main(String[] args)
    {  // Read strings from standard input, sort them, and print.
   	 
   	Scanner scan = new Scanner(System.in);
   	Integer[] a = {64,25,12,22,11};
       sort(a);
       assert isSorted(a);
       show(a);

    }
	

}
