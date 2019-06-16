package programming2018.dynamicProgramming;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class LongestCommonSubsequence {

    public static void main(String args[]){
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char X[] = s1.toCharArray();
        char Y[] = s2.toCharArray();

        int result = lcsDPTopDown(X,Y,X.length,Y.length);
        System.out.print(result);


        Callable<String> callableTask = () -> {
            TimeUnit.MILLISECONDS.sleep(300);
            return "Task's execution";
        };

        Thread t = new Thread(new FutureTask<String>(callableTask));


    }

    static int lcs(char X[], char Y[], int m, int n){

        if(m==0||n==0)
            return 0;

        else if(X[m-1]==Y[n-1])
            return 1 + lcs(X,Y,m-1,n-1);

        else return Integer.max(lcs(X,Y,m-1,n),lcs(X,Y,m,n-1));
    }

    static int lcsDp(char X[], char Y[], int m, int n){

        int DP[][] = new int[m+1][n+1];

        /* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */

        for (int i = 0; i <=m ; i++) {
            for (int j = 0; j <=n ; j++) {
                if(i==0 || j==0)
                    DP[i][j] = 0;
                else if(X[i-1] == Y[j-1])
                    DP[i][j] = 1 + DP[i-1][j-1];
                else
                    DP[i][j] = Integer.max(DP[i-1][j],DP[i][j-1]);
            }

        }

        /* By the end of the loop would have traversed the strings X[0...m-1] and Y[0...n-1] and
           the value at DP[m][n] would be the LCS
        */
        return DP[m][n];
    }

    static int L[][] = new int[256][256];

    static int lcsDPTopDown(char X[], char Y[], int m, int n) {

        if (L[m][n] != 0)
            return L[m][n];

        if (m == 0 || n == 0)
            return 0;

        else if (X[m - 1] == Y[n - 1])
            L[m][n] = 1 + lcs(X, Y, m - 1, n - 1);

        else L[m][n] = Integer.max(lcs(X, Y, m - 1, n), lcs(X, Y, m, n - 1));

        return L[m][n];
    }
}
