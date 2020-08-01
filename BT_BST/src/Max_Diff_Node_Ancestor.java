class Max_Diff_Node_Ancestor {
	
	/*           O(n^2)        */
	
    int V = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        
        if(root == null)
            return 0;
        findDiff(root);
        return V;
    }
    public void findDiff(TreeNode root){
        
        if(root == null)
            return;
        
        inOrder(root.left, root.val);
        inOrder(root.right, root.val);
        
        findDiff(root.left);
        findDiff(root.right);
    }
    public void inOrder(TreeNode root, int val){
        
        if(root == null)
            return;
        
        V = Math.max(V, Math.abs(val - root.val));
        
        inOrder(root.left, val);
        inOrder(root.right, val);
    }
    							/* OPTIMISED SOLUTION */
    							/*      O(n)     */
    int res = Integer.MIN_VALUE;
    public int maxAncestorDiff1(TreeNode root) {
        
        if(root == null)
            return 0;
        findDiff(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return res;
    }
    public void findDiff(TreeNode root, int max, int min){
        
        if(root == null){
            res = Math.max(V, Math.abs(max- min));
            return;
        }
        
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        
        findDiff(root.left, max, min);
        findDiff(root.right, max, min);
    }
    
}
