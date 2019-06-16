package programming2018.graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class BreadthFirstSearch {

class Graph{

    private int V; // no. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    Graph(int v){
        V=v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i]= new LinkedList<>();
        }

    }

    //Function to add an edge into the graph
    void addEdge(int v,int w){
        adj[v].add(w);
    }

    void BFS(int s){

        //Mark all veritices as not visited(By default set to false)
        boolean visited[] = new boolean[V];

        //Create a queue for BFS
        LinkedList<Integer> queue= new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while(queue.size()!=0) {
            //dequeue a vertex from the queue and print it
           s = queue.poll();

           //Get all the adjacent vertices of the dequeued vertex s.
           // if the adjacent vertex has not been visited then mark it visited and enqueue it
           Iterator<Integer> i = adj[s].listIterator();
           while(i.hasNext()){
               int n = i.next();
               if(!visited[n]){
                   visited[n]=true;
                   queue.add(n);
               }
           }

        }
    }
}


    // Driver method to
    public void main(String args[])
    {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal "+
                "(starting from vertex 2)");

        g.BFS(2);
    }
}

