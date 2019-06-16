package programming2019.geeksForGeeks.mustDoCodingQuestions.heap;

import java.util.Scanner;

public class MedianInAStreamOfIntegers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();// Total number of elements
        int median =0;
        while(n-- > 0){
            int number = in.nextInt();
            median = getMedian(number);
        }
    }


    static int arr[] = {5,15,10,20,3};

    private static void testGetMedian(){
        for(int i =0; i< arr.length; i++){
            System.out.println(getMedian(arr[i]));
            System.out.println(getMedianUsingInsertionSort(arr[i], i+1));
        }
    }

    private static int getMedianUsingInsertionSort(int number, int n) {
        for (int i = n-1; i >=0; n--) {
            if(arr[i]<arr[i-1])
                swap(i, i-1);
        }
        if(n%2 ==0){
            return (arr[n/2] + arr [n/2 -1])/2;
        }
        else
           return arr[n/2] ;
    }

    private static int getMedian(int number) {
        return 0;
    }

    private static void swap(int i, int j) {
    }
}
