import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Find_Duplicate_Subtrees {
    
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<TreeNode>();
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        helper(root);
        return res;
    }
    private String helper(TreeNode root){
        
        if(root == null)
            return "X";
        
        String left = helper(root.left);
        String right = helper(root.right);
        String temp = Integer.toString(root.val) + "-"+ left + "-"+ right;
        
        map.put(temp, map.getOrDefault(temp, 0) + 1);
        
        if(map.get(temp) == 2)
            res.add(root);
        
        return temp;
    }  
}
