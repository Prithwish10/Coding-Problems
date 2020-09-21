import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Replace_Words {

	public String replaceWords(List<String> dictionary, String sentence) {
        
        if(dictionary == null) return "";
        
        Set<String> set = new HashSet<>();
        
        for(String s : dictionary)
            set.add(s);
        
        String words[] = sentence.split(" ");
        
        String res = "";
        
        boolean flag = false;
        
        for(int i = 0; i < words.length; i++){
            
            String word = words[i];
            
            String temp = "";
            
            flag = false;
            
            for(int j = 0; j < word.length(); j++){
                
                temp += word.charAt(j);
                
                if(set.contains(temp)){
                    res += temp;
                    flag = true;
                    break;
                }
            }
            if(!flag)
                res += temp;
            if(i != words.length - 1)
                res += " ";
        }
        return res;
    }
}
