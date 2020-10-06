import java.util.ArrayList;
import java.util.List;

public class Rearrange_Spaces_Between_Words {

	public String reorderSpaces(String text) {
        
        if(text == null || text.length() == 0) return "";
        
        String res = "";
        int count = 0, i = 0, n = text.length(), j = n - 1;
        String word = "";
        List<String> list = new ArrayList<>();
        
        while(i < n && text.charAt(i) == ' '){
            count ++;
            i++;
        }
        while(j >= 0 && text.charAt(j) == ' '){
            count ++;
            j --;
        }
        
        while(i <= j){
            
            if(text.charAt(i) != ' '){
                word += text.charAt(i);
            }
            else{
                count ++;
                
                if(!word.equals("")){
                    list.add(word);
                    word = "";
                }
            }
            i ++;
        }
        list.add(word);
        
        int gap = list.size() != 1 ? count / (list.size() - 1) : 0;
        int extra = list.size() != 1 ? count % (list.size() - 1) : count;
        
        i = 0;
        
        while(i < list.size()){
            
            res += list.get(i);
            
            if(i == list.size() - 1)
                break;
            j = 1;
            
            while(j <= gap){
                res += " ";
                j ++;
            }
            i ++;
            
        }
        j = 1;
        while(j <= extra){
            res += " ";
            j ++;
        }
        return res;
    }
}
