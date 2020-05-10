package programming2020.Algorithms_sedgewick.graphs;


/**
 * This method is called depth-first search (DFS).
 * An implementation of our Search API using this method is shown at right.
 * It maintains an array of boolean values to mark all of the vertices that are connected to the source.
 * The recursive method marks the given vertex and calls itself for any unmarked vertices on its adjacency list.
 * If the graph is connect- ed, every adjacency-list entry is checked
 */


public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s){
        marked = new boolean[G.V()];
        dfs(G, s);
    }
    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for(int w : G.adj(v)){
            if(!marked[w]) dfs(G, w);
        }
    }
    public boolean marked(int w){
        return marked[w];
    }

    public int count(){
        return count;
    }
}
