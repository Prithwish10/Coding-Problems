import java.util.HashSet;
import java.util.Set;

public class Longest_Substring_Without_Repeating_Characters {

	public int lengthOfLongestSubstring(String s) {
        
        int i=0,j=0,max=0;
        Set<Character> set = new HashSet<Character>();
        while(j<s.length()){
           
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                max = Math.max(set.size(),max);
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }
}
