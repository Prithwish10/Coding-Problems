import java.util.ArrayList;

public class All_Paths_In_Matrix {

	public static void main(String args[]) {
		
		int ar[][] = {{1, 2, 3},
				      {4, 5, 6},
				      {7, 8, 9}};
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		findPaths(ar,list, 0, 0);
		
		int visited[][] = new int[ar.length][ar[0].length];
		
//		visited[0][0] = 1;
		
		findPath2(ar, visited, 0, 0);
	}
	//All Paths from (0,0) to (n-1, n-1)
	public static void findPaths(int ar[][], ArrayList<Integer> list, int row, int col) {
		
		if(row < 0 || col < 0 || row >= ar.length || col >= ar[0].length) {
			return;
		}
		list.add(ar[row][col]);
		if(row == ar.length - 1 && col == ar[0].length - 1) {
			
			System.out.println(list);
			list.remove(list.size() - 1);
			return;
		}
			
		findPaths(ar, list, row + 1, col);
			
		findPaths(ar, list, row, col + 1);
			
		list.remove(list.size() - 1);
	}
	
	public static void findPath2(int ar[][], int visited[][], int row, int col) {
		
		if(row < 0 || col < 0 || row >= ar.length || col >= ar[0].length) {
			return;
		}
		
		visited[row][col] = ar[row][col];
		
		if(row == ar.length - 1 && col == ar[0].length - 1) {
			
			for(int i = 0; i < visited.length; i++) {
				for(int j = 0; j < visited[0].length; j ++) {
					System.out.print(visited[i][j]+"  ");
				}
				System.out.println();
			}
			System.out.println("...................");
			visited[row][col] = 0;
			return;
		}
		
		findPath2(ar, visited, row + 1, col);
		
		findPath2(ar, visited, row, col + 1);
		
		visited[row][col] = 0;
	}
}
