import java.util.*;
public class Unique_Morse_Code_Word {

	 public int uniqueMorseRepresentations(String[] words) {
	        
	        String s[] = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
	        
	        
	        String res = "";
	        
	        Set<String> set = new HashSet<>();
	        
	        for(String str : words){
	            
	            for(int i = 0; i < str.length(); i++){
	                char c = str.charAt(i);
	                
	                res += s[c - 'a'];
	                
	            }
	            
	            set.add(res);
	            
	            res = "";
	        }
	        return set.size();
	    }
}
