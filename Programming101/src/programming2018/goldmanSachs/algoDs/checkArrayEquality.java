package programming2018.goldmanSachs.algoDs;

import java.util.Scanner;

public class checkArrayEquality {

    public static void main (String[] args) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i = 0; i < T ; i++) {
            int n = in.nextInt();
            int arr1[] = new int[n];
            int arr2[] = new int[n];

            for (int j = 0; j <n ; j++) {
                arr1[j] = in.nextInt();

            }
            for (int j = 0; j <n ; j++) {
                arr2[j] = in.nextInt();

            }

            int b = compare(arr1,arr2);
            System.out.println(b);

        }
    }

    private static int compare(int[] arr1, int[] arr2) {
        //programming2018.Arrays.sort(arr1);
        //programming2018.Arrays.sort(arr2);
        countingSort(arr1);
        countingSort(arr2);
        for (int i = 0; i < arr1.length; i++) {
            if(!(arr1[i] == arr2[i]))
                return 0;
        }
        return 1;
    }

    private static void countingSort(int[] arr){
        int output[] = new int[arr.length];
        int count[] =  new int[1000];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int pointer = 0;

        for (int i = 0; i <count.length ; i++) {
            if(count[i]>0){
                for (int j = 0; j <count[i] ; j++) {
                    output[j+pointer]=i;
                }
                pointer = pointer+count[i];
            }
            if(pointer==arr.length)
                break;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i]=output[i];
        }

    }
}
