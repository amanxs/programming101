package programming2020.leetcode.Contest;

/**
 * Given the number k, return the minimum number of Fibonacci numbers whose sum is equal to k, whether a Fibonacci number could be used multiple times.

 The Fibonacci numbers are defined as:

 F1 = 1
 F2 = 1
 Fn = Fn-1 + Fn-2 , for n > 2.
 It is guaranteed that for the given constraints we can always find such fibonacci numbers that sum k.


 Example 1:

 Input: k = 7
 Output: 2
 Explanation: The Fibonacci numbers are: 1, 1, 2, 3, 5, 8, 13, ...
 For k = 7 we can use 2 + 5 = 7.
 Example 2:

 Input: k = 10
 Output: 2
 Explanation: For k = 10 we can use 2 + 8 = 10.
 Example 3:

 Input: k = 19
 Output: 3
 Explanation: For k = 19 we can use 1 + 5 + 13 = 19.
 */
public class MinNumberOfFibNumbersWithSumK {
    public static void main(String[] args) {
        int n = findMinFibonacciNumbers(17);
        System.out.println(n);
    }

    public static  int findMinFibonacciNumbers(int k) {
        int fib[] = new int[k];
        fib[0] = 1;
        fib[1] =1;
        int i=2;
        while(true){
            fib[i] = fib[i-1] + fib[i-2];
            if(fib[i]>k) break;
            i++;
        }


        int count =0;
        i--;

        while(k>0){
            count += k/fib[i];
            k %= fib[i];
            i--;
        }

        return count;

    }

    public static int getMinCount(int fib[], int n, int k) {//7 19
        if(k<0){
            return 0;
        }
        if(k==0){
            return 1;
        }
        if(n<0 && k>=1){
            return 0;
        }
        return getMinCount(fib, n, k-fib[n] ) + getMinCount(fib, n-1, k );
    }
}
