import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DegreeOfArray {
    public int findShortestSubArray(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return 0;
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        int minSubarray = Integer.MAX_VALUE;;
        
        int degree = maxSubArray(nums);
        
        for(int i = 0; i < nums.length; i++){
            
            if(!map.containsKey(nums[i])){
                List<Integer> list = new ArrayList<>();
                list.add(1);
                list.add(i);
                map.put(nums[i], list);
            }
            else{
                
                int count = map.get(nums[i]).get(0); 
                map.get(nums[i]).remove(0);
                map.get(nums[i]).add(0, count +1);
                
                if(map.get(nums[i]).get(0) == degree){
                    minSubarray = Math.min(minSubarray, i - map.get(nums[i]).get(1) + 1);
                }
                
            }
        }
        return minSubarray == Integer.MAX_VALUE ? 1 : minSubarray;
    }
    
    public int maxSubArray(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++)
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        
        int max = -1;
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
        {
            if(entry.getValue() > max)
                max = entry.getValue();
        }
        return max;
    }
    
    public static void main(String args[]) {
    	
    	int ar[]= { 1, 2, 3,3,2};
    	
    	DegreeOfArray deg = new DegreeOfArray();
    	int res = deg.findShortestSubArray(ar);
    	System.out.println(res);
    }
}