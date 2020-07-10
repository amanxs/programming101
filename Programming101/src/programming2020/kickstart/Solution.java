package programming2020.kickstart;

import java.util.Scanner;

/**
 * 3
 * 12 3
 * 1 2 3 7 9 3 2 1 8 3 2 1
 * 4 2
 * 101 100 99 98
 * 9 6
 * 100 7 6 5 4 3 2 1 100
 *
 */
class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <=T; t++) {
            System.out.println(t);
            int n = in.nextInt();
            int k = in.nextInt();

            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(t);
            int y = countDowns(arr, n, k);
            System.out.println("#" + t + ": " + y);
        }
    }

    public static int countDowns(int arr[], int n, int k) {
        System.out.println("Inside");
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == k) {
                int j = 1;
                while (j < k) {
                    if (arr[i + j] != k - j) break;
                    else j++;
                }
                if (k == j) {
                    count++;
                    i = i + k - 1;
                }
            }
        }
        return count;

    }
}