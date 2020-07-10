import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ShortestBridge {

    public int shortestBridge(int[][] grid) {
        /**
         1. find First island(1) and makes all land ( 1's ) to -1. And captuire all zeros into Queue.
         2. do bfs using the queue and find the minumum path to next Island(1).
         **/
        Set<Pair<Integer,Integer>> visited = new HashSet<>();
        Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
        boolean found =false;
        for(int row =0 ; row<grid.length ; row++ ){
            for( int col=0; col<grid[row].length; col++){
                if(grid[row][col] == 1 ){
                    // find First island(1) and makes all land ( 1's ) to -1. And captuire all zeros into Queue.
                    dfs(queue, grid, new Pair(row,col),visited);
                    found =true;
                    break;
                }
            }
            if( found ) break;
        }
        visited.clear();
        // Do bfs using the queue and find the minumum path to next Island(1).
        return bfs (grid,visited,queue);
    }

    /**
     Using the queue populated by DFS method . Find the first 1.
     **/
    private int bfs (int[][] grid,Set<Pair<Integer,Integer>> visited,Queue<Pair<Integer,Integer>> queue){
        int level=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i< size; i++){
                Pair<Integer,Integer> node = queue.poll();
                int row = node.getKey();
                int col = node.getValue();
                // boundary check
                if(row < 0 || row >= grid.length || col< 0 || col >= grid[row].length || grid[row][col] ==-1  ) continue;
                if(!visited.contains(node)){
                    visited.add(node);
                    if(grid[row][col]==1) return level;
                    //UP
                    queue.offer(new Pair(row-1,col));
                    //down
                    queue.offer(new Pair(row+1,col));
                    //left
                    queue.offer(new Pair(row,col-1));
                    //right
                    queue.offer(new Pair(row,col+1));
                }
            }
            level++;
        }
        return level;
    }

    /**
     DFS to mark all land (1) of provided island to -1
     O( V+E)

     **/
    private void dfs (Queue<Pair<Integer,Integer>> queue,int[][] grid,Pair<Integer,Integer> rowObj, Set<Pair<Integer,Integer>> visited){
        int row = rowObj.getKey();
        int col = rowObj.getValue();
        // boundary check
        if(row < 0 || row >= grid.length || col< 0 || col >= grid[row].length) return;
        if(grid[row][col]==0){
            queue.offer(new Pair(row,col));
        }
        if(!visited.contains(rowObj) && grid[row][col] ==1 ) {
            visited.add(rowObj);
            grid[row][col]=-1;
            //UP
            dfs(queue, grid, new Pair(row-1,col),visited);
            //down
            dfs(queue, grid, new Pair(row+1,col),visited);
            //left
            dfs(queue, grid, new Pair(row,col-1),visited);
            //right
            dfs(queue, grid, new Pair(row,col+1),visited);
        }
    }
}
