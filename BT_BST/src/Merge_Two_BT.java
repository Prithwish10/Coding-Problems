
public class Merge_Two_BT {

	TreeNode headA, headB;
	
	public Merge_Two_BT() {
		this.headA = null;
		this.headB = null;
	}
	
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        
        if(t1 == null && t2 == null)
            return null;
        if(t1 == null || t2 == null)
            return t1 == null ? t2 : t1;
        
        TreeNode root = new TreeNode(t1.val + t2.val);
        root.left = mergeTrees(t1.left, t2.left);
        root.right = mergeTrees(t1.right, t2.right);
        return root;
    }
	
	public void traverse(TreeNode new_node) {
		
		if(new_node == null)
			return;
		traverse(new_node.left);
		System.out.print(new_node.val+" ");
		traverse(new_node.right);
	}
	public static void main(String args[]) {
		
		Merge_Two_BT merge = new Merge_Two_BT();
	
		merge.headA = new TreeNode(1);
		merge.headA.left = new TreeNode(3);
		merge.headA.right = new TreeNode(2);
		merge.headA.left.left = new TreeNode(5);
		
		merge.headB = new TreeNode(2);
		merge.headB.left = new TreeNode(1);
		merge.headB.right = new TreeNode(3);
		merge.headB.left.right = new TreeNode(4);
		merge.headB.right.right = new TreeNode(7);
		
		TreeNode new_node = merge.mergeTrees(merge.headA, merge.headB);
		
		merge.traverse(new_node);
	}
}
