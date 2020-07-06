import java.util.Stack;
class Asteriod {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i : asteroids){
            
            //If stack is Empty || both are '+ve' || both are '-ve' || peek is                '-ve' and i is '+ve' -----> simply push i
            if(stack.isEmpty() || isNegative(stack.peek()) ||
                !isNegative(stack.peek()) && !isNegative(i))
                stack.add(i);
            //If stack.peek() is '+ve' && i is '-ve' then the asteroids will                   collide
            else {
                
                //Case-1 : When i is > stack.peek() then pop all the elemens                        from the top that are less then i and also the peek() should                    be +ve
                
                if(size(i) > size(stack.peek())){
                    
                    while(!stack.isEmpty() && !isNegative(stack.peek()) &&                                  size(i) > size(stack.peek()))
                        stack.pop();
                   
                    //After popping the elements now check if stack is empty or not || stack.peek() is '+ve or not'. If '+ve' then it means i mush be smaller then it so dont push i. Else if peek() is negative then push i
                    if(stack.isEmpty() || isNegative(stack.peek()))
                        stack.add(i); 
                 
                }
                 //Case-2 : When stack.peek() && i both are of same size and peek is 've' and i is '-ve' then both will exploide
                if(!stack.isEmpty() && size(stack.peek()) == size(i) && !isNegative(stack.peek()))
                    stack.pop();
                
            }
            
        }
        
        int ar[] = new int[stack.size()];
        
        for(int i = ar.length - 1; i >= 0; i--)
            ar[i] = stack.pop();
        return ar;
    }
    
    public boolean isNegative(int x){
        if(x < 0)
            return true;
        return false;
    }
    
    public int size(int x){
        
        return Math.abs(x);
    }
    public static void main(String args[]) {
    	
    	int ar[] = {5, 10, -5};
    	
    	Asteriod obj = new Asteriod();
    	int res[] = obj.asteroidCollision(ar);
    	
    	for(int i : res)
    		System.out.print(i+" ");
    }
}