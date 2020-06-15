/*
package programming2020.Algorithms_sedgewick.graphs;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class KruskalMST {
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G) {
        mst = new LinkedList<>();
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>(G.edges());
        UF uf = new UF(G.V());
        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.poll();               // Get min weight edge on pq
            int v = e.either(), w = e.other(v); //   and its vertices.
            if (uf.connected(v, w)) continue;
            uf.union(v, w);
            mst.add(e);
        }
    }
}
*/
