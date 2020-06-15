import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Object{
	
	Node node;
	int dis;
	
	Object(Node node, int dis){
		
		this.node = node;
		this.dis = dis;
	}
}
public class Vertical_Order_Traversal {

	public void traversal(Node node) {
		
		if(node == null)
			return;
		
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
		
		Queue<Object> queue = new LinkedList<Object>();
		
		queue.add(new Object(node, 0));
		
		while(!queue.isEmpty()) {
			
			Object temp = queue.poll();
			
			if(map.containsKey(temp.dis)) {
				map.get(temp.dis).add(temp.node.data);
			}
			else {
				ArrayList<Integer> list= new ArrayList<>();
				list.add(temp.node.data);
				map.put(temp.dis, list);
			}
			
			if(temp.node.left != null)
				queue.add(new Object(temp.node.left, temp.dis - 1));
			if(temp.node.right != null)
				queue.add(new Object(temp.node.right, temp.dis + 1));
		}
//		for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
//			
//			System.out.println(entry.getKey()+" "+entry.getValue());
//		}
		for(int i : map.keySet())
			System.out.println(i+" ");
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
		
		Vertical_Order_Traversal trav = new Vertical_Order_Traversal();
		
		trav.traversal(node);
	}
}
