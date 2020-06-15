package programming2020.leetcode.may_challenge;

/**
 * We write the integers of A and B (in the order they are given) on two separate horizontal lines.
 *
 * Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:
 *
 * A[i] == B[j];
 * The line we draw does not intersect any other connecting (non-horizontal) line.
 * Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: A = [1,4,2], B = [1,2,4]
 * Output: 2
 * Explanation: We can draw 2 uncrossed lines as in the diagram.
 * We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to B[1]=2.
 * Example 2:
 *
 * Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
 * Output: 3
 * Example 3:
 *
 * Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
 * Output: 2
 */
public class UncrossedLines {

    public int maxUncrossedLines(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int DP[][] = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                DP[i][j] = -1;
            }
        }
        return maxUncrossedLines(A, B, 0, 0, DP);
    }
    /*
    1, 3, 7, 1, 7, 5], B =
    1, 9, 2, 5, 1]
    */
    public int maxUncrossedLines(int[] A, int[] B, int i, int j, int DP[][]){

        if(i== A.length || j == B.length) return 0;// this will ensure that even if one index reaches the end the other is incremented until it reaches the end


        if(DP[i][j] != -1){
            return DP[i][j];
        }

        if(A[i] == B[j]){
            DP[i][j] = 1+ maxUncrossedLines(A, B, i+1, j+1, DP);//move both the indexes to make sure that value is matched just once
        }

        else{
            DP[i][j] = Math.max(maxUncrossedLines(A, B, i+1, j, DP),
                    maxUncrossedLines(A, B, i, j+1, DP));
        }

        return DP[i][j];

    }
}
