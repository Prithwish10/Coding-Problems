import java.util.Stack;

public class Flatten_BinaryTree_To_LinkedList {
    
	public void flatten(TreeNode root) {
        
        Stack<TreeNode> stack = new Stack<TreeNode>(); 
        
        stack.add(root);
        
        while(!stack.isEmpty()){
       
            TreeNode temp = stack.pop();
            
            if(temp.right != null)
                stack.add(temp.right);
            if(temp.left != null)
                stack.add(temp.left);
            
            if(!stack.isEmpty())
            	temp.right = stack.peek();
            
            temp.left = null;
        }
    }
	
	public void traverse(TreeNode root) {
		
		if(root == null)
			return;
		
		System.out.print(root.val+" ");
		
		traverse(root.left);
		
		traverse(root.right);
	}
	
	public static void main(String args[]) {
		
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(5);
		node.left.left = new TreeNode(3);
		node.left.right = new TreeNode(4);
		//node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(6);
		//node.left.right.left.right = new Node(2);
		
		Flatten_BinaryTree_To_LinkedList con = new Flatten_BinaryTree_To_LinkedList();
		
		System.out.println("Before convertion :");
		con.traverse(node);
		
		con.flatten(node);
		System.out.println("\nAfter convertion :");
		con.traverse(node);
	}
}
