
public class BT_to_DLL {
	
	Node head = null;
	
	public void convert(Node node) {
		
		convert1(node);
		
		
	}
	
	Node prev = null;
	public void convert1(Node p) {
		
		if(p == null)
			return;
		
		convert(p.left);
		
		if(prev == null) {
			head = p;
		}
		else {
			p.left = prev;
			prev.right = p;
		}
		prev = p;
		
		convert(p.right);
	}
	
	public void traverse(Node head) {
		
		while(head != null) {
			
			System.out.print(head.data+" ");
			head = head.right;
		}
	}
	public static void main(String args[]) {
		
		Node node = new Node(1);
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		node.right.left = new Node(6);
		node.right.right = new Node(7);
		//node.left.right.left.right = new Node(2);
		
		BT_to_DLL con = new BT_to_DLL();
		
		con.convert(node);
		con.traverse(con.head);
	}
}
