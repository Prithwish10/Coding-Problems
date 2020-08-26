import java.util.PriorityQueue;

public class Kth_Largest_From_Stream {

	PriorityQueue<Integer> pq;
    int k;
    
    public Kth_Largest_From_Stream(int k, int[] nums) {
        
        this.k = k;
        
        pq = new PriorityQueue<>();
        
        for(int i : nums){
            
            if(pq.size() < k)
                pq.add(i);
            else{
                
                if(pq.peek() < i){
                    pq.poll();
                    pq.add(i);
                }
            }
        }
    }
    
    public int add(int val) {
        
        pq.add(val);
        
        if(pq.size() > k){
            pq.poll();
        }
        return pq.peek();
    }
}
