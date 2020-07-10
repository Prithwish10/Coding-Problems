import java.util.Arrays;
import java.util.Scanner;

class House_Robber {
    public int rob(int[] nums) {
        
        int cache[] = new int[nums.length + 1];
        
        Arrays.fill(cache, -1);
        
        return rob(nums, cache, nums.length);
    }
    public int rob(int nums[], int cache[], int n){
        
        if(n <= 0)
            return 0;
        if(cache[n] != -1)
            return cache[n];
        
        return cache[n] = Math.max(nums[n - 1] + rob(nums, cache, n - 2), rob(nums, cache, n - 1));
    }
    public static void main(String args[]) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Enter the number of elements :");
    	int n = sc.nextInt();
    	
    	int ar[] = new int[n];
    	System.out.println("Enter the elements :");
    	
    	for(int i = 0; i < n; i++)
    		ar[i] = sc.nextInt();
    	
    	House_Robber rb = new House_Robber();
    	System.out.println(rb.rob(ar));
    }
}