package programming2018.dynamicProgramming;

public class CoinChange {

    /**
     * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
     * how many ways can we make the change? The order of coins doesn’t matter.
     */

    public static void main(String[] args) {
        int arr[] = {2, 5, 3, 6};
        int sum = 10;
        int n = arr.length;

        System.out.println(getChange(arr,sum,n));
        System.out.println(getChangeDP(arr,sum,n, new int[n+1][sum+1]));


    }

    static int getChange(int arr[], int sum, int n){
        if(sum==0)
            return 1;

        if(sum>0 && n<=0)
            return 0;

        if(arr[n-1]>sum)
            return getChange(arr,sum,n-1);

        return getChange(arr,sum- arr[n-1], n) + getChange(arr, sum, n-1);

    }

     //static  int DP[][] = new int[Integer.MAX_VALUE][Integer.MAX_VALUE];

     static int getChangeDP(int arr[], int sum, int n, int DP[][]){
        if(DP[n][sum] != 0)
            return DP[n][sum];

        if(sum==0)
            return 1;

        if(sum>0 && n<=0)
            return 0;

        if(arr[n-1]>sum)
            DP[n][sum] = getChange(arr,sum,n-1);

        DP[n][sum] =  getChange(arr,sum- arr[n-1], n) + getChange(arr, sum, n-1);

        return DP[n][sum];
    }
}
