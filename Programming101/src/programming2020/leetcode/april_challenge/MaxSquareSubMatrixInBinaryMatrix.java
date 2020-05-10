package programming2020.leetcode.april_challenge;

import java.util.concurrent.atomic.AtomicInteger;

public class MaxSquareSubMatrixInBinaryMatrix {
    public static void main(String[] args) {
        int[][] M =
                {
                        { 0, 0, 1, 0, 1, 1 },
                        { 0, 1, 1, 1, 0, 0 },
                        { 0, 0, 1, 1, 1, 1 },
                        { 1, 1, 0, 1, 1, 1 },
                        { 1, 1, 1, 1, 1, 1 },
                        { 1, 1, 0, 1, 1, 1 },
                        { 1, 0, 1, 1, 1, 1 },
                        { 1, 1, 1, 0, 1, 1 }
                };


        int[][] M2 ={{1,0}};

        // size stores the size of largest square sub-matrix of 1's
        // and it is passed by reference using AtomicInteger
        AtomicInteger max_size = new AtomicInteger();
        maxSuquareSubMatrixTopDown(M2, M2.length - 1, M2[0].length - 1, max_size);
        System.out.print("The size of largest square sub-matrix of 1's is " + max_size.get()*max_size.get());
    }

    public int maximalSquare(char[][] matrix) {
        //Integer max_size = new Integer(0);
        AtomicInteger max_size = new AtomicInteger();

        //maxSuquareSubMatrixTopDown(matrix, matrix.length - 1, matrix[0].length - 1, max_size);

        System.out.print("The size of largest square sub-matrix of 1's is " + max_size);

        return max_size.get()*max_size.get();

    }

    public static int maxSuquareSubMatrixTopDown(int matrix[][], int m, int n, AtomicInteger max){
        if(m==0 || n==0){
            max.set(Integer.max(max.get(), matrix[m][n]));
            return matrix[m][n];
        }
        int left = maxSuquareSubMatrixTopDown(matrix, m, n-1 ,max);
        int top = maxSuquareSubMatrixTopDown(matrix, m-1, n ,max);
        int diagonal =  maxSuquareSubMatrixTopDown(matrix, m-1, n-1 ,max);

        int size =0;
        if(matrix[m][n] != 0){
            size = 1 + Integer.min(Integer.min(left, top), diagonal);
        }

        max.set(Integer.max(size, max.get()));

        return size;

    }

    public static int findLargestSquare(int[][] M, int m, int n, AtomicInteger max_size)
    {
        // base condition
        if (m == 0 || n == 0) {
            max_size.set(Integer.max(max_size.get(), M[m][n]));
            return M[m][n];
        }

        // find largest square matrix ending at M[m][n-1]
        int left = findLargestSquare(M, m, n - 1, max_size);

        // find largest square matrix ending at M[m-1][n]
        int top = findLargestSquare(M, m - 1, n, max_size);

        // find largest square matrix ending at M[m-1][n-1]
        int diagonal = findLargestSquare(M, m - 1, n - 1, max_size);

        // largest square matrix ending at M[m][n] will be 1 plus
        // minimum of largest square matrix ending at M[m][n-1],
        // M[m-1][n] and M[m-1][n-1]

        int size = 0;
        if (M[m][n] != 0) {
            size = 1 + Integer.min(Integer.min(top, left), diagonal);
        }

        // update maximum size found so far
        max_size.set(Integer.max(max_size.get(), size));

        // return the size of largest square matrix ending at M[m][n]
        return size;
    }
}
