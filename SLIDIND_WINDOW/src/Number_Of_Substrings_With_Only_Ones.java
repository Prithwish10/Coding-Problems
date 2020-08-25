
public class Number_Of_Substrings_With_Only_Ones {

	public int numSub(String s) {
	      
        if(s == null || s.length() == 0)
            return 0;
        
        
        int left = 0, right = 0;
        long ans = 0;
        
        while(right < s.length()){
            
            while(right < s.length() && s.charAt(right) == '0'){
                right ++;
                left = right;
            }
            if(right == s.length())
                break;
            
            ans += (right - left) + 1;
            
            right ++;
        }
        return (int)(ans % 1000000007);
    }
}
