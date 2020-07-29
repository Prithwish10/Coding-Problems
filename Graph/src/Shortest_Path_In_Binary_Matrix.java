//Diagonals included
//UP DOWN RIGHT LEFT DIAGONALS
import java.util.LinkedList;
import java.util.Queue;

class Shortest_Path_In_Binary_Matrix {
	class Object{
	    
	    int x, y, dis;
	    
	    Object(int x, int y, int dis){
	        
	        this.x = x;
	        this.y = y;
	        this.dis = dis;
	    }
	}
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if(grid == null)
            return -1;
        
        int r = grid.length;
        int c = grid[0].length;
        
        if(grid[0][0] != 0 || grid[r - 1][c - 1] != 0)
            return -1;
        
        Queue<Object> queue = new LinkedList<Object>();
        int visited[][] = new int[r][c];
        
        queue.add(new Object(0, 0, 1));
        
        while(!queue.isEmpty()){
            
            Object temp = queue.poll();
            int x = temp.x;
            int y = temp.y;
            int dis = temp.dis;
            
            if(x == r-1 && y == c-1)
                return dis;
            
            //RIGHT
            if(isSafe(grid, x, y + 1) && visited[x][y + 1] == 0 && grid[x][y + 1] == 0){
                
                queue.add(new Object(x, y + 1, dis + 1));
                visited[x][y + 1] = 1;
            }
            //LEFT
            if(isSafe(grid, x, y - 1) && visited[x][y - 1] == 0 && grid[x][y - 1] == 0){
                
                queue.add(new Object(x, y - 1, dis + 1));
                visited[x][y - 1] = 1;
            }
            //LOWER RIGHT DIAGONAL
            if(isSafe(grid, x + 1, y + 1) && visited[x + 1][y + 1] == 0 && grid[x + 1][y + 1] == 0){
                
                queue.add(new Object(x + 1, y + 1, dis + 1));
                visited[x + 1][y  + 1] = 1;
            }
            //LOWER LEFT DIAGONAL
            if(isSafe(grid, x + 1, y - 1) && visited[x + 1][y - 1] == 0 && grid[x + 1][y - 1] == 0){
                
                queue.add(new Object(x + 1, y - 1, dis + 1));
                visited[x + 1][y - 1] = 1;
            }
            //UP
            if(isSafe(grid, x - 1, y) && visited[x - 1][y] == 0 && grid[x - 1][y] == 0){
                
                queue.add(new Object(x - 1, y, dis + 1));
                visited[x - 1][y] = 1;
            }
            //DOWN
            if(isSafe(grid, x + 1, y) && visited[x + 1][y] == 0 && grid[x + 1][y] == 0){
                
                queue.add(new Object(x + 1, y, dis + 1));
                visited[x + 1][y] = 1;
            }
            //UPPER RIGHT DIAGONAL
            if(isSafe(grid, x - 1, y + 1) && visited[x - 1][y + 1] == 0 && grid[x - 1][y + 1] == 0){
                
                queue.add(new Object(x - 1, y + 1, dis + 1));
                visited[x - 1][y + 1] = 1;
            }
            //UPPER LEFT DIAGONAL
            if(isSafe(grid, x - 1, y - 1) && visited[x - 1][y - 1] == 0 && grid[x - 1][y - 1] == 0){
                
                queue.add(new Object(x - 1, y - 1, dis + 1));
                visited[x - 1][y - 1] = 1;
            }
        }
        return -1;
    }
    
    public boolean isSafe(int grid[][], int x, int y){
        
        if(x >= grid.length || x >= grid[0].length || x < 0 || y >= grid.length || y >= grid[0].length || y < 0)
            return false;
        
        return true;
    }
}

