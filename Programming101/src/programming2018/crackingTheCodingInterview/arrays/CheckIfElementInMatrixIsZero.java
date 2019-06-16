package programming2018.crackingTheCodingInterview.arrays;

public class CheckIfElementInMatrixIsZero {
    /*
    * We use two arrays to keep track of all the rows with zeros and all the columns with zeros.
    * We then make a second pass of the matrix and set a cell to zero if its row or column is zero.
     */

    static void getZeroes(int matrix[][]){
        boolean row [] = new boolean[matrix.length];
        boolean column [] = new boolean[matrix[0].length];

        //Store the row and column index with value zero
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length ; j++) {
                if(matrix[i][j]==0){
                    row[i]=true;
                    column[j]=true;
                }

            }
        }

        //Set the a[i][j] to 0 if either row i or column j has a 0
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length ; j++) {
                if (row[i] || column[j])
                    matrix[i][j] = 0;
            }
        }
    }

    //To make this somewhat more space efficient, we could use a bit vector instead of a boolean array.
}

