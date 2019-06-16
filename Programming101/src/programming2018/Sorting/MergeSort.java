package programming2018.Sorting;

public class MergeSort extends SortingTemplate {

    public void mergeSort(int arr[], int l, int r) {


        if(l<r) {
            // Same as (l+r)/2, but avoids overflow for large l and h
            int medium = l + r - l / 2;

            mergeSort(arr,l,medium);
            mergeSort(arr,medium+1,r);
            merge(arr,l,medium,r);
        }
    }

    private void merge(int[] arr, int l, int m, int r) {
        //size of subarrays to be merged
        int sizeLeft = m - l + 1;
        int sizeRight = r - m;

        int [] leftArray = new int[sizeLeft];
        int [] rightArray = new int[sizeRight];

        int leftPointer = 0 , rightPointer = 0, arrayIndex = l;

        while(leftPointer< sizeLeft && rightPointer <sizeRight){
            if(less(leftArray[leftPointer],rightArray[rightPointer])){
                arr[arrayIndex] = leftArray[leftPointer];
                leftPointer++;
            }
            else{
                arr[arrayIndex] = rightArray[rightPointer];
                rightPointer++;
            }

            arrayIndex++;
        }

                /* Copy remaining elements of L[] if any */
        while (leftPointer <sizeLeft)
        {
            arr[arrayIndex] = leftArray[leftPointer];
            leftPointer++;
            arrayIndex++;
        }

        /* Copy remaining elements of R[] if any */
        while (rightPointer < sizeRight)
        {
            arr[arrayIndex] = rightArray[rightPointer];
            rightPointer++;
            arrayIndex++;
        }
    }

    public static void swap(Comparable []arr, int a, int b ){
        Comparable temp =  arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b)<0;

    }

    // Driver method
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");

        MergeSort ob = new MergeSort();
        ob.mergeSort(arr, 0, arr.length-1);

        System.out.println("\nSorted array");
    }
}
