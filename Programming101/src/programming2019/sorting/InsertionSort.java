package programming2019.sorting;

import static programming2019.sorting.Sorting.less;
import static programming2019.sorting.Sorting.show;
import static programming2019.sorting.Sorting.swap;

public class InsertionSort {

    public static void main(String[] args) {
        Integer[] arr = {64,25,12,22,11};
        sort(arr);
        show(arr);
    }

    private static void sort(Integer[] arr) {
        int n = arr.length;
        for (int i = 1; i < n ; i++) {
            for (int j = i; j >0 && less(arr[j], arr[j-1]) ; j--) {
                swap(arr, j, j-1);
            }
        }
    }




}
