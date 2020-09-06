import java.util.Stack;

public class Minimum_Deletion_Cost__to_Avoid_Repeating_Characters {

	public int minCost(String s, int[] cost) {
        
        Stack<Integer> stack = new Stack<>();
        
        int n = s.length(), min, ans = 0, c;
        
        for(int i = 0; i < n;){
            
            char ch = s.charAt(i);
            
            int j = i + 1;
            
            stack.add(i);
                
            while(j < s.length() && s.charAt(j) == ch){
                
                if(cost[stack.peek()] > cost[j]){
                    
                    ans += cost[j];
                    
                }
                else{
                
                    ans += cost[stack.peek()];
                   
                    stack.pop();
                    stack.add(j);
                }
                j++;
            }
            
            while(!stack.isEmpty())
                stack.pop();
            
            i = j;
         
        }
        return ans;
    }
}
