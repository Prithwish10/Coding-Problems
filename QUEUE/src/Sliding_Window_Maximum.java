import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Sliding_Window_Maximum {

	public int[] maxSlidingWindow(int[] nums, int k) {
        
		List<Integer> list = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        int ar[] = new int[nums.length - k + 1];
        int index = 0;
        
        int end = 0, start = 0;
        
        for(end = 0; end < k; end ++){
           
            while(!queue.isEmpty() && nums[end] > nums[queue.peekLast()])
                queue.removeLast();
            
            queue.add(end);
        }
        
        ar[index ++] = nums[queue.peekFirst()];
        
        for(; end < nums.length; end ++){
            
            while(!queue.isEmpty() && queue.peekFirst() <= end - k)
                queue.removeFirst();
            
            while(!queue.isEmpty() && nums[end] > nums[queue.peekLast()])
                queue.removeLast();
            
            queue.addLast(end);
            
            ar[index ++] = nums[queue.peekFirst()];
        }
        
//         int ar[] = new int[list.size()];
//         int index = 0;
        
//         for(int i : list)
//             ar[index ++] = i;
        
        return ar;
    }
}
