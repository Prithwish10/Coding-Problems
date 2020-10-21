import java.util.*;
public class Combination {

	List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> combine(int n, int k) {
        
        if(n < k) return res;
        
        LinkedList<Integer> list = new LinkedList<>();
        combination(list, 0, 1, n, k);
        
        return res;
    }
    private void combination(LinkedList<Integer> list, int pos, int ele, int n, int k){
        
        if(pos >= n){
            
            if(list.size() == k)
                res.add(new LinkedList<>(list));
            return;
        }
        list.add(ele);
        combination(list, pos + 1, ele + 1, n, k);
        list.removeLast();
        
        combination(list, pos + 1, ele + 1, n, k);
    }
}
