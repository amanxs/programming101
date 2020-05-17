package programming2020.Algorithms_sedgewick.graphs;

import java.util.Stack;

/**
 * This class adds to our standard recursive dfs() a boolean array onStack[] to keep track of the vertices
 * for which the recursive call has not completed. When it finds an edge v->w to a vertex w that is on the stack,
 * it has discovered a directed cycle, which it can recover by following edgeTo[] links.
 */
public class DirectedCycle {

    private boolean marked[];
    private int edgeTo[];
    private Stack<Integer> cycle; // vertices on a cycle (if one exists)
    private boolean onStack[]; // vertices on recursive call stack

    public DirectedCycle(Digraph G){
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for(int v=0 ; v < G.V() ; v++){
            if(!marked[v]){
                dfs(G,v);
            }
        }
    }

    private void dfs(Digraph G, int v){
        onStack[v] = true;
        marked[v]  = true;
        for(int w : G.adj(v)){
            if(!marked[w]) {
                edgeTo[w] = v;
                dfs(G,w);
            }
            else if(onStack[w]){

            }
        }
    }

}
