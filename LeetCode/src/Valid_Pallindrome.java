//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//Note: For the purpose of this problem, we define empty string as valid palindrome.
//
//Example 1:
//
//Input: "A man, a plan, a canal: Panama"
//Output: true
//Example 2:
//
//Input: "race a car"
//Output: false
public class Valid_Pallindrome {

	public boolean isPalindrome(String s) {
        
        if(s == null) return false;
        if(s.length() == 0) return true;
        
        int i = 0, j = s.length() - 1;
        
        while(i < j){
            
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            
            if(!checkAlphanumeric(c1)){
                i ++;
                continue;
            }
            if(!checkAlphanumeric(c2)){
                j --;
                continue;
            }
            if(toUpperCase(c1) != toUpperCase(c2))
                return false;
            else{
                i ++;
                j --;
            }
        }
        return true;
    }
    private char toUpperCase(char c){
        
        if(c >= 96 && c <= 122){
            
            int n = c;
            n -= 32;
            return (char)n;
        }
        return c;
    }
    private boolean checkAlphanumeric(char c){
        
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))
            return true;
        return false;
    }
}
