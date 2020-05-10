package programming2020;

public class DutchNationalFlag {

    public static void main(String args[]){
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int arr_size = arr.length;
        sort012(arr, arr_size);
        System.out.println("Array after seggregation ");
        printArray(arr);
    }

    private static void printArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
    private static void sort012(int[] arr, int length) {
        int index0 = 0;
        int index1 = 0;
        int index2 = length -1;
        while(index1<=index2){
            switch(arr[index1]){
                case 0:
                    swap(arr, index0, index1);
                    index0++;
                    index1++;
                    break;
                case 1:
                    index1++;
                    break;
                case 2:
                    swap(arr, index2, index1);
                    index2--;
                    break;
            }
        }

        return;
    }

    private static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


