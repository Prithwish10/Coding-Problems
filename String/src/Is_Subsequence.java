
public class Is_Subsequence {

	public boolean isSubsequence(String s, String t) {
        
        if(s == null || t == null || (t.length() == 0 && s.length() != 0))
            return false;
        
        if(s.length() == 0)
            return true;
        
        int i = 0, j = 0;
        
        while(i < s.length() && j < t.length()){
            
            while(j < t.length() && s.charAt(i) != t.charAt(j))
                j ++;
            
            if(j == t.length())
                return false;
            
            i++;
            j ++;
        }
        if(i == s.length())
            return true;
        
        return false;
    }
}
