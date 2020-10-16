import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N_ary_Level_Order_Traversal {

	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	}
	class Object{
	    
	    Node node;
	    int dis;
	    Object(Node node, int dis){
	        this.node = node;
	        this.dis = dis;
	    }
	}
	public List<List<Integer>> levelOrder(Node root) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null)
            return res;
        
        Queue<Object> queue = new LinkedList<>();
        
        queue.add(new Object(root, 0));
        List<Integer> list = new ArrayList<>();
        
        int level = 0;
        
        while(!queue.isEmpty()){
            
            Object temp = queue.poll();
            Node node = temp.node;
            int dis = temp.dis;
            
            if(level == dis) {
                list.add(node.val);
            }else{
                res.add(list);
                list = new ArrayList<>();
                level = dis;
                list.add(node.val);
            }        
            
            for(Node child : node.children){
                queue.add(new Object(child, dis + 1));
            }
        }
        res.add(list);
        return res;
    }
}
