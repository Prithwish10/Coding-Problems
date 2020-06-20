
public class Row_with_Max_1s {

	public static void main(String args[]) {
		
		int ar[][] = {{0, 1, 1, 1},
					  {0, 0, 1, 1},
					  {1, 1, 1, 1},
					  {0, 0, 0, 0}};
		
		findMax(ar, 4, 4);
	}
	public static void findMax(int ar[][], int n, int m) {
		
		int Mrow = -1;
		int MCount = -1;
		
		for(int i = 0; i < n; i++) {
			
			int L = 0;
			int H = m - 1;
			int res = -1;
			
			while(L <= H) {
				
				int mid = L + (H - L)/2;
				
				if(ar[i][mid] == 1) {
					
					res = mid;
					H = mid - 1;
				}
				else {
					L = mid + 1;
				}
			}
			//System.out.println(res);
			
			if(res != -1 && m - res > MCount) {
				Mrow = i;
				MCount = m - res;
				//System.out.println(Mrow);
			}
		}
		System.out.println(Mrow);
	}
}
