import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Find the nearest 0 from each cell of a matrix;
public class Matrix_0_1 {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of rows and columns :");
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		int grid[][] = new int[r][c];
		
		System.out.println("Enter the elements :");
		
		for(int i = 0; i < r; i++) {
			
			for(int j = 0; j < c; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		int result[][] = find_0_1_Matrix(grid, r, c);
		
		for(int i = 0; i < r; i++) {
			
			for(int j = 0; j < c; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int[][] find_0_1_Matrix(int grid[][], int r, int c) {
		
		int result[][] = new int[r][c];
		//int visited[][] = new int[r][c];
		
		for(int i = 0; i < r; i++) {
			
			for(int j = 0; j < c; j++) {
				
				if(grid[i][j] == 0)
					result[i][j] = 0;
				else
					result[i][j] = bfs(grid, i, j);
			}
		}
		return result;
	}
	public static int bfs(int grid[][], int i, int j) {
		
		int visited[][] = new int[grid.length][grid[0].length];
		
		Queue<Object> queue = new LinkedList<Object>();
		
		queue.add(new Object(i, j, 0));
		visited[i][j] = 1;
		
		while(!queue.isEmpty()) {
			
			Object temp = queue.poll();
			
			int x = temp.x;
			int y = temp.y;
			int dis = temp.dis;
			
			if(grid[x][y] == 0)
				return dis;
			
			if(isSafe(grid, x, y + 1)) {// && grid[x][y + 1] == 1
				queue.add(new Object(x, y + 1, dis + 1));
				visited[x][y + 1] = 1;
			}
			
			if(isSafe(grid, x, y - 1)) {// && grid[x][y - 1] == 1
				queue.add(new Object(x, y - 1, dis + 1));
				visited[x][y - 1] = 1;
			}
			
			if(isSafe(grid, x + 1, y)) {// && grid[x + 1][y] == 1
				queue.add(new Object(x + 1, y, dis + 1));
				visited[x + 1][y] = 1;
			}
			
			if(isSafe(grid, x - 1, y)) {// && grid[x - 1][y] == 1
				queue.add(new Object(x - 1, y, dis + 1));
				visited[x - 1][y] = 1;
			}
		}
		return -1;
	}
	
	public static boolean isSafe(int grid[][], int x, int y) {
		
		if(x >= grid.length || x < 0 || y >= grid[0].length || y < 0)
			return false;
		
		return true;
	}
}
class Object{
	
	int x, y, dis;
	Object(int x, int y, int dis){
		this.x = x;
		this.y = y;
		this.dis = dis;
	}
}