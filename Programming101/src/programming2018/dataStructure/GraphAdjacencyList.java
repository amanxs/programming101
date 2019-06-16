package programming2018.dataStructure;

import java.util.LinkedList;


//Java Program to represent Adjacency List Representation of Graph
public class GraphAdjacencyList {


	// A user define class to represent a graph.
	// A graph is an array of adjacency lists.
	// Size of array will be V (number of vertices
	// in graph)
	static class Graph{
	int V;
	LinkedList<Integer> adjListArray[];

	Graph(int v){
		this.V = v;

		adjListArray = new LinkedList[v];

		//Create a new list for each vertex so that adjacent nodes can be stored
		for (int i = 0; i <V ; i++) {
			adjListArray[i]= new LinkedList<>();
		}
	}

	static void addEdge(Graph graph, int src, int dest){

		//Add an edge from source to list

		graph.adjListArray[src].add(dest);
		/* Since graph is unididrected add an edge from dest to source as well */
		graph.adjListArray[dest].add(src);
	}


	static  void printGraph(Graph graph){

        for (int v = 0; v <graph.V ; v++) {
            LinkedList<Integer> edges = graph.adjListArray[v];
            System.out.println("Adjacency list of vertex "+ v);
            //Iterator<Integer> i = graph.adjListArray[v].listIterator();

            for (Integer edge : edges){
                System.out.print("->" + edge);
            }

        }
    }

		// Driver program to test above functions
		public static void main(String args[])
		{
			// create the graph given in above figure
			int V = 5;
			Graph graph = new Graph(V);
			addEdge(graph, 0, 1);
			addEdge(graph, 0, 4);
			addEdge(graph, 1, 2);
			addEdge(graph, 1, 3);
			addEdge(graph, 1, 4);
			addEdge(graph, 2, 3);
			addEdge(graph, 3, 4);

			// print the adjacency list representation of
			// the above graph
			//printGraph(graph);


		}
	}
}


	 

