public class Spiral_Order_Matrix_1 {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public static int[] spiralOrder(int[][] A) {
        
    	if(A == null || A.length == 0)
            return new int[]{};
        
        int r = A.length;
        int c = A[0].length;
        int res[] = new int[r * c];
        int index = 0;
          
        int T = 0, B = r - 1, L = 0, R = c - 1, dir = 0;
        
        while(T <= B && L <= R){
            
            if(dir == 0){
                
                for(int i = L; i <= R; i++)
                    res[index ++] = A[T][i];
                T ++;
            }
            else if(dir == 1){
                
                for(int i = T; i <= B; i++)
                    res[index ++] = A[i][R];
                R --;
            }
            else if(dir == 2){
                
                for(int i = R; i >= L; i --)
                    res[index ++] = A[B][i];
                B --;
            }
            else if(dir == 3){
                
                for(int i = B; i >= T; i--)
                    res[index ++] = A[i][L];
                L ++;
            }
            dir = (dir + 1)%4;
        }
        return res;
    }
    public static void main(String rags[]) {
    	
    	int A[][] = {{1,2,3},
    			{4,5,6},
    			{7,8,9}};
    	
    	int res[] = spiralOrder(A);
    	
    	for(int i = 0; i < res.length; i++) {
    		System.out.print(res[i]+" ");
    	}
    }
}


