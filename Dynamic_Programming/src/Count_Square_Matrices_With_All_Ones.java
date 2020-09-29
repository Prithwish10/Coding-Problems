import java.util.Scanner;

public class Count_Square_Matrices_With_All_Ones {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of rows and cols :");
		int r = sc.nextInt();
		int c = sc.nextInt();
		int grid[][] = new int[r][c];
		
		System.out.println("Enter the elements into the matrix :");
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				grid[i][j] = sc.nextInt();
			}
			System.out.println();
		}
		System.out.println(countSquares(grid));
	}
	public static int countSquares(int[][] matrix) {
        
        int r = matrix.length;
        if(r == 0)
            return 0;
        int c = matrix[0].length;
        if(c == 0)
            return 0;
        
        return findMaximalSquare(matrix, r, c);
    }
    public static int findMaximalSquare(int grid[][], int r, int c) {
		
		int max = 0;
		int dp[][] = new int[r + 1][c + 1];
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				max += findMaximalHelper(grid, dp, i, j);
				//max = Math.max(max,  curMax);
			}
		}
		return max;
	}
	private static int findMaximalHelper(int grid[][], int dp[][], int r, int c) {
		
		if(r >= grid.length || c >= grid[0].length || grid[r][c] == 0)
			return dp[r][c] = 0;
		
        if(dp[r][c] != 0)
            return dp[r][c];
        
		int sum = 1 + Math.min(findMaximalHelper(grid, dp, r + 1, c), Math.min(findMaximalHelper(grid, dp,r, c + 1), 
				findMaximalHelper(grid, dp,r + 1, c + 1)));
		
		return dp[r][c] = sum;
	}
}
