import java.util.Scanner;

public class Path_With_Minimum_Effort {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of row and columns :");
		int row = sc.nextInt();
		int col = sc.nextInt();
		
		int ar[][] = new int[row][col];
		
		System.out.println("Enter the elements :");
		for(int i = 0; i < row; i ++) {
			for(int j = 0; j < col; j++) {
				ar[i][j] = sc.nextInt();
			}
		}
		minEffort(ar,row, col);
	}
	
	public static void minEffort(int ar[][], int r, int c) {
		
		int start = 0, end = Integer.MAX_VALUE, ans = 0;
		
		while(start <= end) {
			
			int mid = start + (end - start)/2;
			boolean visited[][] = new boolean[r][c];
			
			boolean res = helper(ar, visited, 0, 0, mid);
			
			
			if(res == true) {
				ans = mid;
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		System.out.println(ans);
	}
	
	
	public static boolean helper(int ar[][], boolean visited[][], int r, int c, int max) {
		
		if(r == ar.length - 1 && c == ar[0].length - 1) {
			return true;
		}
		
		visited[r][c] = true;
		boolean op = false;
		
		if(r > 0 && !visited[r - 1][c] && Math.abs(ar[r][c] - ar[r - 1][c]) <= max)  // DOWN
			op = op || helper(ar, visited, r - 1, c, max);
		
		if(r < ar.length - 1 && !visited[r + 1][c] && Math.abs(ar[r][c] - ar[r + 1][c]) <= max)
			op = op || helper(ar, visited, r + 1, c, max);
		
		if(c > 0 && !visited[r][c - 1] && Math.abs(ar[r][c] - ar[r][c - 1]) <= max)
			op = op || helper(ar, visited, r, c - 1, max);
		
		if(c < ar[0].length - 1 && !visited[r][c + 1] && Math.abs(ar[r][c] - ar[r][c + 1]) <= max)
			op = op || helper(ar, visited, r, c + 1, max);
		
		return op;
	}

}
