package programming2018.Arrays;

public class SpiralTraversalOfMatrix {

    public static void main(String args[])    {
        int R = 3;
        int C = 6;
        int a[][] = { {1,  2,  3,  4,  5,  6},
                      {7,  8,  9,  10, 11, 12},
                      {13, 14, 15, 16, 17, 18}
        };

        // Test Case 1
        int mat[][] =
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                };

        //spiralTraversalSquare(mat.length, mat);
        spiralPrint(a.length,a[0].length,a);
        //spiralPrint(mat.length,mat[0].length, mat);

    }

    static void spiralPrint(int r, int c, int a[][]) {

        for(int i= 0; i<=r/2; i++){
            System.out.println(" Inside loop");

            for(int j=i; j< c-i-1; j++){
                System.out.print(a[i][j]+ " ");
            }

            for(int j=i; j< r-i-1 || j==r/2 ; j++){
                System.out.print(a[j][c-1-i]+ " ");
            }

            for(int j=c-1-i; j>i && i<r/2; j--){
                System.out.print(a[r-1-i][j]+ " ");
            }

            for(int j=r-1-i; j>i; j--){
                System.out.print(a[j][i]+ " ");
            }
        }

    }

    static void spiralTraversalSquare(int n, int a[][]) {

        int r_i = 0;
        int c_i = 0;

        for(int i = 0; i<n/2; i++){

            for(int j = i; j< n-i-1; j++ ){

                //System.out.println("Loop 1 with:"+i +"," +j+ " ");

                System.out.print(a[i][j]+ " ");
            }

            for(int j = i; j< n-i-1; j++ ){
                //System.out.println("Loop 2 with:"+i +"," +j);
                System.out.print(a[j][n-1-i]+ " ");
            }

            for (int j= n-1-i; j>i; j--){
                //System.out.println("Loop 3 with:"+i +"," +j);

                System.out.print(a[n-1-i][j]+ " ");
            }

            for (int j= n-1-i; j>i; j--){
                //System.out.println("Loop 4 with:"+i +"," +j);

                System.out.print(a[j][i]+ " ");
            }
        }
    }
}
