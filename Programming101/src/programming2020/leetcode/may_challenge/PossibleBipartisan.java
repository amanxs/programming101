package programming2020.leetcode.may_challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PossibleBipartisan {
        public boolean possibleBipartition(int N, int[][] dislikes, int test) {
            List<Integer> list1 = new ArrayList<Integer>();
            List<Integer> list2 = new ArrayList<Integer>();

            for(int i=0; i<dislikes.length; i++){
                int n1 = dislikes[i][0];
                int n2 = dislikes[i][1];
                if(list1.contains(n1)){
                    if(list1.contains(n2)) return false;
                    else if(list2.contains(n2)) continue;
                    else list2.add(n2);
                }
                else if(list2.contains(n1)){
                    if(list2.contains(n2)) return false;
                    else if(list1.contains(n2)) continue;
                    else list1.add(n2);
                }
                else
                {
                    list1.add(n1);
                    if(list1.contains(n2)) return false;
                    else if(list2.contains(n2)) continue;
                    else list2.add(n2);
                }
            }

            return true;

        }

    private Map<Integer, List<Integer>> graph;
    private int[] visited;
    public boolean possibleBipartition(int N, int[][] dislikes) {
        if(N == 0 || dislikes.length == 0) return true;
        graph = new HashMap<>();
        for(int[] edge : dislikes){
           graph.computeIfAbsent(edge[0], x-> new ArrayList<>()).add(edge[1]);
           graph.computeIfAbsent(edge[1], x-> new ArrayList<>()).add(edge[0]);

        }
        /**
         * for(int[] dislike : dislikes){
         *             List<Integer> temp = graph.containsKey(dislike[0]) ? graph.get(dislike[0]): new ArrayList<>();
         *             temp.add(dislike[1]);
         *             graph.put(dislike[0], temp);
         *             temp = graph.containsKey(dislike[1]) ? graph.get(dislike[1]): new ArrayList<>();
         *             temp.add(dislike[0]);
         *             graph.put(dislike[1], temp);
         *         }
         */
        visited = new int[N + 1];
        for(int i = 0; i < N; i++){
            if(visited[i] == 0 && !dfs(i, 1)) return false;
        }
        return true;
    }
    private boolean dfs(int node, int color){
        if(visited[node] != 0 && visited[node] != color) return false;
        if(visited[node] == color) return true;
        visited[node] = color;
        List<Integer> neighbours = graph.get(node);
        if(neighbours == null) return true;
        for(Integer neighbour : neighbours){
            if(!dfs(neighbour, -color)) return false;
        }
        return true;
    }

}
