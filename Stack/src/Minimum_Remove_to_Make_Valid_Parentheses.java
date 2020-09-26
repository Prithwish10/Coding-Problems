import java.util.Stack;

public class Minimum_Remove_to_Make_Valid_Parentheses {

	public String minRemoveToMakeValid(String s) {
        
        if(s == null || s.length() == 0)
            return "";
        
        Stack<Pair> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            
            char ch = s.charAt(i);
            
            if(ch == '('){
                stack.add(new Pair(ch, i));
                // sb.append(ch);
            }
            else if(ch == ')'){
                if(!stack.isEmpty() && stack.peek().key == '('){
                    //sb.append(ch);
                    stack.pop();
                }
                else
                    stack.add(new Pair(ch, i));
            }
           
        }
        
        String res = "";
        boolean ar[] = new boolean[s.length()];
        
        while(!stack.isEmpty()){
            
            Pair p = stack.pop();
            int index = p.value;
            
            ar[index] = true;
        }
        for(int i = 0; i < s.length(); i++){
            
            if(!ar[i]){
                
                res += s.charAt(i);
            }
        }
        return res;
    }
	//**************** OR ***********************
	public String minRemoveToMakeValid1(String s) {
        
        if(s == null || s.length() == 0)
            return "";
        
        Stack<Pair> stack = new Stack<>();
        
        char ch[] = s.toCharArray();
        
        for(int i = 0; i < ch.length; i++){
            
            if(ch[i] == '('){
                stack.add(new Pair(ch[i], i));
            }
            else if(ch[i] == ')'){
                if(stack.isEmpty()){
                    ch[i] = ' ';
                }
                else{
                    if(stack.peek().key == '('){
                        stack.pop();
                    }
                }
            }
        }
        
        while(!stack.isEmpty()){
            
            ch[stack.peek().value] = ' ';
            stack.pop();
        }
        
        String res = "";
        
        for(int i = 0; i < ch.length; i++){
            if(ch[i] != ' ')
                res += ch[i];
        }
        return res;
    }
}
class Pair{
    
    char key;
    int value;
    Pair(char key, int value){
        this.key = key;
        this.value = value;
    }
}
