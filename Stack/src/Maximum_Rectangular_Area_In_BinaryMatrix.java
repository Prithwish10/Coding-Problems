import java.util.*;

public class Maximum_Rectangular_Area_In_BinaryMatrix {

	static class Object{
		
		int ele, index;
		Object(int ele, int inedx){
			this.ele = ele;
			this.index = inedx;
		}
	}
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of Rows u want to enter :");
		
		int row = sc.nextInt();
		
		System.out.println("Enter the number of Columns u want to enter :");
		
		int col = sc.nextInt();
		
		int ar[][] = new int[row][col];
		
		System.out.println("Enter the elements into the array :");
		for(int i = 0; i < row; i++) {

			for(int j = 0; j < col; j ++) {
				
				ar[i][j] = sc.nextInt();
			}
		}
		
		findMaxArea(ar, row, col);
	}
	public static void findMaxArea(int ar[][], int r, int c) {
		
		int temp[] = new int[c];
		int index = 0;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < r; i++) {
			index = 0;
			for(int j = 0; j < c; j++) {
				
				if(ar[i][j] == 0)
					temp[index ++] = 0;
				else
					temp[index ++] += ar[i][j];
			}
			int res = findMaxArea(temp, c);
			max = Math.max(max, res);
		}
		System.out.println(max);
	}
	public static int findMaxArea(int ar[], int n) {
		
		int nsr[] = findNextSmallerRight(ar, n);
		
		int nsl[] = findNextSmallerLeft(ar, n);
		
		int width[] = new int[n];
		
		for(int i = 0; i < n; i ++) {
			width[i] = (nsr[i] - nsl[i] - 1) * ar[i];
		}
		
		int max = 0;
		
		for(int i : width)
			if(max < i)
				max = i;
		
		return max;
	}
	public static int[] findNextSmallerRight(int ar[], int n) {
		
		int nsr[] = new int[n];
		
		Stack<Object> stack = new Stack<>();
		
		int index = 0;
		
		for(int i = n - 1; i >= 0; i --) {
			
			int cur = ar[i];
			
			while(!stack.isEmpty() && stack.peek().ele >= cur)
				stack.pop();
			
			if(stack.isEmpty())
				nsr[index ++] = n;
			else
				nsr[index ++] = stack.peek().index;
			
			stack.add(new Object(cur, i));
		}
		
		for(int i = 0; i < n/2; i++) {
			int temp = nsr[i];
			nsr[i] = nsr[n - i - 1];
			nsr[n - i - 1] = temp;
		}

		return nsr;
	}
	
	public static int[] findNextSmallerLeft(int ar[], int n) {
		
		int nsl[] = new int[n];
		
		Stack<Object> stack = new Stack<>();
		
		int index = 0;
		
		for(int i = 0; i < n; i ++) {
			
			int cur = ar[i];
			
			while(!stack.isEmpty() && stack.peek().ele >= cur)
				stack.pop();
			
			if(stack.isEmpty())
				nsl[index ++] = -1;
			else
				nsl[index ++] = stack.peek().index;
			
			stack.add(new Object(cur, i));
		}

		return nsl;
	}
}
