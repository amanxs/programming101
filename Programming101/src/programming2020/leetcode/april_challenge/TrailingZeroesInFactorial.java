package programming2020.leetcode.april_challenge;

/**
 * Given an integer n, write a function that returns count of trailing zeroes in n!.
 */
public class TrailingZeroesInFactorial {

    /**
     * Input: n = 5
     Output: 1
     Factorial of 5 is 120 which has one trailing 0.

     Input: n = 20
     Output: 4
     Factorial of 20 is 2432902008176640000 which has
     4 trailing zeroes.
     */

    public static void main(String[] args) {
        int n = 100;
        int count = getTrailingZeroes(n);
        System.out.print(count);
    };

    public static int getTrailingZeroesRecursive(int n){
        if(n<5)
            return 0;
        else
            return n/5 + getTrailingZeroesRecursive(n/5);
    }

    public static int getTrailingZeroes(int n){
        int count =0;
        for(int i=n; i >5 ; i= i/5){
            count += i/5;
        }
        return count;
    }
}
