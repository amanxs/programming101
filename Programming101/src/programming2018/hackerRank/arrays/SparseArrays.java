package programming2018.hackerRank.arrays;

import java.util.Scanner;

/*
There are N strings. Each string’s length is no more than 20 characters.
There are also Q queries. For each query, you are given a string, and you need to find out how many times this string occurred previously.

Input Format

The first line contains N, the number of strings.
The next N lines each contain a string.
The N+2nd line contains Q, the number of queries.
The following Q lines each contain a query string.
 */
public class SparseArrays {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        String arr[] = new String[length];
        for (int i = 0; i < length ; i++) {
            in.nextLine();
            arr[i] = in.next();
        }
        int count= 0;
        //in.nextLine(); Y is this not required
        int queries = in.nextInt();
        String queriesArr[] = new String[queries];
        for (int i = 0; i < queries ; i++) {
            in.nextLine();
            queriesArr[i] = in.next();
            for (String s: arr) {
                if(s.equals(queriesArr[i])) count++;
            }
            System.out.println(count);
            count=0;
        }

    }
}
