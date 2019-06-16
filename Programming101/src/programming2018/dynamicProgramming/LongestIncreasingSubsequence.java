package programming2018.dynamicProgramming;


public class LongestIncreasingSubsequence {

    public static void main(String args[]){
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int n = arr.length;

        int lis = lis(arr);
        System.out.print(lis);

    }

    static int lis(int arr[]){

        int arrLength = arr.length;
        int lis[] = new int[arrLength];
        lis[arrLength-1] =1;
        int max=0;

        for(int i=arrLength-2; i>=0; i--){

            for(int j = i+1; j<arrLength ;j++){

                if(arr[i]<arr[j]){
                    lis[i] = Math.max(lis[i], lis[j]+1);;
                    max = Math.max(max, lis[i]);

                }
            }

        }
        return max;
    }

    static int maxSumlis(int arr[]){

        int arrLength = arr.length;
        int lis[] = new int[arrLength];
        lis[arrLength-1] =1;
        int max=0;

        for(int i=arrLength-2; i>=0; i--){

            for(int j = i+1; j<arrLength ;j++){

                if(arr[i]<arr[j]){
                    lis[i] = Math.max(lis[i], lis[j]+1);;
                    max = Math.max(max, lis[i]);

                }
            }

        }
        return max;
    }

}
