class Re_Shape_Matrix {
	
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        
        int rows = nums.length;
        int cols = nums[0].length;
        
        if(rows * cols != r * c)
            return nums;
        
        int grid[][] = new int[r][c];
        
        int row_num = 0;
        int col_num = 0;
        
        for(int i = 0; i < rows; i++){
            
            for(int j = 0; j < cols; j++){
                
                grid[row_num][col_num] = nums[i][j];
                
                col_num ++;
                
                if(col_num == c){
                    
                    col_num = 0;
                    row_num ++;
                }
            }
        }
        return grid;
    }
}
