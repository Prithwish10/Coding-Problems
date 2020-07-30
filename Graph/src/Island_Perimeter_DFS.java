import java.util.Scanner;

class Island_Perimeter_DFS {
    static int count = 0;
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
		
		System.out.println(islandPerimeter(grid));
	}
    public static int islandPerimeter(int[][] grid) {
        boolean b = false;
        for (int i = 0; i < grid.length; i++) {
            if (b) break;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    b = true;
                    break;
                }
            }
        }
        return count;
    }
    public static boolean dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) return true;
        if (grid[i][j] == 2) return false;
        if (grid[i][j] == 0) return true;
        grid[i][j] = 2;
        if (dfs(grid, i + 1, j)) count++;
        if (dfs(grid, i, j + 1)) count++;
        if (dfs(grid, i, j - 1)) count++;
        if (dfs(grid, i - 1, j)) count++;
        return false;
    }
}
