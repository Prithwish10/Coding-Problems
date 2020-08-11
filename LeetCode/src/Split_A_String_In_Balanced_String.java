
public class Split_A_String_In_Balanced_String {

	public int balancedStringSplit(String s) {
        
        int window_end;
        
        int Ls = 0, Rs = 0;
        int maxSplit = 0;
        
        for(window_end = 0; window_end < s.length(); window_end++){
            
            if(s.charAt(window_end) == 'L')
                Ls ++;
            else if(s.charAt(window_end) == 'R')
                Rs ++;
            
            if(Ls == Rs){
                maxSplit ++;
                Ls = 0;
                Rs = 0;
            }
        }
        return maxSplit;
    }
}
