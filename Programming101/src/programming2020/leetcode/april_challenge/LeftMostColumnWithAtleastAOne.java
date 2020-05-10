package programming2020.leetcode.april_challenge;

/*
Question: In a binary matrix (all elements are 0 and 1), every row is sorted in ascending order (0 to the left of 1).
Find the leftmost column index with a 1 in it.
 */

/**
 * Example 1:

 Input:
 [[0, 0, 0, 1],
 [0, 0, 1, 1],
 [0, 1, 1, 1],
 [0, 0, 0, 0]]
 Output: 1
 Example 2:

 Input:
 [[0, 0, 0, 0],
 [0, 0, 0, 0],
 [0, 0, 0, 0],
 [0, 0, 0, 0]]
 Output: -1
 */
public class LeftMostColumnWithAtleastAOne {

    public static void main(String[] args) {
        int arr[][] = {{0,0,0,0},{0,0,0,0},{0,0,0,1}};
        int left = leftMostColumn(arr);
        System.out.println(left);

    }
    public static int leftMostColumn(int arr[][]){
        int rows = arr.length;
        int columns = arr[0].length;
        int result = columns;
        int min = columns-1;
        for(int r=0; r< rows; r++){
           int row [] = arr[r];
           int currMin = getMin(row, min);
           if(currMin == -1) continue;
           min = Math.min(min, currMin);
           result = min;
        }
        return result==columns?-1 : result;
    }

    public static int getMin(int arr[], int n){
        int l=0;
        int r=n;
        while(l<r){
            int m = l + (r-l)/2;
            if(arr[m] == 1 && arr[m-1] ==0){
                return m;
            }
            if(arr[m] == 0){
                l = m+1;
            }
            else{
                r = m-1;
            }
        }
        return -1;
    }

    /*
    class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension=binaryMatrix.dimensions();
        int n=dimension.get(0);
        int m=dimension.get(1);

        int i=0,j=m-1,leftMostOne=-1;

        while(i<n && j>=0)
        {
            int result=binaryMatrix.get(i,j);
            if(result==0)
              i++;
            else{
                leftMostOne=j;
                j--;
             }
        }
        return leftMostOne;
    }
}
     */

}
