package programming2020;

public class SecondSmallestAndLargestElement {

    public static void main(String[] args) {
        int arr [] = {12, 13, 1, 10, 34, 1};
        getSmallestAndSecondSmallest(arr);//Similar logic for Largest and Second Largest element in the array

    }

    private static void getSmallestAndSecondSmallest(int[] arr) {
        int smallest = arr[0];
        int secondSmallest = arr[0];

        for(int i =1; i<arr.length; i ++){
            if(arr[i]<smallest){
                secondSmallest = smallest;
                smallest = arr[i];
            }
            else if(arr[i] < secondSmallest && arr[i] != smallest){
                secondSmallest = arr[i];
            }
        }

        System.out.println("Smallest and Second smallest elements are :" + smallest+ " and "+ secondSmallest);
    }

}
