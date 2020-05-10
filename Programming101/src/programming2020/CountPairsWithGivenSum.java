package programming2020;

import java.util.HashMap;
import java.util.Map;

public class CountPairsWithGivenSum {
    /**
     * Given an array of integers, and a number ‘n’,
     * find the number of pairs of integers in the array whose sum is equal to ‘n’.
     */

    public static void main(String args[]){
        int arr[] = {1, 5, 7, -1, 5};
        int pairs = countPairs(arr, 6);
        System.out.println(pairs);
    }

    /**
     * Input  :  arr[] = {1, 5, 7, -1, 5}, sum = 6
        Output :  3
        Pairs with sum 6 are (1, 5), (7, -1) & (1, 5)
     * @return
     */
    public static int countPairs(int arr[], int sum){
        int count = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
           int e = arr[i];
           if(countMap.containsKey(e)){
               countMap.put(arr[i], countMap.get(e)+1);
           }
           else{
               countMap.put(arr[i], 1);
           }
           int pair = sum - e;
           if(countMap.containsKey(pair)){
               if (pair != e) {
                   count += countMap.get(pair);
                   System.out.println("Counting Pair found : " + e +" & " + pair );
               }
               else if(pair==e && countMap.get(pair)%2==0){
                   count += countMap.get(pair)/2;
                   System.out.println("Counting Pair found : " + e +" & " + pair );

               }

           }

        }
        return count;
    }
}
