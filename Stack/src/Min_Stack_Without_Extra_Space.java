import java.util.Stack;

public class Min_Stack_Without_Extra_Space {

	Stack<Integer> stack;
    int min;
    
    public Min_Stack_Without_Extra_Space() {
        stack = new Stack<Integer>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        
        if(stack.isEmpty()){
            min = x;
            stack.add(x);
        }
        else 
        {
            if(x < min){
                
                stack.add((2 * x) - min);
                min = x; 
            }
            else{
                stack.add(x);
            }
        }
    }
    
    public void pop() {
        
        if(stack.isEmpty())
            System.out.println("Empty Stack !!");
        
        
        else if(stack.peek() < min){
            
            min = (2 * min) - stack.peek();
            
            stack.pop();
        }
        else{
            stack.pop();
        }
    }
    
    public int top() {
        
        if(stack.isEmpty())
            return -1;
        else if(stack.peek() < min)
            return min;
        else
            return stack.peek();
    }
    
    public int getMin() {
        if(stack.isEmpty())
            return -1;
        else
            return min;
    }
}
