
class Solution {
    public boolean isBalanced(TreeNode root) {
        
        if(root == null)
            return true;
        
        findHeight(root);  
        return res;
    }
    boolean res = true;
    public int findHeight(TreeNode root){
        
        if(root == null)
            return 0;
        
        int left = findHeight(root.left);
        int right = findHeight(root.right);
        
        if(Math.abs(left - right) > 1)
            res = false;
        return Math.max(left, right) + 1;
    }
}
