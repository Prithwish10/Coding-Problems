import java.util.Stack;

public class Decode_String {

	public String decodeString(String s) {
        
        if(s == null || s.length() == 0)
            return "";
        
        Stack<Integer> int_stack = new Stack<>();
        Stack<String> str_stack = new Stack<>();
        
        String res = "";
        
        int ptr = 0;
        
        while(ptr < s.length()){
            
            char curr = s.charAt(ptr);
            
            if(Character.isDigit(curr)){
                
                int num = 0;
                
                while(Character.isDigit(s.charAt(ptr))){
                    num = num * 10 + s.charAt(ptr) - '0';
                    ptr ++;
                }
                
                int_stack.add(num);
            }
            else if(curr == '['){
                
                str_stack.add(res);
                res = "";
                ptr ++;
            }
            else if(curr == ']'){
                
                StringBuilder sb = new StringBuilder(str_stack.pop());
                int count = int_stack.pop();
                
                for(int i = 1; i <= count; i++)
                    sb.append(res);
                
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
