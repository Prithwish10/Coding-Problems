import java.util.HashSet;
import java.util.Set;

public class Lexicographically_Smallest_String_After_Applying_Operation {

	String ans;
    public String findLexSmallestString(String s, int a, int b) {
        ans = s;
        Set<String> visited = new HashSet<>();
        dfs(s,a,b,visited);
        return ans;
    }
    public String add(String s, int a){
        String res = "";
        for(int i = 0; i < s.length(); i++){
            if(i % 2 == 0)
                res += s.charAt(i);
            else
                res += (char)((s.charAt(i) - '0' + a) % 10 + '0');             
        }
        return res;
    }
    public String rotate(String s, int b){
        
        String res = "";
        res += s.substring(s.length() - b, s.length());
        res += s.substring(0, s.length() - b);
        return res;
    }
    
    public void dfs(String s, int a, int b, Set<String> visited){
        
        if(visited.contains(s))
            return;
        visited.add(s);
        ans = min(ans, s);
        dfs(add(s,a), a, b, visited);
        dfs(rotate(s,b),a,b,visited);
    }
    public String min(String a, String b){
        if(a.compareTo(b) > 0)
            return b;
        return a;
    }
}
