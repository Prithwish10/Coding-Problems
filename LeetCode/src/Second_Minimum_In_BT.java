import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Second_Minimum_In_BT {

	PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    Map<Integer, Integer> map = new HashMap<>();
    public int findSecondMinimumValue(TreeNode root) {
        
        helper(root);
        
        if(maxHeap.size() < 2)
            return -1;
    
        return maxHeap.poll();
    }
    public void helper(TreeNode root){
        
        if(root == null)
            return;
        
        if(maxHeap.size() < 2 && !map.containsKey(root.val)){
            
            maxHeap.add(root.val);
            map.put(root.val, 1);
        }
            
        else{
            
            if(maxHeap.peek() > root.val && !map.containsKey(root.val)){
                maxHeap.poll();
                maxHeap.add(root.val);
                map.put(root.val, 1);
            }
        }
        
        helper(root.left);
        helper(root.right);
    }
}
