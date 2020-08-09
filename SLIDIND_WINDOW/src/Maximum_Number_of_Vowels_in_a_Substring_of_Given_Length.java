
public class Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length {

	public int maxVowels(String s, int k) {
        
        if(s == null || s.length() == 0)
            return 0;
        
        int max = 0;
        int count = 0;
        int i;
        
        for(i = 0; i < k; i++){
            
            if(isVowel(s.charAt(i)))
                count ++;
        }
        
        max = count;
        
        for(; i < s.length(); i++){
            
            if(isVowel(s.charAt(i - k)))
                count --;
            
            if(isVowel(s.charAt(i)))
                count ++;
            
            if(count > max){
                
                max = count;
            }
        }
        
        return max;
    }
    
    public static boolean isVowel(char c){
        
        if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }
}
