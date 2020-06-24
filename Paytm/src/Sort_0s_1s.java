
public class Sort_0s_1s {

	public static void main(String args[]) {
		
		int ar[] = {0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1};
		
		sort(ar, ar.length);
	}
	//Using two pointer technique
	//Variation of  Dutch Flag Problem
	public static void sort(int ar[], int n) {
		
		int low = 0;
		int high = n - 1;
		
		while(low <= high) {
			
			if(ar[low] == 0)
				low ++;
			else if(ar[low] == 1) {
				
				int temp = ar[low];
				ar[low] = ar[high];
				ar[high] = temp;
				
				high --;
			}
		}
		
		for(int k : ar)
			System.out.print(k+" ");
	}
}
