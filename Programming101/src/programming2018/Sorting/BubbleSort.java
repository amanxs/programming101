package programming2018.Sorting;

import java.util.Scanner;

public class BubbleSort {

	 
	public static void sort(Comparable[] a)
     { 
		int N = a.length;
		
		for(int i =0; i<N; i++){
			
			for (int j = 0; j <N-i; j++) {
				
				if(less(a[j+1],a[j]))
					swap(a, j+1, j);
			}
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
