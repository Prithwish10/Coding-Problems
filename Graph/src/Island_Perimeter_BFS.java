import java.util.LinkedList;
import java.util.Queue;

class Island_Perimeter_BFS {
	class Pair{
	    
	    int x, y;
	    Pair(int x, int y){
	        
	        this.x = x;
	        this.y = y;
	    }
	}

    int perimeter = 0;
    
    public int islandPerimeter(int[][] grid) {
        
        if(grid == null)
            return 0;
        
        int r = grid.length;
        int c = grid[0].length;
        
        int visited[][] = new int[r][c];
        
        for(int i = 0; i < r; i++){
            
            for(int j = 0; j < c; j ++){
                
                if(visited[i][j] == 0 && grid[i][j] == 1){
                    bfs(grid, visited, i, j);
                    return perimeter;
                }
            }
        }
        return perimeter;
    }
    public void bfs(int grid[][], int visited[][], int i, int j){
        
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(i, j));
        visited[i][j] = 1;
        
        while(!queue.isEmpty()){
            
            Pair temp = queue.poll();
            int x = temp.x;
            int y = temp.y;
            
            //UP
            if(x - 1 < 0 || grid[x - 1][y] == 0)
                perimeter ++;
            //DOWN
            if(x + 1 >= grid.length || grid[x + 1][y] == 0)
                perimeter ++;
            //LEFT
            if(y - 1 < 0 || grid[x][y - 1] == 0)
                perimeter ++;
            //RIGHT
            if(y + 1 >= grid[0].length || grid[x][y + 1] == 0)
                perimeter ++;
            
             if(isSafe(visited, grid, x, y + 1) && visited[x][y + 1] == 0 && grid[x][y + 1] == 1){  //Right
                queue.add(new Pair(x, y + 1));
                visited[x][y+1] = 1;
            }
            if(isSafe(visited, grid, x, y - 1) && visited[x][y - 1] == 0 && grid[x][y - 1] == 1){  //Left
                queue.add(new Pair(x, y - 1));
                visited[x][y-1] = 1;
            }
            if(isSafe(visited, grid, x + 1, y) && visited[x + 1][y] == 0 && grid[x + 1][y] == 1){   //Down
                queue.add(new Pair(x + 1, y));
                visited[x + 1][y] = 1;
            }
            if(isSafe(visited, grid, x - 1, y) && visited[x - 1][y] == 0 && grid[x - 1][y] == 1){   //Up
                queue.add(new Pair(x - 1, y));
                visited[x - 1][y] = 1;
            }
        }
    }
    
    public boolean isSafe(int visited[][], int grid[][], int x, int y){
        
        if(x >= grid.length || x < 0 || y >= grid[0].length || y < 0)
            return false;
        
        return true;
    }
    
}
