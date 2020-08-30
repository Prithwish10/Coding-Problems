import java.util.HashMap;
import java.util.Map;

//Given a string S and a string T, find the minimum window in S which will 
//contain all the characters in T in complexity O(n).
//
//Example:
//
//Input: S = "ADOBECODEBANC", T = "ABC"
//Output: "BANC"
public class Minimum_Window_Substring {

	public String minWindow(String s, String t) {
        
        if(s == null || t == null || t.length() > s.length())
            return "";
        
        Map<Character, Integer> textWindow = new HashMap<>();
        
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            textWindow.put(c, textWindow.getOrDefault(c, 0) + 1);
        }
        
        Map<Character, Integer> strWindow = new HashMap<>();
        
        int l = 0, r = 0, expected = 0, min = Integer.MAX_VALUE, start = -1, end = -1;
        
        while(r < s.length()){
            
            char c = s.charAt(r);
            
            strWindow.put(c, strWindow.getOrDefault(c, 0) + 1);
            
            if(textWindow.containsKey(c) && textWindow.get(c).intValue() == strWindow.get(c).intValue())      
                expected ++;
            
            while((l < r || (l < s.length() && s.charAt(l) == s.charAt(r))) && expected == textWindow.size()){
                
                if(r - l + 1 < min){
                    System.out.println(l+" "+r);
                    start = l;
                    end = r;
                    min = r - l + 1;
                }
                
                char ch = s.charAt(l);
                
                strWindow.put(ch, strWindow.get(ch) - 1);
                
                if(textWindow.containsKey(ch) && strWindow.get(ch).intValue() < textWindow.get(ch).intValue())   
                    expected --;
                
                l ++;
            }
            
            r ++;
        }
        
        String res = "";
        
        if(min == Integer.MAX_VALUE)
            return "";
        
        for(int i = start; i <= end; i++)
            res += s.charAt(i);
        
        return res;
    }
}
