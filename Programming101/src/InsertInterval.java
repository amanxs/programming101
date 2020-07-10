import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {

            if (intervals.length < 1) return new int[][]{newInterval};
            List<int[]> result = new ArrayList<>();
            int index = 0;

            while(index < intervals.length && newInterval[0] > intervals[index][1]) {
                result.add(intervals[index++]);
            }
            result.add(newInterval);
            while (index < intervals.length) {
                if (intervals[index][0] <= newInterval[1]) {
                    newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
                    newInterval[0] = Math.min(newInterval[0], intervals[index++][0]);
                } else {
                    newInterval = intervals[index];
                    result.add(newInterval);
                    index++;
                }
            }

            return result.toArray(new int[result.size()][]);
        }
    }
}
