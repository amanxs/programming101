package programming2020.Algorithms_sedgewick.graphs;

import java.util.*;

public class Dijkstra {

    class Node{
        int vertex;
        double weight;
        public Node(int v, double w){
            vertex = v;
            weight = w;
        }
    }

    private DirectedEdge[] edgeTo;
    private Double[] distTo;
    private PriorityQueue<Node> pq;
    private boolean[] marked; // Has dfs() been called for this vertex?


    public Dijkstra(EdgeWeightedDigraph G, int s){
        pq = new PriorityQueue<>(Comparator.comparingDouble(node -> node.weight));
        marked = new boolean[G.V()];

        for(int v=0; v<G.V() ; v++){
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;
        pq.add(new Node(s, 0.0));
        marked[s] = true;
        while(!pq.isEmpty()){
            relax(G, pq.poll().vertex);
        }


    }

    public void relax(EdgeWeightedDigraph G, int v){
        for(DirectedEdge e : G.adj(v)){
            int w = e.to();
            if(!marked[v] && distTo[w] > distTo[v] + e.weight()){
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                pq.add(new Node(w, distTo[w]));
            }
        }
        marked[v] = true;
    }

    public double distTo(int v){
        return distTo[v];
    }

    public boolean hasPathTo(int v)
    {   return distTo[v] < Double.POSITIVE_INFINITY;  }

    public Iterable<DirectedEdge> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<DirectedEdge> path = new Stack<>();
        for(DirectedEdge e = edgeTo[v]; e !=null ;e = edgeTo[e.from()]){
            path.push(e);
        }

        return path;
    }

}
