class Rotate_Image {
    public static void rotate(int[][] matrix) {
    
        int row = matrix.length;
        int col = matrix[0].length;
        
        if(row != col)
            return;
        
        for(int i = 0; i < row; i ++){
            
            for(int j = i; j < col; j++){
                
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
       
        for(int i = 0; i < row; i++){
            
            for(int j = 0; j < row/2; j++){
                
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][row - 1 - j];
                matrix[i][row - 1 - j] = temp;
            }
        }
    }
    public static void main(String args[]) {
		
		int image[][] = {{1, 2, 3},
						 {4, 5, 6},
						 {7, 8, 9}};
		
		rotate(image);
		
		for(int i = 0; i < image.length; i++) {
			
			for(int j = 0; j < image.length; j++) {
				System.out.print(image[i][j]+" ");
			}
			System.out.println();
		}
	}
}

