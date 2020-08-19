import java.util.*;
public class Minimum_Time_To_Collect_All_Apples_In_A_Tree {

	public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        
        Map<Integer, ArrayList<Integer>> adj = new HashMap<>();
        
        for(int i = 0; i < n; i++)
            adj.put(i, new ArrayList<Integer>());
        
        for(int i = 0; i < edges.length; i++){
            
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean visited[] = new boolean[n];
        
        return dfs(adj, visited, 0, hasApple);
    }
    
    public int dfs(Map<Integer, ArrayList<Integer>> adj, boolean visited[], int node, List<Boolean> hasApple){
        
        int appleCount = 0;
        
        visited[node] = true;
        
        ArrayList<Integer> child = adj.get(node);
        
        for(int neighbour : child){
            
            if(!visited[neighbour]){
                
                appleCount += dfs(adj, visited, neighbour, hasApple);
            }
        }
        return (appleCount != 0 || hasApple.get(node)) ? (node == 0 ? appleCount : appleCount + 2) : 0;
    }

}

