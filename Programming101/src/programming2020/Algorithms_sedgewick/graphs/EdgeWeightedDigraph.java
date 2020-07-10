package programming2020.Algorithms_sedgewick.graphs;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedDigraph {
    private int V;
    private int E;
    private ArrayList<DirectedEdge> adj[];

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (ArrayList<DirectedEdge>[])new ArrayList[V];

        for (int v = 0; v < V; v++) {
            adj[v] = new ArrayList<DirectedEdge>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E++;

    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    public Iterable<DirectedEdge> edges() {
        List<DirectedEdge> edges = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            for (DirectedEdge e : adj[v]) {
                edges.add(e);
            }
        }
        return edges;
    }

}
