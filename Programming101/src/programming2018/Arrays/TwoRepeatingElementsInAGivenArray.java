package programming2018.Arrays;

import java.util.ArrayList;

public class TwoRepeatingElementsInAGivenArray {
    /**
     * You are given an array of n+2 elements. All elements of the array are in range 1 to n.
     * And all elements occur once except two numbers which occur twice. Find the two repeating numbers.

     For example, array = {4, 2, 4, 5, 2, 3, 1} and n = 5

     The above array has n + 2 = 7 elements with all elements occurring once except 2 and 4 which occur twice. So the output should be 4 2.
     */

    public static void main(String args[]){
        // if this is the case ** All elements of the array are in range 1 to n
        //Then we can use the same approach to find the 1 duplicate in an array

        int arr [] = new int[]{4, 2, 4, 5, 2, 3, 1};
        ArrayList<Integer> list = getDuplicates(arr);
        for(Integer a : list){
            System.out.println(a);
        }
    }

    public static ArrayList<Integer> getDuplicates(int arr[]){
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i <arr.length ; i++) {
            int element = Math.abs(arr[i])-1;
            if(arr[element]<0)
                result.add(Math.abs(arr[i]));
            else
                arr[element] =  - arr[element];
        }
        return result;
    }
}
