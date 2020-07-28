import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
public class Topological_Sort {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of vertices :");
		int V = sc.nextInt();
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
		
		System.out.println("Enter the number of edges :");
		int E = sc.nextInt();
		
		Map<Integer, Integer> incommingDegree = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < V; i++) {
			adj.add(i, new ArrayList<Integer>());
			incommingDegree.put(i, 0);
		}
		
		System.out.println("Enter the edge connections :");
		
		for(int i = 0; i < E; i ++) {
			
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			addEdge(adj, incommingDegree, u, v);
		}
		
		ArrayList<Integer> result = topologicalSort(adj, incommingDegree);
		
		if(result.size() < V)
			System.out.println("Cycle Exist !!");
		else
			System.out.println(result);
	}
	public static void addEdge(ArrayList<ArrayList<Integer>> adj, Map<Integer, Integer> incommingDegree, int u, int v) {
		
		adj.get(u).add(v);
		incommingDegree.put(v, incommingDegree.get(v) + 1);
	}
	
	public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj, Map<Integer, Integer> incommingDegree) {
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for(Map.Entry<Integer, Integer> entry : incommingDegree.entrySet()) {
			
			if(entry.getValue() == 0)
				queue.add(entry.getKey());
		}
		
		while(!queue.isEmpty()) {
			
			int temp = queue.poll();
			res.add(temp);
			
			ArrayList<Integer> child = adj.get(temp);
			
			for(int neighbour : child) {
				
				incommingDegree.put(neighbour, incommingDegree.get(neighbour) - 1);
				
				if(incommingDegree.get(neighbour) == 0)
					queue.add(neighbour);
			}
		}
		return res;
	}
}
