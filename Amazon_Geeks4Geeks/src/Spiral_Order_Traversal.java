import java.util.Stack;

public class Spiral_Order_Traversal {

	public void spiralTraversal(Node node) {
		
		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		
		stack1.add(node);
		
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			
			while(!stack1.isEmpty()) {
				
				Node temp = stack1.pop();
				System.out.print((char)temp.data+" ");
				
				if(temp.left != null)
					stack2.add(temp.left);
				if(temp.right != null)
					stack2.add(temp.right);
			}
			
			while(!stack2.isEmpty()) {
				
				Node temp = stack2.pop();
				System.out.print((char)temp.data+" ");
				
				if(temp.right != null)
					stack1.add(temp.right);
				if(temp.left != null)
					stack1.add(temp.left);
			}
		}
	}
	public static void main(String args[]) {
		
		Node node = new Node('a');
		node.left = new Node('b');
		node.right = new Node('c');
		node.left.left = new Node('d');
		node.left.right = new Node('e');
		node.right.left = new Node('f');
		node.right.right = new Node('g');
		
		Spiral_Order_Traversal sp = new Spiral_Order_Traversal();
		
		sp.spiralTraversal(node);
	}
}
