import java.util.Stack;

public class Make_The_String_Great {

	public String makeGood(String s) {
        
        if(s == null || s.length() == 0)
            return "";
        
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++){
            
            char ch = s.charAt(i);
            
            if(stack.isEmpty())
                stack.add(ch);
            else{
                
                if((int)ch + 32 == (int)stack.peek() || (int)ch - 32 == (int)stack.peek()){
                    stack.pop();
                }
                else
                    stack.add(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty())
            sb.append(stack.pop());
        
        return sb.reverse().toString();
	}
}
