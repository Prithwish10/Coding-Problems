import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class BFS {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of vertices :");
		int v = sc.nextInt();
		
		int matrix[][] = new int[v][v];
		
		System.out.println("Enter the matrix :");
		
		for(int i = 0; i < v; i++) {
			for(int j = 0; j < v; j++) {
				matrix[i][j] = sc.nextInt();
			}
			System.out.println();
		}
		
		System.out.println("Enter the sourse vertex :");
		int src = sc.nextInt();
		
		bfs(matrix, src, v);
	}
	
	public static void bfs(int matrix[][], int src, int v) {
		
		int visited[] = new int[v];
		
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(src);
		
		while(!queue.isEmpty()) {
			
			int temp = queue.poll();
			
			System.out.print(temp+" ");
			
			visited[temp] = 1;
			
			for(int i = 0; i < v; i++) {
				
				if(matrix[temp][i] == 1 && visited[i] != 1) {
					
					visited[i] = 1;
					queue.add(i);
				}
			}
		}
	}
}
