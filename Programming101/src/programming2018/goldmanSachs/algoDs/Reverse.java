package programming2018.goldmanSachs.algoDs;

public class Reverse {

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        String s = "aman arora";
        reverse(arr);
        printArr(arr);

    }

    static void printArr(int arr[]){
        for(int i = 0; i<arr.length; i++){
            System.out.print(arr[i]);
        }
    }


    static void reverse(int arr[]){
        int left=0;
        int right = arr.length - 1;
        while(left<right){
            swap(arr,left,right);
            left++;
            right--;
        }
    }



    static void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
