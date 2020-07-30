class Max_Area_Of_Island_DFS {
    int count = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        
        if(grid == null || grid.length == 0)
            return 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    dfs(grid, i, j);
                    System.out.println(count);
                    max = Math.max(max, count);
                    count = 0;
                }
            }
        }
        return max;
    }
    public void dfs(int grid[][], int r, int c){
        
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return ;
        
        if(grid[r][c] == 0) return ;
        
        if(grid[r][c] == 2) return ;
        
        grid[r][c] = 2;
        count ++;
        
        dfs(grid, r, c + 1);
        dfs(grid, r, c - 1);
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        
    }
}

