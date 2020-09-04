import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReArrange_Words_In_A_String {

	public String arrangeWords(String text) {
        
        List<Object> list = new ArrayList<>();
        
        String wrd = "";
        int index = 0, cnt = 0;
        
        for(int i = 0; i < text.length(); i++){
            
            if(text.charAt(i) != ' '){
                wrd += Character.toLowerCase(text.charAt(i));
                cnt += 1;
            }
            
            else if(text.charAt(i) == ' '){
                
                list.add(new Object(wrd, cnt, index));
                wrd = "";
                cnt = 0;
                index ++;
            }
        }
        list.add(new Object(wrd, cnt, index));
        
        // for(Object o : list)
        //     System.out.println(o.s+" "+o.cnt+" "+o.index);
        
        Collections.sort(list, new Comparator<Object>(){
            
            public int compare(Object o1, Object o2){
                
                if(o1.cnt != o2.cnt){
                    return o1.cnt - o2.cnt;
                }
                else
                    return o1.index - o2.index;
            }
        });
        String res = "";
        int l = list.size();
        
        String sb = list.get(0).s;
        char ch[] = sb.toCharArray();
        char c = ch[0];
        c = Character.toUpperCase(c);
        ch[0] = c;
        res += new String(ch);
        res += l == 1 ? "" : " ";
        
        
        for(int i = 1; i < list.size(); i++){
            
            res += list.get(i).s;
            if(i != l - 1)
                res += " ";
        }
        return res;
    }
}
class Object{
    
    String s;
    int cnt, index;
    
    Object(String s, int cnt, int index){
        
        this.s = s;
        this.cnt = cnt;
        this.index = index;
    }
}
