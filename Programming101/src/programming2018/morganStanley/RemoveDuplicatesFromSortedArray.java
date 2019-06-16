package programming2018.morganStanley;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String args[]){
        int arr[] = new int[]{1, 2, 2, 3, 4, 4, 4, 5, 6,6,7,8,9,9};//12234445667899

        reomveDuplicates(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }

    private static void reomveDuplicates(int[] arr) {
        int currElement = arr[0];
        int index=0;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i]!=currElement){
                currElement=arr[i];
                arr[++index] = arr[i];
            }
        }
        Arrays.fill(arr,++index,arr.length,0);
    }
}
