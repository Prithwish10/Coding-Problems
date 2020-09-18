import java.util.Scanner;
import java.util.Stack;

public class Expression_Contains_Redundant_Braces_OrNot {

	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s = sc.next();
		
		int res = isRedundencyExist(s);
		
		System.out.println(res);
	}
	private static int isRedundencyExist(String s){
	    
	    if(s == null || s.length() == 0)
	        return 0;
	        
	    Stack<Character> stack = new Stack<>();
	    boolean opr = false;
	    
	    for(int i = 0; i < s.length(); i++){
	        
	        char ch = s.charAt(i);
	        
	        if(ch != ')')
	            stack.add(ch);
	        else{
	            
	            opr = false;
	            
	            while(!stack.isEmpty() && stack.peek() != '('){
	                
	                if(stack.peek() == '+' || stack.peek() == '-' || stack.peek() == '*' || stack.peek() == '/')
	                    opr = true;
	                    
	                stack.pop();
	            }
	            
	            if(opr == false)
	                return 1;
	                
	            stack.pop();
	        }
	    }
	    return 0;
	}
}
