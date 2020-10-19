import java.util.Stack;

public class Design_Browser_History {

	Stack<String> stack1 = new Stack<String>();
    Stack<String> stack2 = new Stack<String>();
    
    public Design_Browser_History(String homepage) {
        
        stack1.add(homepage);
    }
    
    public void visit(String url) {
        
        while(!stack2.isEmpty())
            stack2.pop();
        
        stack1.add(url);
    }
    
    public String back(int steps) {
        
        while(steps != 0 && stack1.size() > 1){
            
            stack2.add(stack1.pop());
            steps --;
        }
        return stack1.peek();
    }
    
    public String forward(int steps) {
        
        while(!stack2.isEmpty() && steps != 0){
            stack1.add(stack2.pop());
            steps --;
        }
        return stack1.peek();
    }
}
