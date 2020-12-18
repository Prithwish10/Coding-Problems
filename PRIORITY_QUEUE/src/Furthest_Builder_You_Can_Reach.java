import java.util.PriorityQueue;

public class Furthest_Builder_You_Can_Reach {

		//Time - O(n log ladders)
		//Space - O(n)
		public int furthestBuilding(int[] heights, int bricks, int ladders) {
	        
	        if(heights == null) return 0;
	        
	        int len = heights.length;
	        
	        if(len == 0 || len == 1) return 0;
	        
	        
	        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	        
	        for(int i = 0; i < heights.length - 1; i++){
	            
	            int diff = heights[i + 1] - heights[i];
	          
	            if(diff <= 0)
	                continue;
	            
	            if(diff > 0)
	                minHeap.add(diff);
	            
	            if(minHeap.size() > ladders)
	                bricks -= minHeap.poll();
	            
	            if(bricks < 0 && ladders == minHeap.size())
	                return i;
	        }
	        return len - 1;
	    }
}
