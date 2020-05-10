package programming2020;

import java.util.HashMap;
import java.util.Map;

public class CheckArraysEquality {

    public static void main(String args[]){

        int arr1[] = { 3, 5, 2, 5, 2 };
        int arr2[] = { 2, 3, 5, 5, 2 };

        if (areEqual(arr1, arr2))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    /**
     *Two arrays are said to be equal if both of them contain same set of elements, arrangements
     * (or permutation) of elements may be different though.
     * Note : If there are repetitions, then counts of repeated elements must also be same
     * for two array to be equal.
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean areEqual(int arr1[], int arr2[]){
        if(arr1.length != arr2.length)
            return false;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i =0; i<arr1.length ; i++){
            int e1= arr1[i];
            if(map.containsKey(e1)){
                map.put(e1, map.get(e1)+1);
            }
            else{
                map.put(e1, 1);
            }

            int e2 = arr2[i];
            if(map.containsKey(e2)){
                map.put(e2, map.get(e2)-1);
            }
            else{
                map.put(e2, -1);
            }
        }

        for(Integer value : map.values()){
            System.out.println(value);
            if(!value.equals(0)){
                return false;
            }
        }
        return true;
    }
}
