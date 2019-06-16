package programming2018.geeksForGeeks.arrays;

public class TrappingRainWater {

    /**
     * Given n non-negative integers in array representing an elevation map where the width of each bar is 1,
     * compute how much water it is able to trap after raining.
     */

    /*

    Input: arr[]   = {3, 0, 0, 2, 0, 4}
    Output: 10
    Structure is like below
         |
    |    |
    |  | |
    |__|_|
    We can trap "3*2 units" of water between 3 an 2,
    "1 unit" on top of bar 2 and "3 units" between 2
    and 4.
     */
    public static void main(String[] args) {
        int arr[]   = {3, 0, 0, 2, 0, 4};
        int result = getTrappedWaterOptimized(arr,arr.length);
        System.out.println(result);
    }

    static int getTrappedWater(int arr[], int n){
        int trapperWater =0;
        for(int i=1; i<n-1; i++){
           int leftMax= getMax(arr,0,i);
           int rightMax = getMax(arr,i+1,n);
            trapperWater+= (Math.min(leftMax,rightMax) - arr[i]);
        }
        return trapperWater;
    }

    static int getMax(int arr[], int start, int end){
        int max=0;
        for(int i=start;i<end;i++){
            max= Math.max(max, arr[i]);
        }
        return max;
    }

    static int getTrappedWaterOptimized(int arr[], int n){
        int left[] = new int[n];
        int right[] =  new int[n];
        left[0] =arr[0];
        right[n-1] =arr[n-1];
        for(int i=1; i< n; i++){
            left[i] = Math.max(left[i-1], arr[i]);
        }

        for(int i=n-2; i>0; i--){
            right[i] = Math.max(right[i+1], arr[i]);
        }

        int trapperWater =0;
        for(int i=1; i<n-1; i++){
            trapperWater+= (Math.min(left[i-1],right[i+1]) - arr[i]);
        }
        return trapperWater;
    }

    // can have a Space Optimized approach as well
}
