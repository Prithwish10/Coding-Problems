
import java.util.Scanner;
public class First_And_Last_Occurrences {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements :");
		int n = sc.nextInt();
		int ar[] = new int[n];
		System.out.println("Enter the elements");
		for(int i = 0; i < n; i ++)
			ar[i] = sc.nextInt();
		
		System.out.println("Enter the element whose first occurence is to be searched :");
		int key = sc.nextInt();
		
		int res = firstOccurrence(ar, n, key);
		System.out.println("The first occurrence of the key is found at position "+ res);
		
		int res1 = lastOccurrence(ar, n, key);
		System.out.println("The last occurrence of the key is found at position "+res1);
	}
	
	public static int firstOccurrence(int ar[], int n, int key) {
		
		int L = 0;
		int H = n - 1;
		
		int first = -1;
		
		while(L <= H) {
			
			int mid = L + (H - L)/2;
			
			if(ar[mid] == key) {
				first = mid;
				H = mid - 1;
			}
			else if(ar[mid] < key)
				L = mid + 1;
			else
				H = mid - 1;
		}
		return first;
	}
	public static int lastOccurrence(int ar[], int n, int key) {
		
		int L = 0;
		int H = n - 1;
		
		int last = -1;
		
		while(L <= H) {
			
			int mid = L + (H - L)/2;
			
			if(ar[mid] == key) {
				last = mid;
				L = mid + 1;
			}
			else if(ar[mid] < key)
				L = mid + 1;
			else
				H = mid - 1;
		}
		return last;
	}
}