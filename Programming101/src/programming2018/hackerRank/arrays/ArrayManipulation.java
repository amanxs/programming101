package programming2018.hackerRank.arrays;

import java.util.Scanner;

/*
You are given a list(1-indexed) of size n, initialized with zeroes.
You have to perform m operations on the list and output the maximum of final values of all the n elements in the list.
For every operation, you are given three integers a,b and k and you have to add value k to all the elements
ranging from index a to b (both inclusive).

Input Format

The first line will contain two integers n and m separated by a single space.
Next m lines will contain three integers a, b  and k separated by a single space.
Numbers in list are numbered from 1 to n .

Print in a single line the maximum value in the updated list.


 */
public class ArrayManipulation {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long arr[] =  new long[n];

        for(int i=0;i<n;i++) arr[i]=0;

        for(int i = 0; i < m; i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int k = in.nextInt();
            for (int j = a-1; j <b ; j++) {
                arr[j] += k;
            }

        }
        in.close();

        //Find max value

        long max = 0;
        for (int i = 0; i <n; i++) {
            if(arr[i]>max) max = arr[i];
        }

        System.out.print(max);
    }


    //Solution

    /**
     * For each of the "m" operations, we do not want to take O(n) time to process it.
     * That's because our runtime will end up being O(nm). To get a O(n+m) runtime, we have to process each operation in O(1) time.
     * To do so, we keep track of just the endpoints, which are just 2 numbers, instead of the O(n) numbers in between the endpoints.
     * This is the main idea to decrease our runtime.
     * For a value "k", we can mark its left endpoint "a" in the original array, along with its right endpoint "b" in the original array.
     * To distinguish between "a" and "b" we can store "+k" for "a" and "-k" for "b".
     * Now, we technically have stored all information that the "m" operations represent, into an array. Most importantly, we stored it in O(m) time.
     * The next step is to actually find the maximum value based off of our unique representation of the data.
     * We traverse our array from left to right.
     * Whenever we reach a left endpoint "a" (which we represented with a positive number), we just add that to our sum.
     * Whenever we reach a right endpoint "b" (which we represented with a negative number), we subtract that from our sum
     * (well, technically we add a negative value).
     * By doing so, the value "sum" represents the value that array[i] would have if we had applied all "m" operations to it.
     * The maximum value of "sum" that we get while traversing the array is the value we return.
     * If this algorithm is still unclear to you, try walking through HackerRank's sample input (Testcase 0) with the code below.

       Time Complexity: O(n + m)
       Space Complexity: O(n)
     */

/*    public static void main(programming2018.String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();

        *//* Save interval endpoints' "k" values in array *//*
        long [] array = new long[N + 1];
        while (M-- > 0) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            int k = scan.nextInt();
            array[a-1] += k;
            array[b]   -= k; // see comment at end of code
        }
        scan.close();

        *//* Find max value *//*
        long sum = 0;
        long max = 0;
        for (int i = 0; i < N; i++) {
            sum += array[i];
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}*/
}
