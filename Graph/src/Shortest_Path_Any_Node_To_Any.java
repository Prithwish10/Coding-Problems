//Using BFS

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
public class Shortest_Path_Any_Node_To_Any {

	static class Pair{
		
		int node;
		int dis;
		
		Pair(int node, int dis){
			
			this.node = node;
			this.dis = dis;
		}
	}
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number od vertices :");
		int V = sc.nextInt();
		
		Map<Integer, ArrayList<Integer>> adj = new HashMap<>(V);
		
		System.out.println("Enter the number of edges :");
		int e = sc.nextInt();
		
		System.out.println("Enter the connecting edges in the form of node (like 0 1) :");
		
		for(int i = 0; i < e; i++) {
			
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			addEdge(adj, u, v);
		}
		System.out.println("Enter the source and the destination :");
		int src = sc.nextInt();
		int des = sc.nextInt();
		
		System.out.println("The shortest path from source to destination is :"+find_Shortest_Path(adj, src, des));
	}
	
	public static void addEdge(Map<Integer, ArrayList<Integer>> adj, int u, int v) {
		
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
	
	public static int find_Shortest_Path(Map<Integer, ArrayList<Integer>> adj, int src, int desti) {
		
		Set<Integer> visited = new HashSet<Integer>();
		
		Queue<Pair> queue = new LinkedList<Pair>();
		
		queue.add(new Pair(src, 0));
		visited.add(src);
		
		while(!queue.isEmpty()) {
			
			Pair temp = queue.poll();
			
			if(temp.node == desti)
				return temp.dis;
			
			for(int i = 0; i < adj.get(temp.node).size(); i++) {
				
				int j = adj.get(temp.node).get(i);
				
				if(!visited.contains(j)) {
					
					queue.add(new Pair(j, temp.dis + 1));
					visited.add(j);
				}
			}
		}
		return -1;
	}
}
