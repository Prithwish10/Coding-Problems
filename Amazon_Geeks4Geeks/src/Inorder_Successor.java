
public class Inorder_Successor {

	public Node search(Node root, int data) {
		
		if(root == null)
			return null;
		else if(root.data == data)
			return root;
		else if(root.data > data)
			return search(root.left, data);
		else
			return search(root.right, data);
	}
	
	public Node findInorder(Node root, int p) {
		
		Node current = search(root, p);
		
		if(current == null)
			return null;
		
		else if(current.right != null) {
			
			Node temp = current.right;
			
			while(temp.left != null)
				temp = temp.left;
			
			return temp;
		}
		else {
			
			Node ancestor = root;
			Node temp = null;
			
			while(ancestor != current) {
				
				if(p < ancestor.data) {
					
					temp = ancestor;
					ancestor = ancestor.left;
				}
				else if(p > ancestor.data)
					ancestor = ancestor.right;
				
			}
			return temp;
		}
	}
	public static void main(String args[]) {
		
		Node node = new Node(15);
		node.left = new Node(10);
		node.right = new Node(20);
		node.left.left = new Node(8);
		node.left.right = new Node(12);
		node.right.left = new Node(17);
		node.right.right = new Node(25);
		node.left.left.left = new Node(6);
		node.left.right.left = new Node(11);
		node.right.left.left = new Node(16);
		node.right.right.right = new Node(27);
		
		Inorder_Successor in = new Inorder_Successor();
		
		System.out.println(in.findInorder(node, 27) != null ? in.findInorder(node, 27).data : "Inorder Successor not present !");
	}
}
