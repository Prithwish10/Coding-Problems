import java.util.Arrays;

public class Permutation_In_String {

	public boolean checkInclusion(String s1, String s2) {
        
        if(s1 == null || s2 == null || s1.length() > s2.length()) return false;
        
        char ch[] = s1.toCharArray();
        Arrays.sort(ch);
        String s = new String(ch);
        
        int n = s.length();
        
        for(int i = 0; i <= s2.length() - s1.length(); i ++){
            
            String str = s2.substring(i, i + n);
            ch = str.toCharArray();
            Arrays.sort(ch);
            if(new String(ch).equals(s))
                return true;
        }
        return false;
    }
	//Efficient Approach
	public boolean checkInclusion1(String s1, String s2) {
        
        if(s1 == null || s2 == null || s1.length() > s2.length()) return false;
        
        int ar[] = new int[26];
        int i = 0, n = s1.length();
        
        for(i = 0; i < s1.length(); i++)
            ar[s1.charAt(i) - 'a'] ++;
        
        for(i = 0; i < s1.length(); i++){
            ar[s2.charAt(i) - 'a'] --;
        }
        
        if(isAllZero(ar))
            return true;
        
        for(; i < s2.length(); i++){
            ar[s2.charAt(i - n) - 'a'] ++;
            ar[s2.charAt(i) - 'a'] --;
            if(isAllZero(ar))
                return true;
        }
        return false;
    }
    public boolean isAllZero(int ar[]){
        
        for(int i : ar)
            if(i != 0)
                return false;
        return true;
    }
}
