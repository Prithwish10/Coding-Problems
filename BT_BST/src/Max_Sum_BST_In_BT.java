
public class Max_Sum_BST_In_BT {

	class Value{
	    
	    boolean isBst;
	    int sum;
	    int min;
	    int max;
	    
	    Value(){
	        this.isBst = true;
	        this.sum = 0;
	        this.min = Integer.MAX_VALUE;
	        this.max = Integer.MIN_VALUE;
	    }
	}
	int ans = 0;
    public int maxSumBST(TreeNode root) {
        
        Value res = findMaxSum(root);
        return ans < 0 ? 0 : ans;
    }
    public Value findMaxSum(TreeNode root){
        
        if(root == null)
            return new Value();
        
        Value v = new Value();
        
        Value left = findMaxSum(root.left);
        Value right = findMaxSum(root.right);
        
        if(left.isBst == false || right.isBst == false || (left.max >= root.val
                    || right.min <= root.val)){
            
            v.isBst = false;
            v.sum = Math.max(left.sum, right.sum);
            return v;
        }
        
        v.isBst = true;
        v.sum = left.sum + right.sum + root.val;
        v.min = root.left != null ? left.min : root.val;
        v.max = root.right != null ? right.max : root.val;
        ans = Math.max(ans, v.sum);
        return v;
    }
}
