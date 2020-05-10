package programming2020;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String args[]) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println("Length of LCS is" + " " +
                lcs.lcs(s1, s2));
        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;

//        System.out.println("Length of LCS is" + " " +
//                lcs.lcs(X, Y, m, n));
    }


    public static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int DP[][] = new int[m + 1][n + 1];
        // assign -1 to all positions
        for (int[] row : DP) {
            Arrays.fill(row, -1);
        }
        //return lcsDpMemoization(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length(), DP);
        return lcsDpTabulation(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());


    }

    public static int lcsDpTabulation(char s1[], char s2[], int m, int n){
        int DP[][] = new int[m+1][n+1];

        for(int i=0; i<=m; i++){
            for(int j=0; j<=n; j++){
                if(i==0 || j==0){
                    DP[i][j] =0;
                }
                else if(s1[i-1]==s2[j-1]){
                    DP[i][j] = 1 + DP[i-1][j-1];
                }
                else{
                    DP[i][j] = Integer.max(DP[i][j-1], DP[i-1][j]);
                }
            }
        }

        return DP[m][n];
    }

    public static int lcs(char s1[], char s2[], int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (s1[m - 1] == s2[n - 1]) {
            return 1 + lcs(s1, s2, m - 1, n - 1);
        } else {
            return Math.max(lcs(s1, s2, m - 1, n), lcs(s1, s2, m, n - 1));
        }
    }


    public static int lcsDpMemoization(char s1[], char s2[], int m, int n, int DP[][]) {
        if (DP[m][n] != -1) {
            return DP[m][n];
        }
        if (m == 0 || n == 0) {
            return 0;
        }
        if (s1[m - 1] == s2[n - 1]) {
            DP[m][n] = 1 + lcsDpMemoization(s1, s2, m - 1, n - 1, DP);
        } else {
            DP[m][n] = Math.max(lcsDpMemoization(s1, s2, m - 1, n, DP),
                    lcsDpMemoization(s1, s2, m, n - 1, DP));
        }

        return DP[m][n];
    }


}
