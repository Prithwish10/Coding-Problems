//Order of the input may be either in increasing or decreasing order

import java.util.Scanner;
public class Order_Agnostic_Search {

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
		
		//Descending order
		if(ar != null && ar.length > 1 && ar[0] > ar[n - 1]) {
			int res = search(ar, n, key);
			System.out.println("The key is found at position "+ res);
		}
		//Ascending order
		else if(ar != null && ar.length > 1 && ar[0] < ar[n - 1]) {
		
			int res1 = search1(ar, key, n, 0, n - 1);
			System.out.println("The key is found at position "+res1);
		}
		else if(ar.length == 1) {
			if(ar[0] == key)
				System.out.println(0);
			else
				System.out.println(-1);
		}
		else if(ar != null && ar.length == 0)
			System.out.println("No elements in the array :");
		else
			System.out.println("Array is null !!");
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
		
		else if(key > ar[mid])
			return search1(ar, key, n, mid + 1, H);
		
		else
			return search1(ar, key, n, L, mid - 1);
	}
}
