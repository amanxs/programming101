package programming2020.codility;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
        static int matrix[][] ;

        public static void main(String[] args) {
            int mat[][] = {{2, 7, 5}, {3, 1, 1}, {2, 1, -7}, {0, 2, 1}, {1, 6, 8}};

            System.out.print(solution(mat));
        }

        /**
         * A[0][0] = 2    A[0][1] = 7    A[0][2] =  5
         * A[1][0] = 3    A[1][1] = 1    A[1][2] =  1
         * A[2][0] = 2    A[2][1] = 1    A[2][2] = -7
         * A[3][0] = 0    A[3][1] = 2    A[3][2] =  1
         * A[4][0] = 1    A[4][1] = 6    A[4][2] =  8
         * @param A
         * @return
         */

        public static int solution(int[][] A) {
            List<int[]> l = new ArrayList<>();

            matrix = A;
            int columns = A[0].length;
            int rows = A.length;
            int sumRowsAbove = 0;
            int sumRowsBelow = 0;
            int sumColLeft = 0;
            int sumColRight = 0;

            int equilibrium = 0;

            for( int i = 0; i < rows; i++  ) {
                for (int j = 0; j < columns; j++) {
                    sumRowsBelow = getSumRowsBelow(i);
                    sumRowsAbove = getSumAbove(i);
                    sumColLeft = getSumColumnLeft(j);
                    sumColRight = getSumColumnRight(j);
                    if(sumRowsAbove == sumRowsBelow && sumColLeft == sumColRight) {
                        equilibrium++;
                    }
                    int x = 2;
                    x+=2;
                }
            }
            return equilibrium;
        }

        public static int getSumRowsBelow(int rowNum) {
            int columns = matrix[0].length;
            int rows = matrix.length;
            int sumBelow = 0;
            for( int i = rowNum; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if((i+1) < rows){
                        sumBelow += matrix[i + 1][j];
                    }
                }
            }

            return sumBelow;
        }

        public static int getSumColumnRight(int column) {
            int columns = matrix[0].length;
            int rows = matrix.length;
            int sumBelow = 0;
            for (int j = column; j <= columns; j++) {
                for( int i = 0; i < rows; i++) {
                    if((j+1) < columns){
                        sumBelow += matrix[i][j + 1];
                    }
                }
            }
            return sumBelow;
        }

        public static int getSumColumnLeft(int column) {
            int columns = matrix[0].length;
            int rows = matrix.length;
            int sumBelow = 0;
            for (int j = column; j >= 0; j--) {
                for( int i = 0; i < rows; i++) {
                    if((j-1) >= 0){
                        sumBelow += matrix[i][j - 1];
                    }
                }
            }
            return sumBelow;
        }

        public static int getSumAbove(int rowNum) {
            int columns = matrix[0].length;
            int rows = matrix.length;
            int sumBelow = 0;
            for( int i = rowNum; i >= 0; i--) {
                for (int j = 0; j < columns; j++) {
                    if((i-1) >= 0){
                        sumBelow += matrix[i - 1][j];
                    }
                }
            }

            return sumBelow;
        }
}
