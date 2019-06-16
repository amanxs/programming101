package programming2018.goldmanSachs.algoDs;

public class minInSortedAndRotated {

    /**
     * How to handle duplicates?
     It turned out that duplicates can’t be handled in O(Logn) time in all cases.
     The special cases that cause problems are like {2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 2} and {2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2}.
     It doesn’t look possible to go to left half or right half by doing constant number of comparisons at the middle.
     So the problem with repetition can be solved in O(n) worst case.
     * @param args
     */

    public static void main(String args[]){
        int min = findMinGeeksForGeeks(new int[]{7,8,9,1,2,3,4,5,6}, 0, 8);
        System.out.print("result :"+ min);

    }

    //Input: {5, 6, 1, 2, 3, 4}

    private static int findMinGeeksForGeeks(int arr[], int l, int r){

        if(arr[0]<arr[arr.length-1])
            return arr[0];

        int m = l + (r-l)/2;

        if(arr[m]<arr[m-1])
            return arr[m];

        if(arr[m]>arr[m+1])
            return arr[m+1];

        if(arr[m]< arr[r])
            return findMinGeeksForGeeks(arr, l, m-1);

        return findMinGeeksForGeeks(arr, m+1,r);

    }

    static int findMin(int arr[], int low, int high)
    {
        // This condition is needed to handle the case when array
        // is not rotated at all
        if (high < low)  return arr[0];

        // If there is only one element left
        if (high == low) return arr[low];

        // Find mid
        int mid = low + (high - low)/2; /*(low + high)/2;*/

        // Check if element (mid+1) is minimum element. Consider
        // the cases like {3, 4, 5, 1, 2}
        if (mid < high && arr[mid+1] < arr[mid])
            return arr[mid+1];

        // Check if mid itself is minimum element
        if (mid > low && arr[mid] < arr[mid - 1])
            return arr[mid];

        // Decide whether we need to go to left half or right half
        if (arr[high] > arr[mid])
            return findMin(arr, low, mid-1);
        return findMin(arr, mid+1, high);
    }
}

