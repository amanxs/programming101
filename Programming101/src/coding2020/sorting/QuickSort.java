package coding2020.sorting;

public class QuickSort extends SortingTemplate{

    public static void main(String[] args) {
        int arr[] = {3,8,2,5,1,4,7,6};
    }

    public static void sort(int arr[], int l, int r){

        int p = partition(arr, l ,r);
        sort(arr, l, p-1);
        sort(arr, p+1, r);
    }

    public static int partition(int arr[], int l, int r){
        int pivot=l;

        for(int i =l+1; i<r; i++){
            if(arr[i]<arr[l]){
                pivot++;
                swap(arr,pivot,i);
            }
        }
        swap(arr,l,pivot);
        return pivot;
    }

}
