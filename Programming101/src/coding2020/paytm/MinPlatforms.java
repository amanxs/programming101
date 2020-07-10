package coding2020.paytm;

import java.util.Arrays;

public class MinPlatforms {
    // Driver program to test methods of graph class
    public static void main(String[] args)
    {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        int n = arr.length;
        System.out.println("Minimum Number of Platforms Required = "
                + minPlatforms(arr, dep, n));
    }


    private static int minPlatforms(int arr[], int dept[], int n){
        int minPlatforms = 0;
        int result= 0;

        Arrays.sort(arr);
        Arrays.sort(dept);

        int i=0;
        int j=0;
        while(i< arr.length && j<dept.length){
            if(arr[i]< dept[j]){
                minPlatforms++;
                i++;
            }
            else{
                minPlatforms--;
                j++;
            }
            System.out.println(minPlatforms);
            result = Math.max(minPlatforms, result);

        }


        return result;
    }
}
