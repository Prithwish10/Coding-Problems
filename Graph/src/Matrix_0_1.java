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
			
			if(isSafe(grid, x, y + 1) && visited[x][y + 1] == 0) {
				queue.add(new Object(x, y + 1, dis + 1));
				visited[x][y + 1] = 1;
			}
			
			if(isSafe(grid, x, y - 1) && visited[x][y - 1] == 0) {
				queue.add(new Object(x, y - 1, dis + 1));
				visited[x][y - 1] = 1;
			}
			
			if(isSafe(grid, x + 1, y) && visited[x + 1][y] == 0) {
				queue.add(new Object(x + 1, y, dis + 1));
				visited[x + 1][y] = 1;
			}
			
			if(isSafe(grid, x - 1, y) && visited[x - 1][y] == 0) {
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
	
	//Optimized Solution
	//First Insert the zeroes into the queue
	//Then check for the adjacent (up, down left, right)
	//Maintain the visited array
	//pop each object from the queue and check whether the adjacent element are not visited and if they are 1
	//If not visited and alo the adjacent element is 1 then add the position of that element into the queue
	//and also update that element by 1 + the element that is popped
	public int[][] updateMatrix(int[][] grid) {
        
        if(grid == null)
            return new int[][]{{}};
        
        int r = grid.length;
        int c = grid[0].length;
        
        Queue<Object1> queue = new LinkedList<Object1>();
        int visited[][] = new int[r][c];
        
        for(int i = 0; i < r; i++){
            
            for(int j = 0; j < c; j++){
                
                if(grid[i][j] == 0){
                    queue.add(new Object1(i, j));
                    visited[i][j] = 1;
                }
            }
        }
        
        while(!queue.isEmpty()){
            
            Object1 temp = queue.poll();
            
            int x = temp.x;
            int y = temp.y;
            
            if(isSafe(grid, x, y - 1) && visited[x][y - 1] == 0 && grid[x][y - 1] == 1){
                queue.add(new Object1(x, y - 1));
                grid[x][y -1] = grid[x][y] + 1;
                visited[x][y - 1] = 1;
            }
            if(isSafe(grid, x, y + 1) && visited[x][y + 1] == 0 && grid[x][y + 1] == 1){
                queue.add(new Object1(x, y + 1));
                grid[x][y + 1] = grid[x][y] + 1;
                visited[x][y + 1] = 1;
            }
            if(isSafe(grid, x - 1, y) && visited[x - 1][y] == 0 && grid[x - 1][y] == 1){
                queue.add(new Object1(x - 1, y));
                grid[x - 1][y] = grid[x][y] + 1;
                visited[x - 1][y] = 1;
            }
            if(isSafe(grid, x + 1, y) && visited[x + 1][y] == 0 && grid[x + 1][y] == 1){
                queue.add(new Object1(x + 1, y));
                grid[x + 1][y] = grid[x][y] + 1;
                visited[x + 1][y] = 1;
            }
        }
        return grid;
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
class Object1{
	
	int x, y;
	Object1(int x, int y){
		this.x = x;
		this.y = y;
	}
}