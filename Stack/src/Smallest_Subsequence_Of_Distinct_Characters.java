//Return the lexicographically smallest subsequence of s that contains all 
//the distinct characters of s exactly once. In the sequence the relative order
//of the characters in s should be maintained
//               OR
//Given a string s, remove duplicate letters so that every letter appears once and only once. 
//You must make sure your result is the smallest in lexicographical order among all possible results.
//And the relative position of the characters in s should be maintained in result

//Example 1:
//
//Input: s = "bcabc"
//Output: "abc"
//Example 2:
//
//Input: s = "cbacdcbc"
//Output: "acdb"

import java.util.*;
public class Smallest_Subsequence_Of_Distinct_Characters {

	public String smallestSubsequence(String s) {
        
        if(s == null || s.length() == 0)
            return "";
    
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
        boolean visited[] = new boolean[26];
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            
            char ch = s.charAt(i);
            
            if(stack.isEmpty()){
                stack.add(ch);
                map.put(ch, map.get(ch) - 1);
                visited[ch - 97] = true;
            }
            else{
                if(!visited[ch - 97]){
                    
                    while(!stack.isEmpty() && ch < stack.peek() && map.get(stack.peek()) > 0){
                        visited[stack.peek() - 97] = false;
                        stack.pop();
                    }
                    stack.add(ch);
                    map.put(ch, map.get(ch) - 1);
                    visited[ch - 97] = true;
                }
                else{
                    map.put(ch, map.get(ch) - 1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    
    }
}
