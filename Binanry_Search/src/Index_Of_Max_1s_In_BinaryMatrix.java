import java.util.Scanner;
public class Index_Of_Max_1s_In_BinaryMatrix {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the row and col :");
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		int ar[][] = new int[r][c];
		
		System.out.println("Enter the elements  :");
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++)
				ar[i][j] = sc.nextInt();
			System.out.println();
		}
		
		int maxIndex = findIndex(ar, r, c);
		System.out.println(maxIndex);
	}
	public static int findIndex(int ar[][], int r, int c) {
		
		int max = Integer.MIN_VALUE;
		
		int maxIndex = -1;
		
		for(int i = 0; i < r; i++) {
			
			int start = -1;
			int L = 0;
			int H = c - 1;
			while(L <= H) {
				
				int mid = L + (H - L)/2;
				if(ar[i][mid] == 1) {
					start = mid;
					H = mid - 1;
				}
				else {
					L = mid + 1;
				}
			}
			
			if(start != -1 && c - start > max) {
				maxIndex = i;
				max = c - start;
			}
		}
		return maxIndex;
	}
}
