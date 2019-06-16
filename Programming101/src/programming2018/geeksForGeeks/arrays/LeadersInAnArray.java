package programming2018.geeksForGeeks.arrays;

public class LeadersInAnArray {
    /**
     * Write a program to print all the LEADERS in the array.
     * An element is leader if it is greater than all the elements to its right side.
     * And the rightmost element is always a leader. For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
     */

    public static void main(String[] args) {
        int arr[] = new int[]{16, 17, 4, 3, 5, 2};
        int n = arr.length;
        printLeaders(arr, n);
    }

    static void printLeaders(int arr[], int n){
        int lastMax = 0;
        for(int i=n-1; i>=0; i--){
            if(arr[i]>lastMax){
                System.out.println("Leader : " + arr[i]);
                lastMax=arr[i];
            }
        }
    }
}
