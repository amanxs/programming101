package programming2020;

/**
 * How to handle duplicates?
 It turned out that duplicates can’t be handled in O(Logn) time in all cases.
 The special cases that cause problems are like {2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 2} and {2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2}.
 It doesn’t look possible to go to left half or right half by doing constant number of comparisons at the middle.
 So the problem with repetition can be solved in O(n) worst case.
 */
public class MinElementInSortedRotatedArray {

    public static void main(String args[]){
        int arr[] = {9,1,2,3,4,5,6};
        int min = getMin(arr);
        System.out.println(min);
    }

    public static int getMin(int arr[]){
        return getMinUtil(arr, 0, arr.length-1);
    }

    public static int getMinUtil(int arr[], int l, int r){
        if(l>r){
            return -1;
        }

        int m = l + (r-l)/2;

        if(arr[m]<=arr[m-1]){
            return m;
        }
        else if(arr[m+1]<= arr[m]){
            return m+1;
        }

        if(arr[m]>=arr[l]){
            return getMinUtil(arr, m+1, r);
        }
        else {
            return getMinUtil(arr, l, m-1);

        }
    }
}
