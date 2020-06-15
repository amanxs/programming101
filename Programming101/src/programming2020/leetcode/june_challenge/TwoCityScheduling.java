package programming2020.leetcode.june_challenge;

import java.util.PriorityQueue;

public class TwoCityScheduling {

    public static void main(String[] args) {
        int[][] in = new int[][]{{259, 770}, {926, 667}, {577, 469}, {448, 54}, {184, 139}, {840, 118}};
        int res = twoCitySchedCost(in);
        //Assertions.assertEquals(1859,res);

    }
    public static int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

        for (int cost[] : costs) {
            heap.add(cost);
        }

        int res=0;
        for(int i=0; i< n; i++){
            int temp[] = heap.poll();
            res += i < n / 2 ? temp[0] : temp[1];
        }


        return res;
    }
}
