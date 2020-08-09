
public class Longest_Repeating_Character_Replacement {

	public int characterReplacement(String s, int k) {
        
        int maxLen = 0;
        int window_start = 0;
        int window_end = 0;
        int max_count = 0;
        int char_count[] = new int[26];
        
        for(window_end = 0; window_end < s.length(); window_end ++){
            
            char_count[s.charAt(window_end) - 'A']++;
            int current_char_count =  char_count[s.charAt(window_end) - 'A'];
            max_count = Math.max(max_count, current_char_count);
            
            while(window_end - window_start - max_count + 1 > k){
                
                char_count[s.charAt(window_start) - 'A'] --;
                window_start ++;
            }
            
            maxLen = Math.max(maxLen, window_end - window_start + 1);
        }
        return maxLen;
    }
}
