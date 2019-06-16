package programming2019.sorting;

import static programming2019.sorting.Sorting.show;

public class MergeSort {

    public static void main(String[] args) {
            Integer[] arr = {64,25,12,22,11};
            sort(arr);
            show(arr);

    }

    private static void sort(Integer[] arr) {

    }

    private static void merge(Integer[] arr, int l, int r){
        int m = (l + r)/2;

        int lIndex = m-l;
        int rIndex = r-m;

        int left[] = new int[lIndex];
        int right[] = new int[rIndex];

        for(int i=l; i<m; i++){
            left[i-l] = arr[i];
        }

        for(int i=m; i<=r; i++){
            right[i-m] = arr[i];
        }
        int i_left =0;
        int i_right =0;
        int merged[] = new int[i_left+rIndex];
        int k=0;

        while(i_left< lIndex && i_right<rIndex){

            if(left[i_left]<right[i_right]){
                merged[k] = left[i_left];
                i_left++;
            }

            else if(right[i_right]<left[i_left]){
                merged[k] = right[i_right];
                i_right++;
            }

            k++;
        }

        while(i_left<lIndex){
            merged[k] = left[i_left];
            i_left++;
            k++;

        }

        while (i_right<rIndex){
            merged[k] = right[i_right];
            i_right++;
            k++;
        }

    }
}
