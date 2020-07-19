import java.util.Stack;

class ValidParenthesis {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++){
            
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.add(s.charAt(i));
            }
            else{
                if(stack.isEmpty())
                    return false;
                
                else if(s.charAt(i) == ')' && stack.peek() == '(')
                    stack.pop();
                
                else if(s.charAt(i) == '}' && stack.peek() == '{')
                    stack.pop();
                
                else if(s.charAt(i) == ']' && stack.peek() == '[')
                    stack.pop();
                else
                    return false;
            }
        }
        if(stack.isEmpty())
            return true;
        
        return false;
    }
}

