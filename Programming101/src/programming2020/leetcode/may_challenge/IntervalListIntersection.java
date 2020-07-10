package programming2020.leetcode.may_challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 */
public class IntervalListIntersection {
    public static void main(String[] args) {
        int A[][] = {{0,2},{5,10},{13,23},{24,25}}, B[][] = {{1,5},{8,12},{15,24},{25,26}};

    }

    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        int n1 = A.length;
        int n2 = B.length;

        int i=0;
        int j =0;
        List<int[]> list = new ArrayList<>();

        while(i<n1 && j<n2){
            int al = A[i][0];
            int ar = A[i][1];
            int bl = B[j][0];
            int br = B[j][1];
            if(ar<bl) {
                i++;
                continue;
            }

            else if(br<al){
                j++;
                continue;
            }

            int l = Math.max(al, bl);
            int r = Math.min(ar, br);

            int row[] = new int[2];
            row[0]=l;
            row[1]=r;
            list.add(row);
            if(ar>br) j++;
            else i++;
        }
        int res[][] = new int[list.size()][2];

        for(int k=0; k<list.size(); k++){
            res[k] = list.get(k);
        }

        return res;
    }

}
