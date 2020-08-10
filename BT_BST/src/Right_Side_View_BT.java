import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Right_Side_View_BT {

	class Pair{
	    
	    TreeNode root;
	    int level;
	    
	    Pair(TreeNode root, int level){
	        this.root = root;
	        this.level = level;
	    }
	}
	public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        
        if(root == null)
            return res;
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        
        Pair previous = queue.peek();
        
        while(!queue.isEmpty()){
            
            Pair p = queue.poll();
            
            if(p.level != previous.level){
                
                res.add(previous.root.val);
            }
            previous = p;
            
            if(p.root.left != null)
                queue.add(new Pair(p.root.left, p.level + 1));
            
            if(p.root.right != null)
                queue.add(new Pair(p.root.right, p.level + 1));
        }
        res.add(previous.root.val);
        
        return res;
    }
}

