package programming2018.goldmanSachs.algoDs;

import java.util.Scanner;

public class DecodingMessage {
    /**
     *  An empty digit sequence is considered to have one decoding.
     *  It may be assumed that the input contains valid digits from 0 to 9 and If there are leading 0’s,
     *  extra trailing 0’s and two or more consecutive 0’s then it is an invalid string.
     * @param args
     */
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int i=0; i<T;i++){
            int N = in.nextInt();
            int ways = countDecoding(in.next().toCharArray(),N);
        }
    }

    static void countWays(char arr[]){
        checkIfInvalid(arr);

    }

    static boolean checkIfInvalid(char ar[]){
        return false;
    }

    /**
     * This problem is recursive and can be broken in sub-problems. We start from end of the given digit sequence.
     * We initialize the total count of decodings as 0. We recur for two subproblems.
     1) If the last digit is non-zero, recur for remaining (n-1) digits and add the result to total count.
     2) If the last two digits form a valid character (or smaller than 27), recur for remaining (n-2) digits and add the result to total count.
     * @param arr
     * @param n
     * @return
     */

    private static int countDecoding(char arr[], int n){

        int count[] = new int[arr.length+1];
        count[0] = 1;
        count[1] = 1;
/*        //base case
        if(n==1||n==0)
            return 1; 675356291270936062618792*/
        for (int i = 2; i <=n ; i++) {
            if(arr[i-1]>'0')
                count[i] = count[i-1];
            if(arr[i-2]<='1'|| (arr[i-2]=='2'&&arr[i-1]<'7')){
                count[i]+=count[i-2];
            }
        }

        return count[n];

    }

}
