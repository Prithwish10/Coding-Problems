import java.util.ArrayList;
import java.util.List;

public class N_Ary_Post_Order_Traversal {

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
	List<Integer> res = new ArrayList<>();
    
    public List<Integer> postorder(Node root) {
        
        if(root == null)
            return res;
        helper(root);
        return res;
    }
    
    private void helper(Node root){
        
        if(root == null)
            return;
        
        List<Node> neighbour = root.children;
        
        for(Node child : neighbour){
            
            helper(child);
            
        }
        res.add(root.val);
    }
}
