package programming2020;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.

 Your algorithm's runtime complexity must be in the order of O(log n).

 Example 1:

 Input: nums = [4,5,6,7,0,1,2], target = 0
 Output: 4
 Example 2:

 Input: nums = [4,5,6,7,0,1,2], target = 3
 Output: -1

 [4,5,6,7,8,1,2,3]
 8
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        int arr[] = {4,5,6,7,0,1,2};
        int i = s.search(arr, 8);
        System.out.println(i);
    }

    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }

    public int pivot(int arr[], int l, int r){
        if(l>r){
            return -1;
        }

        int m = l + (r-l)/2;

        if(arr[m]<=arr[m-1]){
            return m-1;
        }
        else if(arr[m+1]<= arr[m]){
            return m;
        }

        if(arr[m]>=arr[l]){
            return pivot(arr, m+1, r);
        }
        else {
            return pivot(arr, l, m-1);

        }
    }

    public int binarySearch(int[] nums, int target, int l, int r){
        if(l>r){
            return -1;
        }

        int m = l + (r-l)/2;

        if(nums[m]==target){
            return m;
        }

        if(nums[m]>nums[l]){
            if(nums[m] > target && nums[l]<target){
                return binarySearch(nums, target, l, m-1);

            }
            return binarySearch(nums, target, m+1, r);
        }

            if(nums[m]<=target && nums[r] >= target ){
                return binarySearch(nums, target, m+1, r);

            }
            return binarySearch(nums, target, l, m-1);
        }


}
