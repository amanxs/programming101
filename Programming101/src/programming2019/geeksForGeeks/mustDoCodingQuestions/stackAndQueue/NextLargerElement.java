package programming2019.geeksForGeeks.mustDoCodingQuestions.stackAndQueue;

/**
 * Given an array A of size N having distinct elements, the task is to find the next greater element for each element of the array
 * in order of their appearance in the array. If no such element exists, output -1
 *  For the input array [4, 5, 2, 25}, the next greater elements for each element are as follows.

 Element       NGE
 4      -->   5
 5      -->   25
 2      -->   25
 25     -->   -1
 */

public class NextLargerElement {
    public static void main(String[] args) {
        int arr [] = {4,5,2,25};
        nextGreaterElement(arr);
    }

    //Brute force
    private static void nextGreaterElement(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            int next = -1;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] > arr[i]){
                    next = arr[j];
                    break;
                }
            }
            System.out.println(arr[i] + " --> "+ next);

        }
    }

    //Optimize solution
    private static void nextGreaterElement(int arr[], int n){

    }

}
