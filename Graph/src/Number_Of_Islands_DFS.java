import java.util.Scanner;
public class Number_Of_Islands_DFS {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of rows and columns ::");
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		int grid[][] = new int[r][c];
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(findNumberOfIslands(grid, r, c));
	}
	
	public static int findNumberOfIslands(int grid[][], int r, int c) {
		
		int count = 0;
		
		for(int i = 0; i < r; i++) {
			
			for(int j = 0; j < c; j++) {
				if(grid[i][j] == 1) {
					dfs(grid, i, j);
					count ++;
				}
			}
		}
		return count;
	}
	
	public static void dfs(int grid[][], int r, int c) {
		
		if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) return;
		
		if(grid[r][c] == 0) return;
		
		if(grid[r][c] == 2) return;
		
		grid[r][c] = 2;
		
		dfs(grid, r, c - 1);
		dfs(grid, r, c + 1);
		dfs(grid, r + 1, c);
		dfs(grid, r - 1, c);
	}
}
