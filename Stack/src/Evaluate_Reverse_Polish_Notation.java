import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation {

	public int evalRPN(String[] tokens) {
        
        if(tokens == null || tokens.length == 0)
            return 0;
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i < tokens.length; i++){
            
            String s = tokens[i];
            
            if(s.equals("+")){
                int b = stack.pop();
                int a = stack.pop();
                int res = a + b;
                stack.add(res);
            }
            else if(s.equals("-")){
                int b = stack.pop();
                int a = stack.pop();
                int res = a - b;
                stack.add(res);
            }
            else if(s.equals("*")){
                int b = stack.pop();
                int a = stack.pop();
                int res = a * b;
                stack.add(res);
            }
            else if(s.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                int res = a / b;
                stack.add(res);
            }
            else{
                stack.add(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}
