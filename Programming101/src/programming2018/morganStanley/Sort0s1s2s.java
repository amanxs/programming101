package programming2018.morganStanley;

public class Sort0s1s2s {

    public static void main(String args[]){
        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        simpleCountingSort(arr, arr.length);
        dutchNationalFlagSoln(arr,arr.length);
    }

    private static void printArr(int arr[], int n){
        for(int i=0; i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }

    private static void simpleCountingSort(int arr[], int n){
        //int count[] = new int[n];
        int count0 =0,  count1=0, count2=0;

        for(int i=0; i<n;i++){
            switch(arr[i]){
                case 0:
                    count0++;
                    break;
                case 1:
                    count1++;
                    break;
                case 2:
                    count2++;
                    break;
            }
        }

        for(int i=0; i<n; i++){
            if(i<count0)
                arr[i]=0;
            else if(i>=count0 && i<count0+count1)
                arr[i]=1;
            else if(i>=count0+count1 && i<count0+count1+count2)
                arr[i]=2;
        }

        printArr(arr,n);
    }
/*
Problems with above solution.
1) It requires two traversals of array.
2) This solution may not work if values are a part of structure.
For example, consider a situation where 0 represents Computer Science Stream, 1 represents Electronics
and 2 represents Mechanical. We have a list of student objects (or structures) and we want to sort them.
We cannot use above sort as we simply put 0s, 1s and 2s one by one.
 */


//— Dutch National Flag Algorithm, or 3-way Partitioning —

    /**
     * The problem was posed with three colours, here `0′, `1′ and `2′. The array is divided into four sections:
     a[1..Lo-1] zeroes (red)
     a[Lo..Mid-] ones (white)
     a[Mid..Hi] unknown
     a[Hi+1..N] twos (blue)
     */
    private static void dutchNationalFlagSoln(int arr[], int n){
        int lo=0, mid=0, high=n-1;

        while(mid<high){
            switch(arr[mid]){
                case 0:{
                    if(arr[mid]!=arr[lo])// optimization :  check that the values being swapped are same or not, if not same, then only swap values
                        swap(arr,mid,lo);
                    mid++;
                    lo++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2:
                    if(arr[mid]!=arr[high])// optimization :  check that the values being swapped are same or not, if not same, then only swap values
                        swap(arr,mid,high);
                    high--;
                    break;
            }
        }
        printArr(arr,n);

    }

    private static void swap(int arr[], int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
