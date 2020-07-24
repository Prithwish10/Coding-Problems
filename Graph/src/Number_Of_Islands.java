import java.util.LinkedList;
import java.util.Queue;

class Number_Of_Islands {
    public int numIslands(char[][] grid) {
        
        if(grid == null || grid.length == 0)
            return 0;
        
        int visited[][] = new int[grid.length][grid[0].length];
        int count = 0;
        
        for(int i = 0; i < grid.length; i++){
            
            for(int j = 0; j < grid[i].length; j++){
                
                if(visited[i][j] == 0 && grid[i][j] == '1'){
                   
                    bfs(visited, grid, i, j);
                    
                    count ++;
                }
            }
        }
        return count;
    }
    public void bfs(int visited[][], char grid[][], int i, int j){
        
        Queue<Pair> queue = new LinkedList<>();
        
        queue.add(new Pair(i, j));
        
        visited[i][j] = 1;
        
        while(!queue.isEmpty()){
            
            Pair temp = queue.poll();
            
            int x = temp.x;
            int y = temp.y;
            
                
            if(isSafe(visited, grid, x, y + 1) && visited[x][y + 1] == 0 && grid[x][y + 1] == '1'){  //Right
                queue.add(new Pair(x, y + 1));
                visited[x][y+1] = 1;
            }
            if(isSafe(visited, grid, x, y - 1) && visited[x][y - 1] == 0 && grid[x][y - 1] == '1'){  //Left
                queue.add(new Pair(x, y - 1));
                visited[x][y-1] = 1;
            }
            if(isSafe(visited, grid, x + 1, y) && visited[x + 1][y] == 0 && grid[x + 1][y] == '1'){   //Down
                queue.add(new Pair(x + 1, y));
                visited[x + 1][y] = 1;
            }
            if(isSafe(visited, grid, x - 1, y) && visited[x - 1][y] == 0 && grid[x - 1][y] == '1'){   //Up
                queue.add(new Pair(x - 1, y));
                visited[x - 1][y] = 1;
            }
            
        }
    }
    
    public boolean isSafe(int visited[][], char grid[][], int x, int y){
        
        if(x >= grid.length || x < 0 || y >= grid[0].length || y < 0)
            return false;
        
        return true;
    }
}
class Pair{
    
    int x;
    int y;
    
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
