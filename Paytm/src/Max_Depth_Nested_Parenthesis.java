//We are given a string having parenthesis like below
//     “( ((X)) (((Y))) )”
//We need to find the maximum depth of balanced parenthesis, like 4 in above example. Since ‘Y’ is surrounded by 4 
//balanced parenthesis.
//If parenthesis are unbalanced then return -1.

//Input : S = "( a(b) (c) (d(e(f)g)h) I (j(k)l)m)";
//Output : 4
//
//Input : S = "( p((q)) ((s)t) )";
//Output : 3
//
//Input : S = "";
//Output : 0
//
//Input : S = "b) (c) ()";
//Output : -1 
//
//Input : S = "(b) ((c) ()"
//Output : -1 

import java.util.Scanner;
import java.util.Stack;

public class Max_Depth_Nested_Parenthesis {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the string :");
		String s = sc.nextLine();
		
		System.out.println(findMaxDepth(s));
		
		System.out.println(findDepth1(s));
	}
	//Time : O(n)
	//Space : O(n)
	public static int findMaxDepth(String s) {
		
		Stack<Character> stack = new Stack<Character>();
		
		int max = 0;
		
		for(int i = 0; i < s.length(); i++) {
			
			if(s.charAt(i) == '(')
				stack.add(s.charAt(i));
			
			else if(s.charAt(i) == ')') {
				
				if(stack.isEmpty())
					return -1;
				else
					stack.pop();
			}
			else
				max = Math.max(max, stack.size());
		}
		if(stack.size() == 0)
			return max;
		return -1;
	}
	//Time : O(n)
	//Space : O(1)
	public static int findDepth1(String s) {
		
		int current_max = 0;
		int global_max = 0;
		char temp = ' ';
		
		for(int i = 0; i < s.length(); i++) {
			
			temp = s.charAt(i);
			
			if(temp == '(')
				current_max += 1;
			
			else if(temp == ')') {
				if(current_max == 0)
					return -1;
				else
					current_max -= 1;
			}
			else
				global_max = Math.max(current_max, global_max);
		}
		if(current_max == 0)
			return global_max;
		return -1;
			
	}
}
