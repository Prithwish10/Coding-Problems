import java.util.LinkedList;
import java.util.Queue;

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
class Maximum_Level_Sum_BT {
    public int maxLevelSum(TreeNode root) {
        
        if(root == null)
            return -1;
        
        Queue<Pair> queue = new LinkedList<Pair>();
        int res = -1;
        int currentLevel = 1;
        int levelSum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        Pair temp = null;
        
        queue.add(new Pair(root, 1));
        
        while(!queue.isEmpty()){
            
            temp = queue.poll();
         
            if(temp.level != currentLevel){
                
                if(levelSum > maxSum){
                    
                    maxSum = levelSum;
                    res = currentLevel;
                  
                } 
                currentLevel = temp.level;
                levelSum = 0;
            }
            
            levelSum += temp.root.val;
            
            if(temp.root.left != null)
                queue.add(new Pair(temp.root.left, temp.level + 1));
            
            if(temp.root.right != null)
                queue.add(new Pair(temp.root.right, temp.level + 1));
            
        }
        if(levelSum > maxSum){
            res = temp.level;
        }
     
        return res;
    }
}
class Pair{
    
    TreeNode root;
    int level;
    
    Pair(TreeNode root, int level){
        
        this.root = root;
        this.level = level;
    }
}
