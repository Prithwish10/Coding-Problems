import java.util.*;
public class MinStack_Using_ExtraSpace {

	Stack<Integer> stack;
	Stack<Integer> minStack;
	
	public MinStack_Using_ExtraSpace() {
		
		stack = new Stack<Integer>();
		minStack = new Stack<Integer>();
		
	}
	
	public void push(int x) {
		
		if(stack.isEmpty()) {
			stack.add(x);
			minStack.add(x);
		}
			
		else {
			
			if(x <= minStack.peek())
				minStack.add(x);
			
			stack.add(x);
		}
	}
	
	public int pop() {
		
		if(stack.isEmpty())
			return Integer.MIN_VALUE;
		else {
			
			if(stack.peek() == minStack.peek())
				minStack.pop();
			int val = stack.pop();
			
			return val;
		}
	}
	
	public int getMin() {
		
		if(stack.isEmpty())
			return Integer.MIN_VALUE;
		else
			return minStack.peek();
	}
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enetr the number of elements :");
		int n = sc.nextInt();
		
		int ar[] = new int[n];
		
		System.out.println("Enter the elements into the array :");
		
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		
		MinStack_Using_ExtraSpace min = new MinStack_Using_ExtraSpace();
		
		//System.out.println(min.getMin());
		for(int i : ar) {
			min.push(i);
		
			System.out.println(min.getMin());
		}
		
	}
}
