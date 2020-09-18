import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Average_Of_First_TopFive_Student_Marks_SortedBy_ID {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of students info :");
		int n = sc.nextInt();
		
		int ar[][] = new int[n][2];
		
		System.out.println("Enter the elements :");
		for(int i = 0; i < n; i++) {
			ar[i][0] = sc.nextInt();
			ar[i][1] = sc.nextInt();
		}
		findAverage(ar, 5);
	}
	
	public static void findAverage(int ar[][], int k) {
		
		Arrays.sort(ar, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				if(o1[0] != o2[0])
					return o1[0] - o2[0];
				
				return o2[1] - o1[1];
			}
			
		});
		
//		for(int i = 0; i < ar.length; i++) {
//			
//			System.out.println(ar[i][0]+" "+ar[i][1]);
//		}
		int count = 1, id = ar[0][0], sum = ar[0][1], avg = 0;
		
		for(int i = 1; i < ar.length; i++) {
			
			if(ar[i][0] == id && count < k) {
				
				count ++;
				sum += ar[i][1];
			}
			else {
				avg = sum/k;
				System.out.println(id +" "+ avg);
				count = 0;
				
				while(i < ar.length && ar[i][0] == id)
					i++;
				
				if(i < ar.length) {
					
					id = ar[i][0];
					count = 1;
					sum = ar[i][1];
				}
			}
		}
		if(count > 0 && count <= k) {
			avg = sum / k;
			System.out.println(id +" "+ avg);
		}
	}
}
