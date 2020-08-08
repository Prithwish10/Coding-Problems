//Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and 
//removing them causing the left and the right side of the deleted substring to concatenate together.
//
//We repeatedly make k duplicate removals on s until we no longer can.
//
//Return the final string after all such duplicate removals have been made.
//
//It is guaranteed that the answer is unique.
//
//Example 1:
//
//Input: s = "abcd", k = 2
//Output: "abcd"
//Explanation: There's nothing to delete.
//Example 2:
//
//Input: s = "deeedbbcccbdaa", k = 3
//Output: "aa"
//Explanation: 
//First delete "eee" and "ccc", get "ddbbbdaa"
//Then delete "bbb", get "dddaa"
//Finally delete "ddd", get "aa"

import java.util.Stack;

public class Remove_All_Adjacent_Duplicates {
	
	class Pair{
	    
	    char key;
	    int value;
	    Pair(char key, int value){
	        this.key = key;
	        this.value = value;
	    }
	}

	 public String removeDuplicates(String s, int k) {
	        
	        if(s == null || s.length() == 0)
	            return "";
	        if(k > s.length())
	            return s;
	        
	        Stack<Pair> stack = new Stack<>();
	        
	        for(int i = 0; i < s.length(); i++){
	            
	            char ch = s.charAt(i);
	            
	            if(stack.isEmpty())
	                stack.add(new Pair(ch, 1));
	            else{
	                
	                if(stack.peek().key == ch)
	                    stack.add(new Pair(ch, stack.peek().value + 1));
	                else
	                    stack.add(new Pair(ch, 1));
	            }
	            if(stack.peek().value == k){
	                
	                for(int j = 0; j < k; j++)
	                    stack.pop();
	            }
	        }
	        StringBuilder sb = new StringBuilder();
	        
	        while(!stack.isEmpty())
	            sb.append(stack.pop().key);
	        
	        return sb.reverse().toString();
	   	}
}
