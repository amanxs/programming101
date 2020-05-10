package programming2020.Algorithms_sedgewick.graphs;

import programming2018.dataStructure.Queue;

/**
 * This Graph client uses breadth-first search to find paths in a graph with the fewest number of edges
 * from the source s given in the constructor. The bfs() method marks all vertices connected to s,
 * so clients can use hasPathTo() to determine whether a given vertex v is connected to s and pathTo() to get a path from s to v
 * with the property that no other such path from s to v has fewer edges.
 */
public class BreadthFirstPaths {
    private boolean[] marked; // Has dfs() been called for this vertex?
    private int edgeTo[]; // last vertex on known path to this vertex
    private final int s; // source


    public BreadthFirstPaths(Graph G, int s)
    {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }


    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new Queue<Integer>();
        marked[s] =true;
        queue.enque(s);
        while(!queue.isEmpty()){
            int v = queue.deque();
            for(int w : G.adj(v)){
                if (!marked[w]) {
                    marked[w] =true;
                    edgeTo[w] = v;
                    queue.enque(w);
                }
            }
        }
    }
}
