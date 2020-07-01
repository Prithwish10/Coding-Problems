
public class Distance_Between_Two_Nodes {

	public int findDistance(Node root, int p, int q) {
		
		if(root == null)
			return 0;
		
		Node lca = findLCA(root, p, q);
		
		if(lca == null)
			return 0;
		
		int distance1 =  findDistance1(lca, p, 0);
		int distance2 =  findDistance1(lca, q, 0);
		
		if(distance1 == -1 || distance2 == -1)
			return -1;
		else
			return distance1+distance2;
	}
	
	public Node findLCA(Node root, int p, int q) {
		
		if(root == null)
			return root;
		
		if(root.data == p || root.data == q)
			return root;
		
		Node left = findLCA(root.left, p, q);
		Node right = findLCA(root.right, p, q);
		
		if(left != null && right != null)
			return root;
		else
			return left != null ? left : right;
	}
	
	public int findDistance1(Node root, int p, int distance) {
		
		if(root == null)
			return -1;
		
		if(root.data == p)
			return distance;
		
		int left = findDistance1(root.left, p, distance + 1);
		int right = findDistance1(root.right, p, distance + 1);
		
		return left != -1 ? left : right;
	}
	public static void main(String args[]) {
		
		Node node = new Node(1);
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.right.left = new Node(5);
		node.right.right = new Node(6);
		node.right.right.left = new Node(7);
		
		Distance_Between_Two_Nodes find = new Distance_Between_Two_Nodes();
		
		int dis = find.findDistance(node, 2, 4);
		System.out.println(dis);
	}
}
