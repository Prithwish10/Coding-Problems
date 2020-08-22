import java.util.Stack;

public class Reverse_Substrings_Between_Each_Pair_of_Parentheses {

	public String reverseParentheses(String s) {
        
        Stack<String> stack = new Stack<>();
        
        int ptr = 0;
        
        String res = "";
        
        while(ptr < s.length()){
            
            char curr = s.charAt(ptr);
            
            if(curr == '('){
                
                stack.add(res);
                res = "";
                ptr ++;
            }
            else if(curr == ')'){
                
                StringBuilder sb = new StringBuilder(stack.pop());
                StringBuilder sb_res = new StringBuilder(res);
                
                sb.append(sb_res.reverse());
                
                res = sb.toString();
                ptr ++;
            }
            else{
                
                res += curr;
                ptr ++;
            }
        }
        return res;
    }
}
