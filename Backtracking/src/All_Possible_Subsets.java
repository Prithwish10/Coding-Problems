import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class All_Possible_Subsets {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> subsets(int[] nums) {
        
        List<Integer> store = new ArrayList<Integer>();
        
        subsets(nums, nums.length, 0, store);
        
        return result;
    }
    
    public void subsets(int nums[], int n, int pos, List<Integer> store){
        
        if(pos >= n){
            result.add(new ArrayList<>(store));
            return;
        }
        
        store.add(nums[pos]);
        
        subsets(nums, n, pos + 1, store);
        
        store.remove(store.size() - 1);
        
        subsets(nums, n, pos + 1, store);
    }
    
    public static void main(String args[]) {
    	
    	All_Possible_Subsets sub = new All_Possible_Subsets();
    	
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Enter the number of elements :");
    	int n = sc.nextInt();
    	
    	System.out.println("Enter the elements :");
    	
    	int nums[] = new int[n];
    	
    	for(int i = 0; i < n; i++)
    		nums[i] = sc.nextInt();
    	List<List<Integer>> res = sub.subsets(nums);
    	
    	for(List<Integer> i : res)
    		System.out.println(i);
    }
}

