// Rotate a matrix clockWise 
public class Rotate_90_Degree {

	public static void main(String args[]) {
		
		int image[][] = {{1, 2, 3},
						 {4, 5, 6},
						 {7, 8, 9}};
		
		rotate(image);
	}
	public static void rotate(int image[][]) {
		
		for(int i = 0; i < image.length; i++) {
			
			for(int j = i; j < image.length; j++) {
				
				int temp = image[i][j];
				image[i][j] = image[j][i];
				image[j][i] = temp;
			}
		}
		for(int i = 0; i < image.length; i++) {
			
			int temp = image[i][0];
			image[i][0] = image[i][image.length - 1];
			image[i][image.length - 1] = temp;
		}
		
		for(int i = 0; i < image.length; i++) {
			for(int j = 0; j < image.length; j++) {
				
				System.out.print(image[i][j]+" ");
			}
			System.out.println();
		}
	}
}
