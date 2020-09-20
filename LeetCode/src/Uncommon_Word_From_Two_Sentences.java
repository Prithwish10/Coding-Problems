import java.util.HashMap;
import java.util.Map;

public class Uncommon_Word_From_Two_Sentences {

	public String[] uncommonFromSentences(String A, String B) {
        
        Map<String, Integer> senA = new HashMap<>();
        
        String word = "";
        
        for(int i = 0; i < A.length(); i++){
            
            if(A.charAt(i) != ' '){
                word += A.charAt(i);
            }
            else{
                //System.out.println(word);
                senA.put(word, senA.getOrDefault(word, 0) + 1);
                word = "";
            }
        }
        senA.put(word, senA.getOrDefault(word, 0) + 1);
        word = "";
        
        for(int i = 0; i < B.length(); i++){
            
            if(B.charAt(i) != ' '){
                word += B.charAt(i);
            }
            else{
                senA.put(word, senA.getOrDefault(word, 0) + 1);
                word = "";
            }
        }
        senA.put(word, senA.getOrDefault(word, 0) + 1);
        
        List<String> list = new ArrayList<>();
        
        for(Map.Entry<String, Integer> entry : senA.entrySet()){
            
            if(entry.getValue() == 1)
                list.add(entry.getKey());
        }
        
        String res[] = new String[list.size()];
        int index = 0;
        
        for(String s : list)
            res[index ++] = s;
        
        return res;
    }
}
