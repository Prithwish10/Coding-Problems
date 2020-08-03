import java.util.ArrayList;
import java.util.List;

public class Pascals_Triangle {

	public static List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        int matrix[][] = new int[numRows][numRows * 2 - 1];
        
        for(int i = 0; i < matrix[0].length ; i++) {
        	if(i == numRows - 1)
        		matrix[0][i] = 1;
        }
        
        int blank = numRows - 2;
        
        for(int i = 1; i < matrix.length; i++) {
        	
        	int j = 0;
        	
        	for(j = 0; j < blank; j++)
        		matrix[i][j] = 0;
        	
        	for(; j < matrix[i].length; j++) {
        		
        		if(i == numRows - 1 && j == 0)
        			matrix[i][j] = 1;
        		
        		else if(i == numRows - 1 && j == matrix[i].length - 1) 	
        			matrix[i][j] = 1;
        		
        		else if(j == matrix[i].length - 1)
        			matrix[i][j] = 0;
        		
        		else
        			matrix[i][j] = matrix[i-1][j- 1] + matrix[i - 1][j + 1];
        		
        	}
        	blank --;
        }
        
        for(int i = 0; i < matrix.length; i++) {
        	List<Integer> list = new ArrayList<Integer>();
        	for(int j = 0; j < matrix[0].length; j++) {
        		if(matrix[i][j] != 0)
        			list.add(matrix[i][j]);
        	}
        	res.add(list);
        }
        return res;
    }
	
	public static void main(String args[]) {
		List<List<Integer>> res = generate(5);
		for(List<Integer> i : res)
			System.out.println(i);
	}
}
