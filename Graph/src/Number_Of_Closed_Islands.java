//Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
//
//Return the number of closed islands.
//
// 
//
//Example 1:
//
//
//
//Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
//Output: 2
//Explanation: 
//Islands in gray are closed because they are completely surrounded by water (group of 1s).
//Example 2:
//
//
//
//Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
//Output: 1
//Example 3:
//
//Input: grid = [[1,1,1,1,1,1,1],
//               [1,0,0,0,0,0,1],
//               [1,0,1,1,1,0,1],
//               [1,0,1,0,1,0,1],
//               [1,0,1,1,1,0,1],
//               [1,0,0,0,0,0,1],
//               [1,1,1,1,1,1,1]]
//Output: 2
public class Number_Of_Closed_Islands {

	boolean flag = false;
    public int closedIsland(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        
        int ans = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1)
                    continue;
                if(i == 0 || j == 0 || i == grid.length - 1 || j == grid[i].length - 1){
                    dfs(grid, i, j);
                }else{
                    flag = false;
                    dfs(grid, i, j);
                    if(!flag)
                        ans ++;
                    else{
                        flag = false;
                    }
                        
                }
            }
        }
        return ans;
    }
    private void dfs(int grid[][], int r, int c){
        
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 1)
            return;
        if((r == 0 || c == 0 || r == grid.length - 1 || c == grid[0].length - 1) && grid[r][c] == 0){
            flag = true;
        }
        grid[r][c] = 1;
        
        dfs(grid, r + 1, c);
        dfs(grid, r - 1, c);
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
    }
}
