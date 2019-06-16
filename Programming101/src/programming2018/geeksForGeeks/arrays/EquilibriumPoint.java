package programming2018.geeksForGeeks.arrays;

public class EquilibriumPoint {
    /**
     * Equilibrium index of an array is an index such that the sum of elements at lower indexes is equal
     * to the sum of elements at higher indexes.
     */

    public static void main(String[] args) {
        int arr[] = {-2,3,4,1,6,-1};
        int index = getEquilibriumPoint(arr,arr.length);
        System.out.println(index);
    }


// Maintain leftSum and RightSum for EveryIndex in 2 separate arrays and then use this in the final iteration
    static int getEquilibriumPoint(int arr[], int n){
        int leftSum[] = new int[n];
        int rightSum[] = new int[n];
        leftSum[0] = arr[0];
        rightSum[n-1] = arr[n-1];

        for(int i=1; i<n; i++){
            leftSum[i]= arr[i] + leftSum[i-1];
        }

        for(int i=n-2; i>0; i--){
            rightSum[i] = arr[i]+rightSum[i+1];
        }

        for (int i = 1; i < n ; i++) {
            if(leftSum[i-1]==rightSum[i+1])
                return i;
        }

        return -1;
    }
// Time complexity of this solution is O(n) and takes extra space.

}
