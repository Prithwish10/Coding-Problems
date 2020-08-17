//Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
//
//Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
//
//Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.

//Given the following 5x5 matrix:
//
//  Pacific ~   ~   ~   ~   ~ 
//       ~  1   2   2   3  (5) *
//       ~  3   2   3  (4) (4) *
//       ~  2   4  (5)  3   1  *
//       ~ (6) (7)  1   4   5  *
//       ~ (5)  1   1   2   4  *
//          *   *   *   *   * Atlantic
//
//Return:
//
//[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above matrix).

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pacific_Atlantic_Water_Flow {

public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(matrix == null || matrix.length == 0)
            return res;
        
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        
        boolean pacific[][] = new boolean[rowLen][colLen];
        boolean atlantic[][] = new boolean[rowLen][colLen];
        
        for(int col = 0; col < colLen; col++){
            
            dfs(matrix, pacific, 0, col, Integer.MIN_VALUE);
            dfs(matrix, atlantic, rowLen - 1, col, Integer.MIN_VALUE);
        }
        
        for(int row = 0; row < rowLen; row ++){
            
            dfs(matrix, pacific, row, 0, Integer.MIN_VALUE);
            dfs(matrix, atlantic, row, colLen - 1, Integer.MIN_VALUE);
        }
        
        for(int i = 0; i < rowLen; i++){
            for(int j = 0; j < colLen; j++){
                if(pacific[i][j] == true && (pacific[i][j] == atlantic[i][j]))
                    res.add(Arrays.asList(i,j));
            }
        }
        return res;
    }
    private void dfs(int matrix[][], boolean ocean[][], int row, int col, int prev){
        
        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || ocean[row][col]
           || matrix[row][col] < prev)
            return;
        
        ocean[row][col] = true;
        
        dfs(matrix, ocean, row + 1, col, matrix[row][col]);
        dfs(matrix, ocean, row - 1, col, matrix[row][col]);
        dfs(matrix, ocean, row, col + 1, matrix[row][col]);
        dfs(matrix, ocean, row, col - 1, matrix[row][col]);
    }
}
