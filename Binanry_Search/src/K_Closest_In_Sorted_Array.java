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
		
		List<Integer> res = findKClosest(ar, n, k, key);
		
		System.out.println(res);
	}
	public static int search(int ar[], int n, int key) {
		
		int L = 0;
		int H = n - 1;
		
		while(L <= H) {
			
			int mid = L + (H - L)/2;
			
			if(ar[mid] == key)
				return mid;
			
			else if(ar[mid] < key) {
				L = mid + 1;
			}
			else {
				H = mid - 1;
			}
		}
			
		if(H < 0)
            return L;
        
        if(L >= n)
            return H;
		
		int hiDiff = Math.abs(ar[H] - key);
		int lowDiff = Math.abs(ar[L] - key);
		
		return hiDiff <= lowDiff ? H : L;
	}
	public static List<Integer> findKClosest(int ar[], int n, int k, int key) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		if(ar == null || ar.length == 0)
			return list;
		
		int keyIndex = search(ar, n, key);
		System.out.println(keyIndex);
		int l = keyIndex - 1;
		int h = keyIndex + 1;
		int count = 1;
		
		
		while(l >= 0 && h < n && count < k) {
			
			if(key - ar[l] <= ar[h] - key) {
				l --;
			}
			else {
				h ++;
			}
			count ++;
			
		}
		while(count < k && l < 0 && h < n) {
			
			count ++;
			h ++;
		}
		while(count < k && h == n && l >= 0) {
			
			count ++;
			l --;
		}
		System.out.println(l+" "+h);
		for(int i = l + 1; i < h; i++)
			list.add(ar[i]);
		
		return list;
	}
}
