import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Bottom_View_BT {

	public static class Object{
		
		Node node;
		int dis;
		
		public Object(Node node, int dis) {

			this.node = node;
			this.dis = dis;
		}
	}
	public void bottomView(Node root) {
		
		TreeMap<Integer, LinkedList<Integer>> map = new TreeMap<>();
		
		Queue<Object> queue = new LinkedList<Object>();
		
		queue.add(new Object(root, 0));
		
		while(!queue.isEmpty()) {
			
			Object temp = queue.poll();
			
			if(map.containsKey(temp.dis)) {
				map.get(temp.dis).removeFirst();
				map.get(temp.dis).add(temp.node.data);
			}
			else {
				LinkedList<Integer> list = new LinkedList<Integer>();
				list.add(temp.node.data);
				map.put(temp.dis, list);
			}
			
			if(temp.node.left != null)
				queue.add(new Object(temp.node.left, temp.dis - 1));
			
			if(temp.node.right != null)
				queue.add(new Object(temp.node.right, temp.dis + 1));
		}
		for(Map.Entry<Integer, LinkedList<Integer>> entry : map.entrySet()) {
			System.out.print(entry.getValue()+" ");
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
		node.right.left.right = new Node(8);
		
		Bottom_View_BT botView = new Bottom_View_BT();
		
		botView.bottomView(node);
	}
}
