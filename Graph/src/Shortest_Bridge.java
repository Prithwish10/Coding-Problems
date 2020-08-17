import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Shortest_Bridge {

	class Pair{
	    
	    int x, y, dis;
	    Pair(int x, int y, int dis){
	        
	        this.x = x;
	        this.y = y;
	        this.dis = dis;
	    }
	}
	public int shortestBridge(int[][] A) {
	     
        if(A == null || A.length == 0)
            return 0;
        
        List<List<Integer>> first = new ArrayList<>();
        List<List<Integer>> second = new ArrayList<>();
        int rowLen = A.length, colLen = A[0].length;
        boolean visited[][] = new boolean[rowLen][colLen];
        
        for(int i = 0; i < A.length; i++){
            
            for(int j = 0; j < A[i].length; j++){
                
                if(A[i][j] == 1 && first.size() == 0)
                    dfs(i, j, A, first, visited, rowLen, colLen);
                else
                    dfs(i, j, A, second, visited, rowLen, colLen);
            }
        }
        int minDis = Integer.MAX_VALUE;
        
        for(int i = 0; i < first.size(); i++){
            
            for(int j = 0; j < second.size(); j++){
                
                int dis = Math.abs(first.get(i).get(0) - second.get(j).get(0)) +                                                Math.abs(first.get(i).get(1) - second.get(j).get(1)) - 1;
                minDis = Math.min(minDis, dis);
            }
        }
        return minDis;
    }
    private void dfs(int i, int j, int A[][], List<List<Integer>> list, boolean[][] visited, int rowLen, int colLen){
        
        if(i < 0 || i >= rowLen || j < 0 || j >= colLen || A[i][j] == 0 ||                                              visited[i][j])
            return;
        
        list.add(Arrays.asList(i, j));
        visited[i][j] = true;
        
        dfs(i - 1, j, A, list, visited, rowLen, colLen);
        dfs(i + 1, j, A, list, visited, rowLen, colLen);
        dfs(i, j - 1, A, list, visited, rowLen, colLen);
        dfs(i, j + 1, A, list, visited, rowLen, colLen);
    }
    
    // ******************************* Optimized Solution ************************************
    public int shortestBridge1(int[][] A) {
        
        if(A == null || A.length == 0)
            return 0;
        
        int rowLen = A.length, colLen = A[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int visited[][] = new int[rowLen][colLen];
        boolean flag = false;
        
        for(int i = 0; i < A.length; i++){
            
            for(int j = 0; j < A[i].length; j++){
                
                if(A[i][j] == 1){
                    dfs(i, j, A, visited, queue, rowLen, colLen);
                    flag = true;
                    break;
                }
            }
            if(flag == true)
                break;
        }
        
        while(!queue.isEmpty()){
            
            Pair p = queue.poll();
            
            int x = p.x;
            int y = p.y;
            int dis = p.dis;
            
            if(A[x][y] == 1)
                return dis - 1;
            
            if(isSafe(x + 1, y, A) && A[x + 1][y] != 2 && visited[x + 1][y] != 1){
                queue.add(new Pair(x + 1, y, dis + 1));
                visited[x + 1][y] = 1;
            }
            if(isSafe(x - 1, y, A) && A[x - 1][y] != 2 && visited[x - 1][y] != 1){
                queue.add(new Pair(x - 1, y, dis + 1));
                visited[x - 1][y] = 1;
            }
            if(isSafe(x, y + 1, A) && A[x][y + 1] != 2 && visited[x][y + 1] != 1){
                queue.add(new Pair(x, y + 1, dis + 1));
                visited[x][y + 1] = 1;
            }
            if(isSafe(x, y - 1, A) && A[x][y - 1] != 2 && visited[x][y - 1] != 1){
                queue.add(new Pair(x, y - 1, dis + 1));
                visited[x][y - 1] = 1;
            }
        }
        return -1;
    }
    private boolean isSafe(int r, int c, int A[][]){
        
        if(r < 0 || r >= A.length || c < 0 || c >= A[0].length)
            return false;
        return true;
    }
    private void dfs(int i, int j, int A[][], int visited[][], Queue<Pair> queue, int rowLen, int colLen){
        
        if(i < 0 || i >= rowLen || j < 0 || j >= colLen || A[i][j] == 0 ||                                              visited[i][j] == 1)
            return;
        
        queue.add(new Pair(i, j, 0));
        visited[i][j] = 1;
        A[i][j] = 2;
        
        dfs(i - 1, j, A, visited, queue, rowLen, colLen);
        dfs(i + 1, j, A, visited, queue, rowLen, colLen);
        dfs(i, j - 1, A, visited, queue, rowLen, colLen);
        dfs(i, j + 1, A, visited, queue, rowLen, colLen);
    }
    
}

