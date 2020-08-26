import java.util.Collections;
import java.util.PriorityQueue;

public class Kth_Smallest_In_Sorted_Matrix {

	public int kthSmallest(int[][] matrix, int k) {
        
        if(matrix == null || matrix.length == 0)
            return Integer.MIN_VALUE;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < matrix.length; i++){
            
            for(int j = 0; j < matrix[i].length; j++){
                
                if(pq.size() < k)
                    pq.add(matrix[i][j]);
                else{
                    
                    if(pq.peek() > matrix[i][j]){
                        pq.poll();
                        pq.add(matrix[i][j]);
                    }
                }
            }
        }
        return pq.peek();
    }
}
