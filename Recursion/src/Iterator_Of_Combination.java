import java.util.*;

public class Iterator_Of_Combination {

	List<List<Character>> res;
    int pos;
    
    public Iterator_Of_Combination(String characters, int combinationLength) {
        
        res = new LinkedList<>();
        pos = 0;
        
        LinkedList<Character> list = new LinkedList<>();
        
        char ch[] = characters.toCharArray();
        
        distinctSubsequence(ch, 0, combinationLength, list);
    }
    
    public String next() {
        
        List<Character> list = res.get(pos);
        String s = "";
        for(char c : list)
            s += c;
        pos ++;
        return s;
    }
    
    public boolean hasNext() {
        
        if(pos >= res.size())
            return false;
        return true;
    }
    public void distinctSubsequence(char ar[], int p, int len, LinkedList<Character> list) {
		
		if(p >= ar.length) {
			if(list.size() == len)
				res.add(new LinkedList<>(list));
			return;
		}
		
		list.add(ar[p]);
		distinctSubsequence(ar, p + 1, len, list);
		
		list.removeLast();
		
		distinctSubsequence(ar, p + 1, len, list);
	}
}
