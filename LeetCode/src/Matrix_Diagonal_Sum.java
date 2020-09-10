
public class Matrix_Diagonal_Sum {

	public int diagonalSum(int[][] mat) {
        
        int i = 0, j = 0, r = mat.length, c = mat.length, sum = 0;
        
        while(i < r && j < c){
            
            sum += mat[i][j];
            
            i++;
            j++;
        }
        
        i = 0; j = c - 1;
        
        while(i < r && j >= 0){
            
            if(i != j){
                sum += mat[i][j];
                i ++;
                j --;
            }
            else{
                i ++;
                j --;
            }
        }
        return sum;
    }
}
