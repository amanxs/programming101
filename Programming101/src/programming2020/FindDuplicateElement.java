package programming2020;

/**
 * Find duplicate without using extra space. The elements are in the range 1..n-1
 */
public class FindDuplicateElement {

    public static void main(String args[]){
        int arr[] = new int []{1, 4, 5, 7, 3, 1, 6, 2};
        int dup = getDuplicate(new int[]{5, 2, 3, 5, 1, 4});
        System.out.println(dup);
        getDuplicates(new int[]{1, 2, 3, 1, 3, 6, 6});
    }

    // When there is a single duplicate element in the array
    private static int getDuplicate(int[] arr) {
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int n = arr.length-1;
        int exp_sum = Math.abs(n*(n+1))/2;
        int duplicate = sum-exp_sum;
        return duplicate;
    }

    //When multiple duplicate elements are there in the array
    //For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, the answer should be 1, 3 and 6.
    private static void getDuplicates(int arr[]){
        for(int i=0; i<arr.length; i++){
            int element = Math.abs(arr[i]);
            if(arr[element]<0){
                System.out.println(element);
            }
            else {
                arr[element] = - arr[element];
            }
        }
    }


}
