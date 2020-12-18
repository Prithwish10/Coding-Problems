import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Kth_Smallest_In_Sorted_Matrix {

	//Time - O(M*N Log K)
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
	//Time - O(k log (N)) where M is the number of rows
	public int kthSmallestOptimised(int matrix[][], int k) {
		
		if(matrix == null || matrix.length == 0)
            return Integer.MIN_VALUE;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            
            public int compare(Pair p1, Pair p2){
                
                return p1.val - p2.val;
            }
        });
        
        for(int i = 0; i < matrix.length; i++){
            
            pq.add(new Pair(matrix[i][0], i, 0));
        }
        
        while(k -- > 1){
            
            Pair p = pq.poll();
            int row = p.row;
            int col =  p.col;
            
            if(col + 1 < matrix[0].length){
                pq.add(new Pair(matrix[row][col + 1], row, col + 1));
            }
        }
        return pq.peek().val;
    }

	class Pair{
    
		int val, row, col;
    
		Pair(int val, int row, int col){
        
			this.val = val;
			this.row = row;
			this.col = col;
		}
	}
}

