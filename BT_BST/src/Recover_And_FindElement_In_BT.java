import java.util.HashSet;
import java.util.Set;

public class Recover_And_FindElement_In_BT {

	Set<Integer> set;
    
    public Recover_And_FindElement_In_BT(TreeNode root) {
        
        set = new HashSet<>();
        
        recover(root);
    }
    
    public void recover(TreeNode root){
        
        if(root == null)
            return;
        root.val = 0;
        helper(root);
    }
    
    public void helper(TreeNode root){
        
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            return;
        
        int x = root.val;
        //System.out.println(x);
        if(root.left != null){
            int val = 2*x + 1;
            root.left.val = val;
            set.add(val);
        }
        
        if(root.right != null){
            int val = 2*x + 2;
            root.right.val = val;
            set.add(val);
        }
        helper(root.left);
        helper(root.right);
    }
    public boolean find(int target) {
        
        if(set.contains(target))
            return true;
        return false;
    }
}
