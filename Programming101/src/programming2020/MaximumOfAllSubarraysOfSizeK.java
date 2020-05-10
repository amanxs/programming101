package programming2020;

import java.util.LinkedList;
import java.util.List;

public class MaximumOfAllSubarraysOfSizeK {

    public static void main(String args[]){
        int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6}, K = 3;

        List<Integer> maxs = getMaxOfAllSubarrays(arr, K);

        for(int max : maxs){
            System.out.println(max);
        }

    }

    public static List getMaxOfAllSubarrays(int arr[], int k){
        List<Integer> list = new LinkedList<>();
        int max = getMax(0, k, arr);
        list.add(max);
        for(int i=1; i<= arr.length-k; i++){
            if(arr[i-1]<max && arr[i+k-1]<max){
            }
              else if (arr[i+k-1]>=max){
                  max = arr[i+k-1];
              }
              else{
                  max = getMax(i,i+k, arr);
            }

                list.add(max);

        }

        return list;
    }

    public static int getMax(int i, int j, int arr[]){
        int max = arr[i];

        for(int index= i+1 ; index< j; index++ ){
            if(arr[index] > max)
                max = arr[index];
        }

        return max;
    }

}

