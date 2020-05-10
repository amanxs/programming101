package programming2020.Algorithms_sedgewick.graphs;

import java.util.Stack;

/**
 * This Graph client uses depth-first search to find paths to all the vertices in a graph that are connected to a given start vertex s.
 * To save known paths to each vertex, this code maintains a vertex-indexed array edgeTo[]
 * such that edgeTo[w] = v means that v-w was the edge used to access w for the first time.
 * The edgeTo[] array is a parent-link representation of a tree rooted at s that contains all the vertices connected to s.
 */
public class DepthFirstPaths {

    private boolean[] marked; // Has dfs() been called for this vertex?
    private int edgeTo[]; // last vertex on known path to this vertex
    private final int s; // source


    public DepthFirstPaths(Graph G, int s)
    {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v){
        marked[v] = true;
        for(int w : G.adj(v)){
            if(!marked[w]){
                edgeTo[w] = v;
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if(hasPathTo(v)){
            Stack<Integer> path = new Stack<Integer>();
            for (int i = v; i != s ; i = edgeTo[i]) {
                path.push(i);
            }
            path.push(s);
            return path;
        }
        return null;
    }

    public static void main(String[] args)
    {
        Graph G = new Graph(Integer.parseInt(args[0]));
        int s = Integer.parseInt(args[1]);
        DepthFirstPaths search = new DepthFirstPaths(G, s);
        for (int v = 0; v < G.V(); v++)
        {
            System.out.print(s + " to " + v + ": ");
            if (search.hasPathTo(v))
                for (int x : search.pathTo(v))
                    if (x == s) System.out.print(x);
                    else System.out.print("-" + x);
            System.out.println();
        }
    }
}

/*
Proposition A (continued). DFS allows us to pro- vide clients with a path from a given source to any marked vertex
in time proportional its length.
Proof: By induction on the number of verti- ces visited, it follows that the edgeTo[] array in DepthFirstPaths
represents a tree rooted at the source. The pathTo() method builds the path in time proportional to its length.
 */