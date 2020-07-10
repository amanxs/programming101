package programming2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {

        int arr[][] = new int[][]{{2,6} , {1, 7}};
        merge(arr);

    }
        public static int[][] merge(int[][] intervals) {
                Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
                int end = intervals[0][0];
                //int arr [][] = new int[intervals.length][2];
                List<int[]> list = new ArrayList<int[]>();
                int j=1;
                list.add(intervals[0]);

                for(int i=1; i< intervals.length; i++){
                    int arr[] = list.get(j-1);
                    if(intervals[i][0]< intervals[j-1][1]){
                        arr[1] = Math.max(intervals[i][1],intervals[j-1][1]);
                    }
                    else{
                        list.add(intervals[i]);
                        j++;
                    }

                }
                int res[][] = new int[list.size()][2];
                for(int i=0; i< list.size() ; i++){
                    res[i] = list.get(i);
                }

                return res;
            }

}
