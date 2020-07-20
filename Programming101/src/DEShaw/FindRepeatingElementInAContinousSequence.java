package DEShaw;

public class FindRepeatingElementInAContinousSequence {
    public static void main(String[] args) {
        int arr [] = {51, 52, 53, 54, 55, 56, 56, 57, 58};
        int res = findRepeating(arr);
        System.out.println(res);
    }

    /*

    51, 52, 53, 54, 55, 56, 56, 57, 58
    int index = arr[i] - start;
    true true true true true true false false false
     */

    public static int findRepeating(int arr[]){
        int len = arr.length;
        int start = arr[0];
        int end = arr[len-1];

        int ans = -1;

        int l = 0;
        int r = len -1;

        while(l<=r){
            int m = l + (r-l)/2;
            int index = arr[m] - start;
            if(index != m){
                ans = arr[m];
                r = m-1;
            }
            else {
                l = m+1;
            }
        }

        return ans;



    }


}
