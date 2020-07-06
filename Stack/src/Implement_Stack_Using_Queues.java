import java.util.Queue;
import  java.util.LinkedList;
class Implement_Stack_Using_Queues {

    /** Initialize your data structure here. */
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    
    public Implement_Stack_Using_Queues() {
        queue1 = new LinkedList<Integer>();
        queue2 = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        
        while(!queue1.isEmpty())
            queue2.add(queue1.poll());
        queue1.add(x);
        while(!queue2.isEmpty())
            queue1.add(queue2.poll());
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        
        if(queue1.isEmpty())
            return -1;
        return queue1.poll();
    }
    
    /** Get the top element. */
    public int top() {
        
        if(queue1.isEmpty())
            return -1;
        return queue1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(queue1.isEmpty())
            return true;
        return false;
    }
    public static void main(String args[]) {
    	
    	Implement_Stack_Using_Queues obj = new Implement_Stack_Using_Queues();
    	obj.push(1);
    	obj.push(2);
    	obj.push(3);
    	int param_2 = obj.pop();
    	System.out.println(param_2);
    	int param_3 = obj.top();
    	System.out.println(param_3);
    	boolean param_4 = obj.empty();
    	System.out.println(param_4);
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */