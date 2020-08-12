//Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians), return the indexes of the k weakest rows in the matrix ordered from the weakest to the strongest.
//
//A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers in row j, or they have the same number of soldiers but i is less than j. Soldiers are always stand in the frontier of 
//a row, that is, always ones may appear first and then zeros.
import java.util.*;

public class K_Weakest_Row_IN_A_Matrix {

	static class Pair{
		
		int index;
		int ones;
		Pair(int index, int ones){
			
			this.index = index;
			this.ones = ones;
		}
	}
	
	public static void main(String args[]) {
		
		int ar[][] = {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
		
		int res[] = find(ar,2);
		int res1[] = kWeakestRows(ar,2);
		
		for(int i : res)
			System.out.print(i+" ");
		
		for(int i : res1)
			System.out.print(i+" ");
	}
	
	public static int[] find(int mat[][], int k) {
		
//		PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> 
//        (b.count-a.count==0) ? b.row-a.row : b.count-a.count);
		PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(new Comparator<Pair>() {
			public int compare(Pair o1, Pair o2) {
			
				if(o1.ones == o2.ones)
					return o2.index - o1.index;
				else
					return o2.ones - o1.ones;
			}
		});
		
		int count = 0;
		
		for(int i = 0; i < mat.length; i++){
            count = 0;
            for(int j = 0; j < mat[i].length; j++){
                
                if(mat[i][j] == 0)
                    break;
                
                count ++;
            }
            minHeap.add(new Pair(i, count));
            
            if(minHeap.size() > k)
            	minHeap.poll();
        }
		int res[] = new int[k];
		int i = k - 1;
		
		while(!minHeap.isEmpty()) 
            res[i --] = minHeap.poll().index;
		return res;
	}
	public static int[] kWeakestRows(int[][] mat, int k) {
        
        Pair p[] = new Pair[mat.length];
        int count = 0;
        
        for(int i = 0; i < mat.length; i++){
            count = 0;
            for(int j = 0; j < mat[i].length; j++){
                
                if(mat[i][j] == 0)
                    break;
                
                count ++;
            }
            p[i] = new Pair(i, count);
        }
        
        Arrays.sort(p, new Comparator<Pair>(){
            
            public int compare(Pair p1, Pair p2){
                
                if(p1.ones == p2.ones)
                    return p1.index - p2.index;
                else
                    return p1.ones - p2.ones;
            }
        });
            
        int res[] = new int[k];
        
        for(int i = 0; i < k; i++)
            res[i] = p[i].index;
        return res;
    }
}
