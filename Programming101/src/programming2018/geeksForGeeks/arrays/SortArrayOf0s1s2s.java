package programming2018.geeksForGeeks.arrays;

public class SortArrayOf0s1s2s {
    // Dutch national Flag algorithm


    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        sort012(arr, arr.length);

    }

    static void sort012(int arr[], int n){
        int p1=0;
        int p2 =0;
        int p3 = n-1;
        while(p2<=p3){
            switch (arr[p2]){
                case 0:
                    swap(arr,p2,p1);
                    p1++;
                    p2++;
                    break;
                case 1:
                    p2++;
                    break;
                case 2:
                    swap(arr,p3,p2);
                    p3--;
                    break;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


    static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
