//Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
//
//Examples 1
//Input:
//
//  5
// /  \
//2   -3
//return [2, -3, 4], since all the values happen only once, return all of them in any order.
//Examples 2
//Input:
//
//  5
// /  \
//2   -5
import java.util.HashMap;

import java.util.Map;

public class Most_Frequent_Subarray_Sum {

	Map<Integer, Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;
    int count = 0;
    
    //***************O(N^2)****************
    
    public int[] findFrequentTreeSum(TreeNode root) {
        
        if(root == null)
            return new int[]{};
        
        findDriver(root);
        
        int ar[] = new int[count];
        int index = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            
            if(entry.getValue() == max)
                ar[index ++] = entry.getKey();
            //     list.add(entry.getKey());
            
        }
//        int ar[] = new int[list.size()];
//        int index = 0;
//        
//        for(int i : list)
//            ar[index ++] = i;
        
        return ar;
    }
    private void findDriver(TreeNode root){
        
        if(root == null)
            return;
        
        int sum = helper(root);
        
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        
        if(map.get(sum) == max){
            count ++;
        }
        else if(map.get(sum) > max){
            count = 1;
            max = map.get(sum);
        }
        //max = Math.max(max, map.get(sum));
        
        findDriver(root.left);
        findDriver(root.right);
    }
    
    private int helper(TreeNode root){
        
        if(root == null)
            return 0;
        
        return root.val + helper(root.left) + helper(root.right);
    }
    
    // ************O(N)******************
    
    public int[] findFrequentTreeSum_efficient(TreeNode root) {
        
        if(root == null)
            return new int[]{};
        
        helper_efficient(root);
        
        int ar[] = new int[count];
        int index = 0;
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            
            if(entry.getValue() == max)
                ar[index ++] = entry.getKey();         
        }
        
        return ar;
    }
    private int helper_efficient(TreeNode root){
        
        if(root == null)
            return 0;
        
        int left = helper_efficient(root.left);
        int right = helper_efficient(root.right);
        
        int sum = root.val + left + right;
        
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        
        if(map.get(sum) > max){
            max = map.get(sum);
            count = 1;
        }
        else if(map.get(sum) == max)
            count ++;
        
        return sum;
    }
}
