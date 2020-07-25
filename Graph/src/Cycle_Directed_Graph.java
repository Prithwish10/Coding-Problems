import java.util.ArrayList;
import java.util.Scanner;
public class Cycle_Directed_Graph {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of vertices :");
		int V = sc.nextInt();
		
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i < V; i++)
			adj.add(i, new ArrayList<Integer>());
		
		System.out.println("Enter the number of edges :");
		int E = sc.nextInt();
		
		System.out.println("Enter the edge connections :");
		
		for(int i = 0; i < E; i++) {
			
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			addEdges(adj, u, v);
		}
		print(adj, V);
		boolean res = isCyclePresent(adj, V);
		System.out.println(res);
	}
	
	public static void addEdges(ArrayList<ArrayList<Integer>> adj, int u, int v) {
		
		adj.get(u).add(v);
	}
	
	public static void print(ArrayList<ArrayList<Integer>> adj, int V) {
		
		for(int i = 0; i < V; i ++) {
			System.out.print(i);
			for(int j = 0; j < adj.get(i).size(); j ++) {
				
				System.out.print(" -> "+adj.get(i).get(j));
			}
			System.out.println();
		}
	}
	
	public static boolean isCyclePresent(ArrayList<ArrayList<Integer>> adj, int V) {
		
		boolean visited[] = new boolean[V];
		boolean recurArr[] = new boolean[V];
		
		return dfs(adj, visited, recurArr, 0);
	}
	
	public static boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recurArr, int index) {
		
		//If the current index/node is already present the recursive stack then cycle exist
		if(recurArr[index] == true)
			return true;
		//If the visited array is already true that means we have already visited the node and no cycle exist
		if(visited[index] == true)
			return false;
		//Otherwise we make the current node to be visited(true) 
		//and also mark the cururArr to be true(meaning the current node is present in the recursive stack)
		visited[index] = true;
		recurArr[index] = true;
		
		//Then we recursively go to each node and visit all its children
		ArrayList<Integer> child = adj.get(index);
		for(int i : child) {
			//If a cycle exist then we will return true
			if(dfs(adj, visited, recurArr, i))
				return true;
		}
		//If a cycle does not exist then we backtrack and mark the current node/index to be false
		recurArr[index] = false;
		return false;
	}
}
