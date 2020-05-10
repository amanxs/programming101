package coding2020.paytm;

public class RotateMatrixBy90 {

    public static void main(String[] args) {
        int N = 4;

        // Test Case 1
        int mat[][] = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        // Tese Case 2
        /* int mat[][] = {
                            {1, 2, 3},
                            {4, 5, 6},
                            {7, 8, 9}
                        };
         */

        // Tese Case 3
        /*int mat[][] = {
                        {1, 2},
                        {4, 5}
                    };*/

        //displayMatrix(mat);

        rotateMatrix(N, mat);

        // Print rotated matrix
        displayMatrix(N, mat);
    }

    private static void displayMatrix(int N, int[][] mat) {

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++)
                    System.out.print(" " + mat[i][j]);

                System.out.print("\n");
            }
            System.out.print("\n");

        }

    private static void rotateMatrix(int N, int [][] mat){

        for(int r =0 ; r<N/2 ; r++){
            for(int c =r; c< N - r -1  ; c++){
                int temp = mat[r][c];
                mat[r][c] = mat[N-1-c][r];
                mat[N-1-c][r] = mat[N-1-r][N-1-c];
                mat[N-1-r][N-1-c]  = mat[c][N-1-r];
                mat[c][N-1-r] = temp;
            }
        }
    }

}
