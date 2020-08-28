import java.util.Stack;

public class Remove_K_Digits {

	public String removeKdigits(String num, int k) {
        
        if(num == null && num.length() == 0)
            return "0";
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < num.length(); i++){
            
            char ch = num.charAt(i);
            
            if(stack.isEmpty())
                stack.add(ch);
            else{
                
                while(!stack.isEmpty() && stack.peek() - '0' > ch - '0' && k > 0){
                    stack.pop();
                    k --;
                }
                
                stack.add(ch);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        String s = "";
        
        while(!stack.isEmpty() && k > 0){
            stack.pop();
            k --;
        }
        
        while(!stack.isEmpty())
            sb.append(stack.pop());
        
        if(sb.length() == 0)
            return "0";
        
        s = sb.reverse().toString();
        int i = 0;
        
        while(i < s.length() && s.charAt(i) == '0')
            i ++;
        
        String res = "";
        
        for(; i < s.length(); i++)
            res += s.charAt(i);
        
        return res.length() == 0 ? "0" : res;
    }
}
