import java.util.Scanner;

public class ClosestPosition {
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
		
		int res = findFloorCeil(ar, n, key);
		
		System.out.println("Closest Element to target :"+ar[res]+" at Position :"+ res);
		
		System.out.println(findFloorCeil(ar, n, key));
	}
	public static int findFloorCeil(int ar[], int n, int key) {
		
		int L = 0;
		int H = n - 1;
		
		while(L <= H) {
			
			int mid = L + (H - L)/2;
			
			if(ar[mid] == key)
				return mid;
			
			else if(ar[mid] < key) {
				L = mid + 1;
			}
			else {
				H = mid - 1;
			}
		}
			
		if(H < 0)
            return L;
        
        if(L >= n)
            return H;
		
		int hiDiff = Math.abs(ar[H] - key);
		int lowDiff = Math.abs(ar[L] - key);
		
		return hiDiff <= lowDiff ? H : L;
	}
}
