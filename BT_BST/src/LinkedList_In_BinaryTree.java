
public class LinkedList_In_BinaryTree {
	public class ListNode {
		 int val;
		 ListNode next;
		 ListNode() {}
		 ListNode(int val) { this.val = val; }
		 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	boolean res = false;
    
    public boolean isSubPath(ListNode head, TreeNode root) {
        
        if((root == null && head != null) || (root != null && head == null))
            return false;
      
        helper(head, root);
        return res;
    }
    private void helper(ListNode head, TreeNode root){
        
        if(root == null)
            return;
        
        if(root.val == head.val)
            res = res || check(root, head);
        
       // res = temp || res;
        
        helper(head, root.left);
        helper(head, root.right);
    }
    private boolean check(TreeNode root, ListNode head){
        
        if(head == null)
            return true;
        
        if(root == null)
            return false;
        
        if(root.val != head.val)
            return false;
        
        boolean left = check(root.left, head.next);
        boolean right = check(root.right, head.next);
        
        return left || right;
    }
}
