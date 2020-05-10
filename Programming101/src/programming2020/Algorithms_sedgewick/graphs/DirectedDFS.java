package programming2020.Algorithms_sedgewick.graphs;

import programming2020.Algorithms_sedgewick.lib.Bag;

public class DirectedDFS {
    private boolean marked[];

    public DirectedDFS(Digraph G, int s){
        marked = new boolean[G.V()];
        dfs(G,s);
    }

    public DirectedDFS(Digraph G, Iterable<Integer> sources){
        marked = new boolean[G.V()];
        for (int s : sources){
            if(!marked[s]){
                dfs(G, s);
            }
        }
    }

    private void dfs(Digraph G, int v){
        marked[v] = true;

        for(int w : G.adj(v)){
            if(!marked[w]){
                dfs(G, w);
            }
        }
    }

    public boolean marked(int v)
    {  return marked[v];  }

    public static void main(String[] args) {
        Digraph G = new Digraph(Integer.valueOf(args[0]));

        Bag<Integer> sources = new Bag<Integer>();
        for (int i = 1; i < args.length; i++)
            sources.add(Integer.parseInt(args[i]));

        DirectedDFS reachable = new DirectedDFS(G, sources);

        for (int v = 0; v < G.V(); v++)
            if (reachable.marked(v)) System.out.print(v + " ");
        System.out.println();

    }

//This implementation of depth-first search provides clients the ability to test which vertices are reachable from a given vertex or a given set of vertices.
}
