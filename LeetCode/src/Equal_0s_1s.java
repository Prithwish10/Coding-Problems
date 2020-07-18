import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Equal_0s_1s {
    public static int findMaxLength(int[] nums) {
        
        for(int i = 0; i < nums.length; i++)
            nums[i] = nums[i] == 0 ? -1 : nums[i];
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int maxLen = 0;
        int sum = 0;
        
        for(int i = 0; i < nums.length; i++){
            
            sum += nums[i];
            
            if(sum == 0)
                maxLen = Math.max(maxLen, i + 1);
            
            else if(map.containsKey(sum)){
                
                maxLen = Math.max(maxLen, i - map.get(sum));
            }
            else
                map.put(sum, i);
        }
        return maxLen;
    }
    public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements :");
		int n = sc.nextInt();
		 
		System.out.println("Enter the elements :");
		int nums[] = new int[n];
		
		for(int i = 0; i < n; i++)
			nums[i] = sc.nextInt();
		
		int res = findMaxLength(nums);
		System.out.println(res);
    }
}

