
public class Number_Of_Substrings_With_Only_1s {

	public int numSub(String s) {
	      
        /*if(s == null || s.length() == 0)
            return 0;
        
        long n = 0, res = 0;
        
        for(int i = 0; i < s.length(); i++){
            
            if(s.charAt(i) == '0'){
                
                res += (n * (n+1))/2;
                n = 0;
            }
            else
                n ++;
        }
        res += (n * (n+1))/2;
        return (int)(res%1000000007);*/
        
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
