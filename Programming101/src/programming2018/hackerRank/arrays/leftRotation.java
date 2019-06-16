package programming2018.hackerRank.arrays;

import java.util.Scanner;

public class leftRotation {

/*
    A left rotation operation on an array of size n shifts each of the array's elements 1 unit to the left.
    For example, if left rotations are performed on array [1,2,3,4,5], then the array would become [3,4,5,1,2] .
    Given an array of n integers and a number, d, perform d left rotations on the array.
    Then print the updated array as a single line of space-separated integers.
*/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = in.nextInt();
        }
        int[] result = leftRotation(a, d);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");

        in.close();
    }

    static int[] leftRotation(int[] a, int d) {

        int initialElements[] = new int[d];

        for (int i = 0; i <d ; i++) {
            initialElements[i] = a[i];
        }

        for (int i = 0; i <a.length-d ; i++) {
            a[i] = a[i+d];
        }

        for (int i = a.length-d, k=0 ; i <a.length ; i++, k++) {
            a[i] = initialElements[k];
        }
        return a;
    }
}
