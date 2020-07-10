import java.util.*;
public class Rain_Water_Trapping {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elemenst u want to enter :");
		
		int n = sc.nextInt();
		int ar[] = new int[n];
		System.out.println("Enter the elememts into the array :");
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		
		int res = findWaterTrapped(ar, n);
		
		System.out.println(res);
	}
	public static int findWaterTrapped(int ar[], int n) {
		
		if(n == 0)
			return 0;
		int mxl[] = findMxl(ar, n);
		int mxr[] = findMxr(ar, n);
		
		int sum = 0;
		for(int i = 0; i < n; i++) {
			
			sum += Math.min(mxl[i], mxr[i]) - ar[i];
		}
		return sum;
	}
	public static int[] findMxl(int ar[], int n) {
		
		int mxl[] = new int[n];
		
		mxl[0] = ar[0];
		
		for(int i = 1; i < n; i++) {
			
			mxl[i] = Math.max(mxl[i - 1], ar[i]);
		}
		return mxl;
	}
	
	public static int[] findMxr(int ar[], int n) {
		
		int mxr[] = new int[n];
		
		mxr[n - 1] = ar[n - 1];
		
		for(int i = n - 2; i >= 0; i --) {
			
			mxr[i] = Math.max(mxr[i + 1], ar[i]);
		}
		
		return mxr;
	}
}