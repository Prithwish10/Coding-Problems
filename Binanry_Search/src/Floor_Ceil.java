import java.util.Scanner;

public class Floor_Ceil {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements :");
		int n = sc.nextInt();
		
		int ar[] = new int[n];
		System.out.println("Enter the elements :");
		for(int i = 0; i < n; i ++)
			ar[i] = sc.nextInt();
		
		System.out.println("Enter the target element :");
		
		int key = sc.nextInt();
		
		int res[] = findFloorCeil(ar, n, key);
		
		for(int i : res)
			System.out.print(i+" ");
	}
	public static int[] findFloorCeil(int ar[], int n, int key) {
		
		int L = 0;
		int H = n - 1;
		
		int floor = -1;
		int ceil = -1;
		
		while(L <= H) {
			
			int mid = L + (H - L)/2;
			
			if(ar[mid] == key)
				return new int[] {mid};
			
			else if(ar[mid] < key) {
				
				floor = mid;
				L = mid + 1;
			}
			else {
				
				ceil = mid;
				H = mid - 1;
			}
		}
			
		return new int[]{floor, ceil};
	}
}
