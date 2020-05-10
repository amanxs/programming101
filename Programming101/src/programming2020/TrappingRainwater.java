package programming2020;

public class TrappingRainwater {

    public static void main(String args[]){
        int arr[] = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int max = getMaxTrappedWater(arr, arr.length);
        System.out.println(max);
    }

    public static int getMaxTrappedWater(int arr[], int n){

        int max =0;
        int left = 0;
        int right = getMax(1, n, arr);

        for(int i=0; i< n ; i++){
             left = getLeftMax(arr, i, left);
             right = getRightMax(arr, i, right);
            int temp= Math.min(left, right);
            max += arr[i]<temp ? temp -arr[i] : 0;
        }
        return max;
    }

    public static int getLeftMax(int arr[], int i, int leftMax){
        if(arr[i]<leftMax) return leftMax;
        else return arr[i];
    }

    public static int getRightMax(int arr[], int i, int rightMax){
        if(arr[i]<rightMax) return rightMax;
        else return getMax(i+1, arr.length, arr);
    }

    public static int getMax(int start, int end, int arr[]){
        int max = 0;
        for (int i = start; i < end; i++) {
            if(arr[i]> max) max = arr[i];
        }

        return max;
    }
}
