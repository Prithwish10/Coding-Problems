import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Course_Schedule2 {

	    public int[] findOrder(int V, int[][] prerequisites) {
	        
	        int res[] = new int[V];
	        int index = 0;
	        
	        if(prerequisites.length == 0){
	            for(int i = V - 1; i >= 0; i --)
	                res[index ++] = i;
	            return res;
	        }
	        
	        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
	        
	        Map<Integer, Integer> incommingDegree = new HashMap<Integer, Integer>();
			
			for(int i = 0; i < V; i++) {
				adj.add(i, new ArrayList<Integer>());
				incommingDegree.put(i, 0);
			}
	        
	        for(int i = 0; i < prerequisites.length; i ++) {
				
				addEdge(adj, incommingDegree, prerequisites[i][1], prerequisites[i][0]);
			}
	        ArrayList<Integer> result = topologicalSort(adj, incommingDegree);
	        
	        if(result.size() < V)
				return new int[]{};
	        
	        for(int i : result){
	            res[index ++] = i;
	        }
	        return res;
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

