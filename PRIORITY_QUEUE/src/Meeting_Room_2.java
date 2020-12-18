import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Meeting_Room_2 {

	public int solve(int[][] A) {
        
        if(A == null) return 0;
        if(A.length <= 1) return 1;
        
        // Sort the intervals based on ascending order of the start time
        Arrays.sort(A, new Comparator<int[]>(){
            
            public int compare(int[] a, int[] b){
                
                return a[0] - b[0];
            }
        });
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>(){
                
            public int compare(int[] a, int [] b){
                
                return a[1] - b[1];
            }
        });
        
        for(int i = 0; i < A.length; i++){
            
            if(!minHeap.isEmpty() && minHeap.peek()[1] <= A[i][0])
                minHeap.poll();
            minHeap.add(A[i]);
        }
        return minHeap.size();
        
    }
}
