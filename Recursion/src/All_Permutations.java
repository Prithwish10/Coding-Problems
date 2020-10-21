import java.util.*;
public class All_Permutations {

	List<List<Integer>> res = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        
        if(nums == null) return res;
        
        int n = nums.length;
                           
        Map<Integer, Integer> map = new TreeMap<>();
        
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        int ele[] = new int[map.size()];
        int count[] = new int[map.size()];
        int index = 0;
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            
            ele[index] = entry.getKey();
            count[index] = entry.getValue();
            index ++;
        }
        
        int result[] = new int[n];
        generatePermute(ele, count, result, 0);
        
        return res;
    }
    private void generatePermute(int ele[], int count[], int result[], int level) {
        
        if(level == result.length){
            addToList(result);
            return;
        }
        
        for(int i = 0; i < ele.length; i++){
            
            if(count[i] == 0)
                continue;
            
            result[level] = ele[i];
            count[i] --;
            generatePermute(ele, count, result, level + 1);
            count[i] ++;
        }
    }
    private void addToList(int result[]){
        
        List<Integer> l = new ArrayList<>();
        
        for(int i : result)
            l.add(i);
        res.add(l);
    }
}
