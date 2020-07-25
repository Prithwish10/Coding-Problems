import java.util.ArrayList;
import java.util.Scanner;

class Course_Schedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if(numCourses == 0 || prerequisites.length == 0)
            return true;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < numCourses; i++){
            
            adj.add(i, new ArrayList<Integer>());
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            
            adj.get(u).add(v);
        }
        
        boolean visited[] = new boolean[numCourses];
        boolean recurArray[] = new boolean[numCourses];
        
        for(int i = 0; i < numCourses; i ++) {
			
			if(visited[i] == false && dfs(adj, visited, recurArray, i))
				return false;
		}
		return true;
    }
    
    public static boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean visited[], boolean recurArr[], 
                       int index){
        
        if(recurArr[index] == true)
            return true;
        
        if(visited[index] == true)
            return false;
        
        visited[index] = true;
        recurArr[index] = true;
        
        ArrayList<Integer> child = adj.get(index);
        
        for(int i : child){
            
            if(dfs(adj, visited, recurArr, i))
                return true;
        }
        recurArr[index] = false;
        return false;
    }
    
    public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of courses :");
		int numCourses = sc.nextInt();
		
		
		System.out.println("Enter the number of edges :");
		int E = sc.nextInt();
		
		int preRequisit[][] = new int[E][2];
		
		System.out.println("Enter the course dependencies :");
		
		for(int i = 0; i < E; i++) {
			
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			preRequisit[i][0] = u;
			preRequisit[i][1] = v;
		}
		
		boolean res = canFinish(numCourses, preRequisit);
		System.out.println(res);
	}
}
