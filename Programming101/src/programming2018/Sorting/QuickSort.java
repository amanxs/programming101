package programming2018.Sorting;

public class QuickSort {


    public void sort(Comparable[] arr, int low, int high) {

        if (low < high) {
            /* This function takes last element as pivot, places the pivot element at its correct position in sorted
            array, and places all smaller (smaller than pivot) to left of pivot and all greater elements to right
            of pivot */

            int pi = partition(arr, low, high);

            swap(arr, pi, high);

            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    private int partition(Comparable[] arr, int low, int high) {
        Comparable pivot = arr[high];
        int lessCount = 0;
        for (int i = low; i < high; i++) {
            if (less(arr[i], pivot)) {
                lessCount++;
                swap(arr, i, low+lessCount);
            }
        }
        return low + lessCount;

                /*GeeksForGeeksSolution

        Comparable pivot = arr[high];    // pivot

        int i = (low - 1);  // Index of smaller element

        for (int j = low; j <= high- 1; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (less(arr[j], pivot))
            {
                i++;    // increment index of smaller element
                swap(arr, i , j);
            }
        }

        int pi = i+1; */
    }

    public static void swap(Comparable[] arr, int a, int b) {
        Comparable temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;

    }

    // Driver method
    public static void main(String args[]) {
        Integer arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");

        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
    }
}
