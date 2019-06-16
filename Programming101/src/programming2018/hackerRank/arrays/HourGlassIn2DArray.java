package programming2018.hackerRank.arrays;

import java.util.Scanner;

/**
 * We define an hourglass in  to be a subset of values with indices falling in this pattern in 's graphical representation:

 a b c
   d
 e f g

 An hourglass sum is the sum of an hourglass' values.

 Task
 Calculate the hourglass sum for every hourglass in input Array, then print the maximum hourglass sum.


 Sample Input

 1 1 1 0 0 0
 0 1 0 0 0 0
 1 1 1 0 0 0
 0 0 2 4 4 0
 0 0 0 2 0 0
 0 0 1 2 4 0


 There are 16 hourglasses in A and The hourglass with the maximum sum (19) is:

 2 4 4
   2
 1 2 4

 Constraints

 1. -9<= A[i]j[j]=<9
 2. 0<=i,j=<5
 */
public class HourGlassIn2DArray {

    public static void main(){
        int mat[][] = { {1,1,1,0,0,0},
                        {0,1,0,0,0,0},
                        {1,1,1,0,0,0},
                        {0,0,2,4,4,0},
                        {0,0,2,0,0,0},
                        {0,0,1,2,4,0}

        };
        int res = findMaxSum(mat);

    }

    private static int findMaxSum(int mat[][]) {
        int numbers[][] = new int[6][6];
        Scanner scan = new Scanner(System.in);
        numbers = mat;

        for(int i=0 ; i<6; i++){
            for(int j=0;j<6;j++){
                numbers[i][j]=scan.nextInt();
            }
        }

        int hourglass=0;
        for(int i=0 ; i<6; i++){
            for(int j=0;j<6;j++){

            }
        }

        return 0;
    }


    //Solution
/*    public static void main(programming2018.String[] args) {
        // write your code here


        int numbers[][] = new int[6][6];

        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 6; j++){
                numbers[i][j] = in.nextInt();
            }
        }


        int currentHourGlass;
        int largestSum = -999;

        for (int i = 1; i < 5; i++){
            for (int j = 1; j < 5; j++){
                currentHourGlass = 0;
                currentHourGlass += numbers[i-1][j-1];
                currentHourGlass += numbers[i-1][j];
                currentHourGlass += numbers[i-1][j+1];
                currentHourGlass += numbers[i][j];
                currentHourGlass += numbers[i+1][j-1];
                currentHourGlass += numbers[i+1][j];
                currentHourGlass += numbers[i+1][j+1];
                if (currentHourGlass > largestSum){
                    largestSum = currentHourGlass;
                }

            }
        }

        System.out.printf("%d", largestSum);

    }
}*/
}
