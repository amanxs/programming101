package programming2018.goldmanSachs.algoDs;

public class SortArrayInWaveForm {
    // A simple solution is to sort the array and then swap adjacent elements

    public static void main(String args[]){
        int arr[] = { 1, 1, 1, 2, 2, 2};
        sortArray(arr,arr.length);
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] +" ");
        }

    }

/**
 * This can be done in O(n) time by doing a single traversal of given array.
 * The idea is based on the fact that if we make sure that all odd positioned (at index 1, 3, 5, ..) elements
 * are smaller than their adjacent even elements,
 */

    static void sortArray(int arr[], int n){
        for(int i=1; i<n; i+=2){

            if(arr[i]>arr[i-1])
                swap(arr,i,i-1);

            if(i+1< n && arr[i]>arr[i+1])
                swap(arr,i, i+1);
        }
    }

    static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
