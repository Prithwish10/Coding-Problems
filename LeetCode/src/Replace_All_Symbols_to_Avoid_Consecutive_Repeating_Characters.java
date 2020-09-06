import java.util.Stack;

//Given a string s containing only lower case English letters and the '?' character, convert all the '?' characters into lower case letters such that the final string does not contain any consecutive repeating characters. You cannot modify the non '?' characters.
//
//It is guaranteed that there are no consecutive repeating characters in the given string except for '?'.
//
//Return the final string after all the conversions (possibly zero) have been made. If there is more than one solution, return any of them. It can be shown that an answer is always possible with the given constraints.
//
// 
//
//Example 1:
//
//Input: s = "?zs"
//Output: "azs"
//Explanation: There are 25 solutions for this problem. From "azs" to "yzs", all are valid. Only "z" is an invalid modification as the string will consist of consecutive repeating characters in "zzs".
//Example 2:
//
//Input: s = "ubv?w"
//Output: "ubvaw"
//Explanation: There are 24 solutions for this problem. Only "v" and "w" are invalid modifications as the strings will consist of consecutive repeating characters in "ub
public class Replace_All_Symbols_to_Avoid_Consecutive_Repeating_Characters {

	public String modifyString(String s) {
        
        if(s == null || s.length() == 0)
            return "";
        
        Stack<Character> stack = new Stack<>();
        
        int i = 0, n = s.length();
        
        while(i < n){
            
            char ch = s.charAt(i);
            
            if(ch == '?'){
                
                if(stack.isEmpty() && i + 1 < n && s.charAt(i + 1) != '?'){                // ?ab
                    
                    for(char c = 'a'; c <= 'z'; c ++){
                        
                        if(s.charAt(i + 1) != c){
                            stack.add(c);
                            break;
                        }
                    }   
                }
                
                else if(stack.isEmpty() && (i + 1 >= n || s.charAt(i + 1) == '?')){          // ??ab
                    stack.add('a');
                }
                
                else if(!stack.isEmpty() && (i + 1 >= n || s.charAt(i + 1) == '?')){        // ab??
                    
                    for(char c = 'a'; c <= 'z'; c ++){
                        
                        if(stack.peek() != c){
                            stack.add(c);
                            break;
                        }
                    }
                }
                else if(!stack.isEmpty() && i + 1 < n && s.charAt(i + 1) != '?'){           // ab?cv
                    
                    for(char c = 'a'; c <= 'z'; c ++){
                        
                        if(stack.peek() != c && s.charAt(i + 1) != c){
                            stack.add(c);
                            break;
                        }
                    }
                }
                i++;
            }
            else{
                stack.add(ch);
                i++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stack.isEmpty()){
            
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
