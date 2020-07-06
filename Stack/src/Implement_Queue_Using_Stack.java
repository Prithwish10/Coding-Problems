import java.util.Stack;

class Implement_Queue_Using_Stack {

    /** Initialize your data structure here. */
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public Implement_Queue_Using_Stack() {
        
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
     
        if(!stack2.isEmpty())
            stack1.add(stack2.pop());
        stack1.add(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        
        if(stack1.isEmpty() && stack2.isEmpty())
            return -1;
        while(!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }
        return stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        
        if(stack1.isEmpty() && stack2.isEmpty())
            return -1;
        while(!stack1.isEmpty()){
            stack2.add(stack1.pop());
        }
        return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(stack1.isEmpty() && stack2.isEmpty())
            return true;
        return false;
    }
    public static void main(String args[]) {
    	
    	Implement_Queue_Using_Stack obj = new Implement_Queue_Using_Stack();
    	 obj.push(1);
    	 obj.push(2);
    	 int param_2 = obj.pop();
    	 System.out.println(param_2);
    	 int param_3 = obj.peek();
    	 System.out.println(param_3);
    	 boolean param_4 = obj.empty();
    	 System.out.println(param_4);
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */