package programming2020.Algorithms_sedgewick.graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This Graph implementation maintains a vertex-indexed array of lists of integers.
 * Every edge appears twice: if an edge connects v and w, then w appears in v’s list and v appears in w’s list.
 * The second constructor reads a graph from an input stream, in the format V followed by E followed by
 * a list of pairs of int values between 0 and V 1
 */
public class Graph {
    private final int V;
    private int E;
    private List<Integer> adj[];

    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = new ArrayList[V];
        for(int v=0; v<V; v++){
            adj[v] = new ArrayList<Integer>();
        }
    }

    public Graph(Scanner in){
        this(in.nextInt());
         int E = in.nextInt();
         for(int i =0; i<E; i++){
             int v = in.nextInt();
             int w = in.nextInt();
             addEdge(v,w);
         }
    }

    public int V()  {  return V;  }
    public int E()  {  return E;  }

    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
}
