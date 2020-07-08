import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class K_Closest_In_Sorted_Array {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements :");
		int n = sc.nextInt();
		
		int ar[] = new int[n];
		System.out.println("Enter the elements :");
		for(int i = 0; i < n; i ++)
			ar[i] = sc.nextInt();
		
		System.out.println("Enter the element whose closest k element we need to find :");
		int key = sc.nextInt();
		
		System.out.println("Enter k :");
		int k = sc.nextInt();
		findKClosest(ar, n, k, key);;
	}
	public static int search(int ar[], int low, int high, int k, int key) {
		
		if(low > high)
			return -1;
		
		int mid = low + (high - low)/2;
		
		if(ar[mid] == key)
			return mid;
		
		else if(key < ar[mid])
			return search(ar, low, high - 1, k, key);
		else
			return search(ar, mid + 1, high, k, key);
	}
	public static void findKClosest(int ar[], int n, int k, int key) {
		
		int keyIndex = search(ar, 0, n, k, key);
		
		int l = keyIndex - 1;
		int h = keyIndex + 1;
		int count = 0;
		
		List<Integer> list = new ArrayList<Integer>();
		
		while(l >= 0 && h < n && count < k) {
			System.out.println(l+" "+h);
			if(ar[keyIndex] - ar[l] < ar[h] - ar[keyIndex]) {
				list.add(ar[l]);
				l --;
			}
			else {
				list.add(ar[h]);
				h ++;
			}
			count ++;
			
		}
		while(count < k && l < 0 && h < n) {
			list.add(ar[h]);
			count ++;
			h ++;
		}
		while(count < k && h == n && l >= 0) {
			list.add(ar[l]);
			count ++;
			l --;
		}
		
		for(int i : list)
			System.out.print(i+" ");
	}
}
