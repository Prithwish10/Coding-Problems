
public class Second_Minimum_Node_Value_In_BT {

	long fm = Long.MAX_VALUE, sm = Long.MAX_VALUE, max = 0;
    
    public int findSecondMinimumValue(TreeNode root) {
        
        helper(root);
        
        return sm == Long.MAX_VALUE ? -1 : (int)sm;
    }
    public void helper(TreeNode root){
        
        if(root == null)
            return;
        
        fm = Math.min(fm, root.val);
        
        if(root.val < sm && root.val > fm)
            sm = root.val;
        
        helper(root.left);
        helper(root.right);
    }
}
