
public class Count_Server {

	public int countServers(int[][] grid) {
        
        int count = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && helper(grid, i, j)){
                    count ++;
                }
            }
        }
        return count;
    }
    public boolean helper(int grid[][], int r, int c){
        
        for(int i = 0; i < grid.length; i++){
            if(i != r && grid[i][c] == 1)
                return true;
        }
        for(int j = 0; j < grid[0].length; j++){
            if(j != c && grid[r][j] == 1)
                return true;
        }
        return false;
    }
}
