import java.util.HashMap;
import java.util.Map;

public class Find_Two_Non_overlapping_Sub_arrays_Each_With_Target_Sum {

	public int minSumOfLengths(int[] arr, int target) {
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        
        for(int i = 0; i < arr.length; i++){
            
            sum += arr[i];
            map.put(sum, i);
        }
        sum = 0;
        int lsize =Integer.MAX_VALUE, res = Integer.MAX_VALUE;
        
        for(int i = 0; i < arr.length; i++){
            
            sum += arr[i];
            
            if(map.containsKey(sum - target))
                lsize = Math.min(lsize, i - map.get(sum - target));
            
            if(map.containsKey(sum + target) && lsize != Integer.MAX_VALUE)
                res = Math.min(res, map.get(sum + target) - i + lsize);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
