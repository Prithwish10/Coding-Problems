import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Non_Overlapping_Intervals {

	static class Pair{
		
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of intervals :");
		int n = sc.nextInt();
		Pair p[] = new Pair[n];
		
		System.out.println("Enter the intervals :");
		int ar[][] = new int[n][2];
		
		for(int i = 0; i < n; i++) {
			
			ar[i][0] = sc.nextInt();
			ar[i][1] = sc.nextInt();
			p[i] = new Pair(ar[i][0], ar[i][1]);
		}
		// The idea is sort the intervals in such a way that all the shorter intervals comes before the larger intervals
		// So to do this we will sort the intervals on the basis of smaller end points (i.e., y1 & y2)
		// If the end points of both the intervals are same then we will sort on the basis of greater end points.
		
		Arrays.sort(p, new Comparator<Pair>(){

			public int compare(Pair o1, Pair o2) {
				
				int x1 = o1.x;
				int y1 = o1.y;
				
				int x2 = o2.x;
				int y2 = o2.y;
				
				if(y1 != y2)
					return y1 - y2;
				return x2 - x1;
			}	
		});
//		for(Pair i : p)
//			System.out.println(i.x+" "+i.y);
		int count = 0;
		int x1 = p[0].x;
		int y1 = p[0].y;
		
		for(int i = 1; i < p.length; i++) {
			
			int x2 = p[i].x;
			int y2 = p[i].y;
			
			if(x2 < y1) {
				count ++;
			}
			else {
				x1 = x2;
				y1 = y2;
			}
		}
		System.out.println(count);
	}
}
