import java.util.List;

public class Longest_Word_Through_Deleating {

	public String findLongestWord(String s, List<String> d) {
        
        String res = "";
        int n = s.length(), len = 0;
        
        for(int k = 0; k < d.size(); k++){
            
            String str = d.get(k);
            
            int i = 0, j = 0;
            
            while(i < n && j < str.length()){
                
                if(s.charAt(i) == str.charAt(j)){
                    i ++;
                    j ++;
                }
                else{
                    i ++;
                }
            }
            if(j == str.length()){
                if(j > len){
                    len = j;
                    res = str;
                }
                else if(j == len){
                    if(str.compareTo(res) < 0)
                        res = str;
                }
            }
        }
        return res;
    }
}
