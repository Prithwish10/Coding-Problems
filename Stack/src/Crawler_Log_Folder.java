import java.util.Stack;

public class Crawler_Log_Folder {

public int minOperations(String[] logs) {
        
        if(logs == null) return 0;
        
        Stack<String> stack = new Stack<>();
        
        for(String s : logs){
            
            if(s.equals("./"))
                continue;
            else if(s.equals("../")){
                if(!stack.isEmpty())
                    stack.pop();
            }
            else{
                stack.add(s);
            }
        }
        return stack.size();
    }
}
