import java.util.*;
public class Next_Smallest_To_Right {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements do u want to enter :");
		int n = sc.nextInt();
		
		int ar[] = new int[n];
		
		System.out.println("Enter the elements :");
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		
		nextSmaller(ar, n);
	}
	public static void nextSmaller(int ar[], int n) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = n - 1; i >= 0; i--) {
			
			int cur = ar[i];
			
			while(!stack.isEmpty() && stack.peek() > cur)
				stack.pop();
			
			if(stack.isEmpty())
				list.add(-1);
			
			else
				list.add(stack.peek());
			
			stack.add(cur);
		}
		System.out.print(list);
	}
}
