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
    //*************** O(n)*******************
    //Map<Integer, Integer> map = new HashMap<>();
    int fm = Integer.MAX_VALUE, sm = Integer.MAX_VALUE, max = 0;
    public int findSecondMinimumValue1(TreeNode root) {
        
        helper(root);
        
        if(map.size() == 2 && map.containsKey(Integer.MAX_VALUE) && sm == Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        
        return sm == Integer.MAX_VALUE ? -1 : sm;
    }
    public void helper1(TreeNode root){
        
        if(root == null)
            return;
        
        map.put(root.val, 1);
        
        fm = Math.min(fm, root.val);
        
        if(root.val < sm && root.val > fm)
            sm = root.val;
        
        helper(root.left);
        helper(root.right);
    }
}
