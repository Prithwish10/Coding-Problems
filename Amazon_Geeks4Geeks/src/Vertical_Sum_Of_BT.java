import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Vertical_Sum_Of_BT {

	class Object{
		
		int dis;
		Node node;
		
		Object(int dis, Node node){
			this.dis = dis;
			this.node = node;
		}
	}
	public void verticalSum(Node node) {
		
		Queue<Object> queue= new LinkedList<Object>();
		
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		
		queue.add(new Object(0, node));
		
		while(!queue.isEmpty()) {
			
			Object temp = queue.poll();
			
			if(!map.containsKey(temp.dis))
				map.put(temp.dis, temp.node.data);
			else {
				map.put(temp.dis, map.get(temp.dis) + temp.node.data);
			}
			
			if(temp.node.left != null)
				queue.add(new Object(temp.dis - 1, temp.node.left));
			
			if(temp.node.right != null)
				queue.add(new Object(temp.dis + 1, temp.node.right));
		}
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			
			System.out.println(entry.getKey()+" -> "+ entry.getValue());
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
		
		Vertical_Sum_Of_BT sum = new Vertical_Sum_Of_BT();
		
		sum.verticalSum(node);
	}
}
