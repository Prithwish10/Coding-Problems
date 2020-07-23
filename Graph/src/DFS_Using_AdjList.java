import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import java.util.Map;

import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
public class DFS_Using_AdjList {

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
	
	public static void dfs(Map<Integer, ArrayList<Integer>> adj, int src, int v) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int visited[] = new int[v];
		Set<Integer> set = new HashSet<Integer>();
		stack.add(src);
		//visited[src] = 1;
		set.add(src);
		
		while(!stack.isEmpty()) {
			
			int temp = stack.pop();
			
			System.out.print(temp+" ");
			
			for(int i = 0; i < adj.get(temp).size(); i++) {
				
				int j = adj.get(temp).get(i);
				
				if(!set.contains(j)) {
					
					stack.add(j);
					//visited[j] = 1;
					set.add(j);
				}
			}
		}
	}
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of vertices :");
		int V = sc.nextInt();
		
		Map<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>(V);
		
		System.out.println("Enter the number of edges :");
		int e = sc.nextInt();
	
		System.out.println("Enter the connecting edges :");
		
		for(int i = 0; i < e; i++) {
			
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			addEdges(adj, u, v);
		}
		
		System.out.println("Enter the source vertex :");
		int src = sc.nextInt();
		
		dfs(adj, src, V);
	}
}

