import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

//Adjacency Matrix
//Adjacency List
public class Graph_Representation {

	//For undirected graph
	public static void addEdges(Map<Integer, ArrayList<Integer>> adj, int u, int v) {
	
		if(adj.containsKey(u))
			adj.get(u).add(v);
		if(adj.containsKey(v))
			adj.get(v).add(u);
		
		if(!adj.containsKey(u)) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(v);
			adj.put(u, list);
		}
		if(!adj.containsKey(v)) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(u);
			adj.put(v, list);
		}
	}
	//For Directed Graph
	public static void addEdge(Map<Integer, ArrayList<Integer>> adj, int u, int v) {
		
		if(!adj.containsKey(u)) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(v);
			adj.put(u, list);
		}
		else
			adj.get(u).add(v);
	}
	
	public static void printGraph(Map<Integer, ArrayList<Integer>> adj) {
		
		for(Map.Entry<Integer, ArrayList<Integer>> entry : adj.entrySet()) {
			
			System.out.print(entry.getKey());
			
			for(int i = 0; i < entry.getValue().size(); i ++)
				System.out.print(" -> "+entry.getValue().get(i));
			
			System.out.println();
		}
	}
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of vertices :");
		int V = sc.nextInt();
		
		Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>(V);
		
		System.out.println("Enter the number of edges :");
		int e = sc.nextInt();
		
//		for(int i = 0; i < V; i++)
//			adj.put(i, new ArrayList<Integer>());
		System.out.println("Enter the connecting edges :");
		
		for(int i = 0; i < e; i++) {
			
			int u = sc.nextInt();
			
			int v = sc.nextInt();
			
			addEdge(adj, u, v);
		}
		
//		System.out.println("For undirected graph :");
//		printGraph(adj);
		
		System.out.println("For directed graph the graph representation using adjacency list is:");
		printGraph(adj);
	}
}
