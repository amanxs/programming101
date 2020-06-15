package programming2020.Algorithms_sedgewick.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 *
 This implementation maintains a vertex-indexed array of lists of edges. As with Graph (see page 526), every edge appears twice:
 if an edge connects v and w, it appears both in v’s list and in w’s list. The edges() method puts all the edges in a List.
 The toString() implementation is left as an exercise.
 */
public class EdgeWeightedGraph {

    public static void main(String[] args) {
        int DP[][] = new int[2][2];
        System.out.println(DP[0][0]);
        if(DP[1][1] == 0){
            System.out.println("no Initialisation required");
        }

    }
    private final int V;
    private int E;
    private ArrayList<Edge>[] adj;

    public EdgeWeightedGraph(int V){
        this.V = V;
        this.E = 0;
        adj = (ArrayList<Edge>[])new ArrayList[V];

        for(int v=0; v< V; v++){
            adj[v] = new ArrayList<Edge>();
        }
    }
    public int V() {  return V;  }
    public int E() {  return E;  }

    public void addEdge(Edge e){
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public Iterable<Edge> adj(int v){
        return adj[v];
    }

    public Iterable<Edge> edges(){
        List<Edge> edges = new ArrayList<>();
        for(int v=0 ; v<V; v++){
            for(Edge e : adj[v]){
                if(e.other(v) > v) edges.add(e);
            }
        }

        return edges;
    }
}
