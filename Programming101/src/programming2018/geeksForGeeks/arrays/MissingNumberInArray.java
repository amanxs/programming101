package programming2018.geeksForGeeks.arrays;

public class MissingNumberInArray {
    /**
     * Given an array of size n-1 and given that there are numbers from 1 to n with one missing,
     * the missing number is to be found.
     */

    public static void main(String args[]){

    }

    static int getMissingNumber(int arr[], int n){
            int sum_expected = (n*(n+1))/2;
            int sum =0;
            for(int i=0; i< arr.length; i++){
                sum += arr[i];
            }

            return sum_expected-sum;

    }

    // USING XOR ?
}
