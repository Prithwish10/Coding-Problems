import java.util.Scanner;
import java.util.Stack;
public class Maximum_Rectangular_Area_Histogram {

	static class Object{
		
		int ele, index;
		Object(int ele, int inedx){
			this.ele = ele;
			this.index = inedx;
		}
	}
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements u want to enter :");
		
		int n = sc.nextInt();
		
		int ar[] = new int[n];
		
		System.out.println("Enter the elements into the array :");
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		
		findMaxArea(ar, n);
	}
	public static void findMaxArea(int ar[], int n) {
		
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
		
		System.out.println(max);
	}
	public static int[] findNextSmallerRight(int ar[], int n) {
		
		Stack<Object> stack = new Stack<>();
        int res[] = new int[n];
        int index = n - 1;
        
        for(int i = n - 1; i >= 0; i--){
            
            int cur = ar[i];
            
            while(!stack.isEmpty() && stack.peek().ele >= cur)
                stack.pop();
            
            if(stack.isEmpty())
                res[index --] = n;
            
            else
                res[index --] = stack.peek().index;
            
            stack.add(new Object(cur, i));
        }
        return res;
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