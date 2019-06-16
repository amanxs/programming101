package programming2018.morganStanley;

public class KadanesAlgo {

    public static void main(String args[]){
        int arr[] = {-2,-3,-4,-1,-2,-1,-5,-3};

        System.out.println(getMaxSumSubArray(arr,arr.length));
    }

    static int getMaxSumSubArray(int arr[], int n){
        int maxSoFar=arr[0];
        int currMax=arr[0];

        for(int i =1; i<n; i++){
            currMax=Math.max(currMax+arr[i],arr[i]);
            maxSoFar=Math.max(currMax,maxSoFar);
            Integer.valueOf("1");
        }

        return maxSoFar;
    }


}
