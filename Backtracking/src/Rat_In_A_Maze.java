
public class Rat_In_A_Maze {

	public static void main(String args[]) {
		
		int maze[][] = {{1, 1, 0},
						{1, 1, 1},
						{0, 1, 1}};
		
		int row = maze.length;
		int col = maze[0].length;
		
		int[][] visited = new int[row][col];
		
		findPath(maze, visited, 0, 0, row, col);
	}
	
	public static void findPath(int maze[][], int visited[][], int row, int col, int x, int y) {
		
		if(row < 0 || col < 0 || row >= x || col >= y || maze[row][col] == 0 || visited[row][col] == 1) {
			
			return;
		}
		
		visited[row][col] = 1;
		
		if(row == x - 1 && col == y - 1) {
			
			printMaze(visited);
			visited[row][col] = 0;
			return;
		}
		
		findPath(maze, visited, row, col - 1, x, y);  //left
		findPath(maze, visited, row, col + 1, x, y);  // right
		findPath(maze, visited, row - 1, col, x, y);  //up
		findPath(maze, visited, row + 1, col, x, y);  //down
		
		visited[row][col] = 0;
	}
	public static void printMaze(int visited[][]) {
		
		for(int i = 0; i < visited.length; i++) {
			for(int j = 0; j < visited[0].length; j++) {
				System.out.print(visited[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("......................");
	}
}
