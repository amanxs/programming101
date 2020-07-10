package coding2020.sorting;

public class SortingTemplate {

    public static void swap(int arr[], int i, int j){
        //base case
        int temp= arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
