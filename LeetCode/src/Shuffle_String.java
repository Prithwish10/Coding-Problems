
public class Shuffle_String {

	public String restoreString(String s, int[] indices) {
        
        if(s == null || s.length() == 0)
            return "";
        
        Map<Integer, Character> map = new HashMap<>();
        int i = 0;
        
        for(char c : s.toCharArray()){
            map.put(indices[i], c);
            i++;
        }
        
        char ch[] = new char[s.length()];
        
        for(i = 0; i < ch.length; i++){
            
            ch[i] = map.get(i);
        }
        return new String(ch);
    }
}
