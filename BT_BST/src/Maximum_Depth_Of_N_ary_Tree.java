import java.util.List;

public class Maximum_Depth_Of_N_ary_Tree {

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
	public int maxDepth(Node root) {
        return helper(root);
    }
    
    private int helper(Node root){
        
        if(root == null)
            return 0;
        
        List<Node> neighbour = root.children;
        int currentMax = 0;
        
        for(Node child : neighbour){
            
            int currentHeight = helper(child);
            
            if(currentHeight > currentMax)
                currentMax = currentHeight;
        }
        return 1 + currentMax;
    }
}