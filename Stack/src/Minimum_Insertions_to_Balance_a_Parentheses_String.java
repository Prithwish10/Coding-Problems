import java.util.Stack;

public class Minimum_Insertions_to_Balance_a_Parentheses_String {
	public int minInsertions(String s) {
        
        if(s == null || s.length() == 0)
            return 0;
        
        Stack<Character> stack = new Stack<>();
        int ans = 0, i = 0, n = s.length();
        
        while(i < n){
            
            char ch = s.charAt(i);
            
            if(s.charAt(i) == '('){
                stack.add('(');
                i++;
            }
            else{
                
                if(!stack.isEmpty()){
                    
                    if(i + 1 < n && s.charAt(i + 1) == ')'){   // ())
                        stack.pop();
                        i += 2;
                    }
                    else if(i + 1 >= n || i + 1 < n && s.charAt(i + 1) != ')'){ // ()
                        stack.pop();
                        ans ++;
                        i ++;
                    }
                }
                else{
                    
                    if(i + 1 < n && s.charAt(i + 1) == ')'){
                        ans ++;
                        i += 2;
                    }
                    else if(i + 1 >= n || i + 1 < n && s.charAt(i + 1) != ')'){
                        ans += 2;
                        i ++;
                    }
                }
            }
        }
        while(!stack.isEmpty()){
            ans += 2;
            stack.pop();
        }
        return ans;
    }
}
