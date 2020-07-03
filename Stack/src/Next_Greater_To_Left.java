import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Next_Greater_To_Left {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements u want to enter :");
		int n =sc.nextInt();
		int ar[] = new int[n];
		if(n == 0)
			System.out.println("No elements in the array !!");
		else {
			System.out.println("Enter the elemenst into the array :");
			for(int i = 0; i < n; i++)
				ar[i] = sc.nextInt();
		
			nextGreater(ar, n);
		}
	}
	public static void nextGreater(int ar[], int n) {
		
		Stack<Integer> stack = new Stack<Integer>();
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < n; i++) {
			
			int cur = ar[i];
			
			while(!stack.isEmpty() && stack.peek() < cur)
				stack.pop();
			
			if(stack.isEmpty())
				list.add(-1);
			else
				list.add(stack.peek());
			
			stack.add(cur);
			
		}
		//Collections.reverse(list);
		
		System.out.print(list);
	}
}
