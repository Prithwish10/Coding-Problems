class Spiral_Order_Matrix_2 {
    public int[][] generateMatrix(int n) {
     
        if(n == 0)
            return new int[][]{{}};
        
        int res[][] = new int[n][n];
        
        int r = res.length;
        int c = res[0].length;
        
        int T = 0, B = r - 1, L = 0, R = c - 1, dir = 0, C = 1;
        
        while(T <= B && L <= R){
            
            if(dir == 0){
                
                for(int i = L; i <= R; i++)
                    res[T][i] = C ++;
                T ++;
            }
            else if(dir == 1){
                
                for(int i = T; i <= B; i++)
                    res[i][R] = C ++;
                R --;
            }
            else if(dir == 2){
                
                for(int i = R; i >= L; i--)
                    res[B][i] = C ++;
                B --;
            }
            else if(dir == 3){
                
                for(int i = B; i >= T; i--)
                    res[i][L] = C ++;
                L ++;
            }
            dir = (dir+1) % 4;
        }
        return res;
    }
}