import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Count_of_Smaller_Numbers_After_Self {

	static class TreeNode{
	    
	    TreeNode left;
	    TreeNode right;
	    int val;
	    int count = 1;
	    
	    TreeNode(int val){
	        this.val = val;
	    }
	}
	public static List<Integer> countSmaller(int[] nums) {
        
        List<Integer> res = new ArrayList<>();
        
        if(nums == null || nums.length == 0)
            return res;
        
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        res.add(0);
        
        for(int i = nums.length - 2; i >= 0; i --){
            
            res.add(insert(root, nums[i]));
        }
        Collections.reverse(res);
        return res;
    }
    private static int insert(TreeNode root, int val){
        
        boolean flag = false;
        int noOfSmaller = 0;
        
        while(!flag){
            
            if(val <= root.val){
                
                root.count ++;
                
                if(root.left == null){
                    root.left = new TreeNode(val);
                    flag = true;
                }else{
                    root = root.left;
                }
            }
            else{
                
                noOfSmaller += root.count;
                
                if(root.right == null){
                    root.right = new TreeNode(val);
                    flag = true;
                }else{
                    root = root.right;
                }
            }
        }
        return noOfSmaller;
    }
    public static void main(String args[]) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Enter the number of elements :");
    	int n = sc.nextInt();
    	
    	int ar[] = new int[n];
    	System.out.println("Enter the elements :");
    	
    	for(int i = 0; i < n; i++)
    		ar[i] = sc.nextInt();
    	
    	List<Integer> res = countSmaller(ar);
    	
    	System.out.println(res);
    }
}
