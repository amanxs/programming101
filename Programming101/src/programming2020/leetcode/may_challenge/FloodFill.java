package programming2020.leetcode.may_challenge;

import java.util.ArrayDeque;
import java.util.Queue;

public class FloodFill {
    private static final int row[] = {-1,-1-1,0,0,1,1,1};
    private static final int col[] = {-1,0,1,-1,1,-1,0,1};

    class Pair{
        int x, y;
        public Pair(int x, int y){
            this.x= x;
            this.y = y;
        }
    }


    public int[][] floodFillBfs(int[][] image, int x, int y, int newColor) {
        int m = image.length;
        int n = image[0].length;

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(x, y));
        int source = image[x][y];

        while(!q.isEmpty()){
            Pair node = q.poll();
            x = node.x;
            y = node.y;

            image[x][y] = newColor;
            for(int i=0; i<row.length; i++){
                if(isSafe(image,x + row[i], y + col[i], source)){
                    q.add(new Pair(x+row[i], y+col[i]));
                }
            }
        }
        return image;
    }



    public int[][] floodFill(int[][] image, int x, int y, int newColor) {
        //if (image[x][y] == newColor) return image;

        int source = image[x][y];
        image[x][y] = newColor;
        for(int i=0; i<row.length; i++){
            if(isSafe(image,x + row[i], y + col[i], source)){
                floodFill(image,x + row[i], y + col[i], newColor);
            }
        }

        return image;
    }

    public boolean isSafe(int image[][], int x, int y, int source){
        return x>=0 && x<image.length && y>=0 && y<image[0].length && image[x][y]==source;
    }


    /* SOLUTION

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        floodFill(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private void floodFill(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if (sr >= image.length || sr < 0 || sc < 0 || sc >= image[0].length ) {
            return;
        }
        if (image[sr][sc] == newColor || oldColor != image[sr][sc]) {
            return;
        }
        image[sr][sc] = newColor;
        floodFill(image, sr, sc - 1, newColor, oldColor); //left
        floodFill(image, sr, sc + 1, newColor, oldColor); //right
        floodFill(image, sr - 1, sc, newColor, oldColor); //top
        floodFill(image, sr + 1, sc, newColor, oldColor); //bottom
    }
     */
}
