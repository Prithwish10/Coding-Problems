//Given a string s and an array of integers cost where cost[i] is the cost of deleting the character i in s.
//
//Return the minimum cost of deletions such that there are no two identical letters next to each other.
//
//Notice that you will delete the chosen characters at the same time, in other words, after deleting a character, the costs of deleting other characters will not change.
//
// 
//
//Example 1:
//
//Input: s = "abaac", cost = [1,2,3,4,5]
//Output: 3
//Explanation: Delete the letter "a" with cost 3 to get "abac" (String without two identical letters next to each other).
//Example 2:
//
//Input: s = "abc", cost = [1,2,3]
//Output: 0
//Explanation: You don't need to delete any character because there are no identical letters next to each other.

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
