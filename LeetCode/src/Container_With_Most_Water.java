//Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). 
//n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
//Find two lines, which together with x-axis forms a container, such that the container contains the most water.
//
//Note: You may not slant the container and n is at least 2.
//Example:

//Input: [1,8,6,2,5,4,8,3,7]
//Output: 49

import java.util.Scanner;
public class Container_With_Most_Water {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elemenst u want to enter :");
		
		int n = sc.nextInt();
		int ar[] = new int[n];
		System.out.println("Enter the elememts into the array :");
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		
		int res = findMaxContainer(ar, n);
		
		System.out.println(res);
	}
	
	public static int findMaxContainer(int ar[], int n) {
		
		int mxl[] = maxGreaterLeft(ar, n);
		int mxr[] = maxGreaterRight(ar, n);
		
		int i = 0;
		int j = n - 1;
		int result = -1;
		
		while(i < j) {
			
			int height = Math.min(mxl[i], mxr[j]);
			int dis = Math.abs(j - i);
			int area = height * dis;
			result = Math.max(result, area);
			
			if(mxl[i] < mxr[j])
				i ++;
			else if(mxl[i] > mxr[j])
				j --;
			else {
				i++; j--;
			}
		}
		return result;
	}
	public static int[] maxGreaterLeft(int ar[], int n) {
		
		int mxl[] = new int[n];
		
		mxl[0] = ar[0];
		
		for(int i = 1; i < n; i++)
			mxl[i] = Math.max(ar[i], mxl[i - 1]);
		
		return mxl;
	}
	
	public static int[] maxGreaterRight(int ar[], int n) {
		
		int mxr[] = new int[n];
		
		mxr[n - 1] = ar[n - 1];
		
		for(int i = n - 2;i >= 0; i--)
			mxr[i] = Math.max(ar[i], mxr[i + 1]);
		
		return mxr;
	}
}
