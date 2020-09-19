import java.util.HashMap;
import java.util.Map;

public class Subarray_Sum_Divisible_By_K {

	public int subarraysDivByK(int[] A, int K) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(0, 1);
        
        int rem = 0, res = 0, sum = 0;
        
        for(int i = 0; i < A.length; i++){
            
            sum += A[i];
            
            rem = sum % K;
            
            if(rem < 0)
                rem += K;
            
            if(map.containsKey(rem))
                res += map.get(rem);
            
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return res;
    }
}
