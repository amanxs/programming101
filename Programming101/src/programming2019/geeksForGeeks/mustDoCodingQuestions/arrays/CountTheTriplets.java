package programming2019.geeksForGeeks.mustDoCodingQuestions.arrays;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.
 */
public class CountTheTriplets {
    public static void main(String[] args) {
        int arr[] = {1, 5, 3, 2};
    }

    private static int count_triplets(int arr[]){
        int count =0;
        HashMap map = new HashMap();
        Arrays.sort(arr);// 1 2 3 5
        int n = arr.length;
        for(int i = n-1; i>1 ; i--){

        }

        return count;
    }
}
