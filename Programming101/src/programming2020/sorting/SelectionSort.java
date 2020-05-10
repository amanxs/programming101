package programming2020.sorting;

public class SelectionSort {

    public static void main(String args[]){
        int arr[] = {5,2,4,6,1,3};
        sort(arr);
        printArr(arr);
    }

    public static void printArr(int arr[]){
        for(int i =0; i< arr.length; i++){
            System.out.println(arr[i]);
        }

    }

    public static void sort(int arr[]){
        for(int i =1; i< arr.length; i++){
            for(int j=i; j>0 && arr[j]<arr[j-1]; j--){
                swap(arr, j, j-1);
            }
        }
    }

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
