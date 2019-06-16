package programming2019.geeksForGeeks.mustDoCodingQuestions.arrays;

public class RotateMatrixBy90Degrees {
    public static void main (String[] args)
    {
        int arr[][] = { { 1, 2, 3, 4 },
                        { 5, 6, 7, 8 },
                        { 9, 10, 11, 12 },
                        { 13, 14, 15, 16 } };
        rotate90Clockwise(arr);
        printMatrix(arr);
    }

    // Function for print matrix
    static void printMatrix(int arr[][])
    {
        int N = arr[0].length;

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print( arr[i][j] + " ");
            System.out.println();
        }
    }

    private static void rotate90Clockwise(int[][] arr) {

        int n = arr[0].length;
        for (int i = 0; i < n/2; i++) {
            for(int j = i; j < n -i -1; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[n-j-1][i];
                arr[n-j-1][i] = arr[n-i-1][n-j-1];
                arr[n-i-1][n-j-1] = arr[j][n-i-1];
                arr[j][n-i-1] = temp;
            }
        }
    }

}
