package programming2020;

import java.util.Arrays;

public class WaysToReachNthStair {

    /**
     * Given 3 numbers {1, 3, 5}, we need to tell the total number of ways we can form a number 'N'
     using the sum of the given three numbers.
     * @param args
     */
    public static void main(String args[]){
//        int n1= countWays(80);
//        System.out.println(n1);
        int n2 = countWaysDp(80);
        System.out.println(n2);
    }

    public static int countWays(int n){
        if (n<0){
            return 0;
        }

        if(n==0)
            return 1;

        return countWays(n-1) + countWays(n-3) + countWays(n-5);
    }

    public static int countWaysDp(int n){
        int DP[] = new int[n+1];
        Arrays.fill(DP, -1);
        return countWaysTopDown(n, DP);
    }

    private static int countWaysTopDown(int n, int[] DP) {
        if (n<0){
            return 0;
        }

        if(n==0)
            DP[n] = 1;

        if(DP[n] == -1) {
            DP[n] = countWaysTopDown(n - 1, DP) + countWaysTopDown(n - 3, DP) + countWaysTopDown(n - 5, DP);
        }
        return DP[n];
    }
}
