package programming2019.sorting;

import static programming2019.sorting.Sorting.swap;

public class QuickSort {

    public static void sort(Comparable a[]){
        sort(a, 0, a.length-1);
    }

    private static void sort(Comparable a[], int lo, int hi){
        if(hi<=lo) return;
        int partition_index = partition(a, lo, hi);
        sort(a, lo, partition_index);
        sort(a, partition_index+1,hi);

    }

    private static int partition(Comparable[] arr, int lo, int hi) {
        int j = hi;
        int i = lo;
        for (int k = lo; k < j ; k++) {
            swap(arr, j, j-1);
            swap(arr, j, k);
            j--;
            k--;
        }
        return j;
    }

    private static int partition_2(Comparable[] a, int lo, int hi)
    {  // Partition into a[lo..i-1], a[i], a[i+1..hi].
        int i = lo, j = hi+1;            // left and right scan indices
        Comparable v = a[lo];            // partitioning item
        while (true)
        {  // Scan right, scan left, check for scan complete, and exchange.
            while (Sorting.less(a[++i], v)) if (i == hi) break;
            while (Sorting.less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            swap(a, i, j);
        }
        swap(a, lo, j);

    return j;
    }

    /**
     * This sort code partitions to put keys equal to the partitioning element in place and
     * thus does not have to include those keys in the subarrays for the recursive calls.
     * It is far more efficient than the standard quicksort implementation for arrays with large numbers of duplicate keys.
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort3way(Comparable[] a, int lo, int hi)
    {  // See page 289 for public sort() that calls this method.
        if (hi <= lo) return;
        int lt = lo, i = lo+1, gt = hi;
        Comparable v = a[lo];
        while (i <= gt)
        {
            int cmp = a[i].compareTo(v);
            if      (cmp < 0) swap(a, lt++, i++);
            else if (cmp > 0) swap(a, i, gt--);
            else              i++;
        }  // Now a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        sort3way(a, lo, lt - 1);
        sort3way(a, gt + 1, hi);
    }
}
