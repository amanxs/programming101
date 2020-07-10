import java.util.Arrays;

public class KclosesPoints {

    public int[][] kClosest(int[][] points, int K) {

        int l = 0;
        int h = points.length-1;
        int[][] r = null;

        if (K >= points.length) {
            return Arrays.copyOfRange(points, 0, points.length);
        }

        while (l <= h) {
            int p = quickSelect(points, l, h);
            if (p == K) {
                r = Arrays.copyOfRange(points, 0, p);
                break;
            } else if (p > K) {
                h = p-1;
            } else {
                l = p+1;
            }
        }

        return r;
    }

    private int quickSelect(int[][] points, int start, int end) {

        int[] pivot = points[end];
        int pivotIndex = start;

        for (int i=start;i<=end-1;i++) {
            if (dist(points[i]) <= dist(points[end])) {
                swap(points, i, pivotIndex);
                pivotIndex++;
            }
        }

        swap(points, pivotIndex, end);
        return pivotIndex;
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];

        points[i] = points[j];
        points[j] = temp;
    }

    private int dist(int[] p) {
        return p[0]*p[0] + p[1]*p[1];
    }
}
