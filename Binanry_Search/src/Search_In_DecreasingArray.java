import java.util.Scanner;
public class Search_In_DecreasingArray {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements :");
		int n = sc.nextInt();
		int ar[] = new int[n];
		System.out.println("Enter the elements");
		for(int i = 0; i < n; i ++)
			ar[i] = sc.nextInt();
		
		System.out.println("Enter the element to be searched :");
		int key = sc.nextInt();
		
		int res = search(ar, n, key);
		System.out.println("The key is found at position "+ res);
		
		int res1 = search1(ar, key, n, 0, n - 1);
		System.out.println("The key is found at position "+res1);
	}
	//Iteratively
	public static int search(int ar[], int n, int key) {
		
		int L = 0;
		int H = n - 1;
		
		while(L <= H) {
			
			int mid = L + (H - L)/2;
			
			if(ar[mid] == key)
				return mid;
			else if(key > ar[mid])
				H = mid - 1;
			else
				L = mid + 1;
		}
		return -1;
	}
	//Recursively
	public static int search1(int ar[], int key, int n, int L, int H) {
		
		if(L > H)
			return -1;
		
		int mid = L + (H - L)/2;
		
		if(ar[mid] == key)
			return mid;
		
		else if(key < ar[mid])
			return search1(ar, key, n, mid + 1, H);
		
		else
			return search1(ar, key, n, L, mid - 1);
	}
}
