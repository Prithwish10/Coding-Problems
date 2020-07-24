import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//Given a matrix where each block represent 4 things : P, B, S, D
// S represent Source
// D represent Destination
// P represents a path exists
// B represents a block path
//We need to return the minimum time to reach from source to destination

//Implementation of BFS

public class Minimum_Time_Source_To_Destination {

	static class Coordinate{
		
		int x;
		int y;
		int dis;
		
		public Coordinate(int x, int y, int dis) {

			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of rows and columns :");
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		char grid[][] = new char[r][c];
		
		System.out.println("Enter the elements(P || B || S || D) :");
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				grid[i][j] = sc.next().charAt(0);
			}
		}
		
		int visited[][] = new int[r][c];
		int res = findMinimum(grid, visited, r, c, 0, 0);
		
		System.out.println(res);
	}
	
	public static int findMinimum(char grid[][], int visited[][], int r, int c, int i, int j) {
		
		Queue<Coordinate> queue = new LinkedList<Coordinate>();
		
		queue.add(new Coordinate(i, j, 0));
		
		visited[i][j] = 1;
		
		while(!queue.isEmpty()) {
			
			Coordinate temp = queue.poll();
			
			int x = temp.x;
			int y = temp.y;
			int dis = temp.dis;
			
			if(grid[x][y] == 'D')
				return dis;
			
			if(isSafe(visited, grid, x, y + 1) && visited[x][y + 1] == 0 && grid[x][y] != 'B'){  //Right
	            queue.add(new Coordinate(x, y + 1, dis + 1));
	            visited[x][y+1] = 1;
	        }
	        if(isSafe(visited, grid, x, y - 1) && visited[x][y - 1] == 0 && grid[x][y] != 'B'){  //Left
	            queue.add(new Coordinate(x, y - 1, dis + 1));
	            visited[x][y-1] = 1;
	        }
	        if(isSafe(visited, grid, x + 1, y) && visited[x + 1][y] == 0 && grid[x][y] != 'B'){   //Down
	            queue.add(new Coordinate(x + 1, y, dis + 1));
	            visited[x + 1][y] = 1;
	        }
	        if(isSafe(visited, grid, x - 1, y) && visited[x - 1][y] == 0 && grid[x][y] != 'B'){   //Up
	            queue.add(new Coordinate(x - 1, y, dis + 1));
	            visited[x - 1][y] = 1;
	        }
		}
		return -1;
	}
	
	 public static boolean isSafe(int visited[][], char grid[][], int x, int y){
	        
	        if(x >= grid.length || x < 0 || y >= grid[0].length || y < 0)
	            return false;
	        
	        return true;
	 }
}
