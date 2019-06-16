package programming2018.crackingTheCodingInterview.arrays;

/*
Given an image represented by an NxN matrix, where each pixel in the image is 4bytes,
write a method to rotate the image by 90 degrees. Can you do this in place?
*/


/**
 * Input:
 1  2  3  4
 5  6  7  8
 9 10 11 12
 13 14 15 16

 Output:
 4  8 12 16
 3  7 11 15
 2  6 10 14
 1  5  9 13

 this is anticlockwise rotation
 */

public class ImageRotation {

    public static void main(String args[]){
        int arr[][] = {{1,2,3},{1,3,4}};
        rotateCrackingTheCodingInterview(arr, arr.length);
    }

    /**
     * Because we're rotating the matrix by 90 degrees, the easiest way to do this is to implement the rotation in layers.
     * We perform a circular rotation on each layer, moving the top edge to the right edge, the right edge to the bottom edge,
     * the bottom edge to the left edge, and the left edge to the top edge.
     * @param matrix
     * @param n
     */

    static void rotateCrackingTheCodingInterview(int matrix[][], int n){

        for(int layer =0; layer<n/2; layer++){
            int first = layer;
            int last = n-1-layer;

            for(int i= first; i<last; ++i){
                int offset = i-first;
                int top = matrix[first][i];
                int left = matrix[last-offset][first];
                int bottom = matrix[last][last-offset];
                int right = matrix[i][last];

                //top
                matrix[first][i]= left;
                left = bottom;
                bottom = right;
                right=top;

            }
        }
    }
//This algorithm is 0(N2), which is the best we can do since any algorithm must touch all N^2 elements.


    static void rotateClockwise(int a[][], int n){
        for(int i = 0; i< n/2;i++){
            for(int j=0; j< n/2; j++){
                int top = a[i][j];
                int left = a[n-1-j][i];
                int right = a[j][n-1-j];
                int bottom = a[n-1-i][n-1-j];

                int temp = top;
                top = left;
                left = bottom;
                bottom = right;
                right = temp;

            }
        }
    }

    static void rotateAnticlockwise(int a[][], int n){
        for(int i = 0; i< n/2;i++){
            for(int j=0; j< n/2; j++){
                int top = a[i][j];
                int right = a[j][n-1-j];
                int bottom = a[n-1-i][n-1-j];
                int left = a[n-1-j][i];

                int temp = top;
                top = right;
                right = bottom;
                bottom = left;
                left = temp;

            }
        }
    }



}
