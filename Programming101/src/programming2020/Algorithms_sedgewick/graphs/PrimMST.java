package programming2020.Algorithms_sedgewick.graphs;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Our first MST method, known as Prim’s algorithm, is to attach a new edge to a single growing tree at each step.
 * Start with any vertex as a single-ver- tex tree; then add V􏰁1 edges to it, always taking next (coloring black) the minimum-
 * weight edge that connects a vertex on the tree to a vertex not yet on the tree (a crossing edge for the cut defined by tree vertices).
 */
public class PrimMST {
    private boolean marked[]; //We use a vertex-indexed boolean array marked[], where marked[v] is true if v is on the tree.
    private Queue<Edge> mst;//: a queue mst to collect MST edges
    private PriorityQueue<Edge> pq;//We use a MinPQ<Edge> priority queue that compares edges by weight

    /**
     * This implementation of Prim’s algorithm uses a priority queue to hold crossing edges, a vertex-indexed arrays to mark tree vertices,
     * and a queue to hold MST edges. This implementation is a lazy approach where we leave ineligible edges in the priority queue.
     */
    PrimMST(EdgeWeightedGraph G){
        pq = new PriorityQueue<>();
        marked = new boolean[G.V()];
        mst = new LinkedList<>();
        visit(G, 0); // assumes G is connected
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            int v = e.either(); int w = e.other(v);
            if(marked[v] && marked[w]) continue;
            mst.add(e);
            if(!marked[v]) visit(G, v);
            if(!marked[w]) visit(G, w);

        }
    }
    private void visit(EdgeWeightedGraph G, int v){
        //Mark v and add to pq all edges from v to unmarked vertices.
        marked[v] = true;
        for(Edge e : G.adj(v)){
            if(!marked[e.other(v)]) pq.add(e);
        }
    }

    public Iterable<Edge> edges()
    {  return mst;  }
}
