import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class SubArray_Sum_Equals_K {

	public static void main(String args[]) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter n :");
		int n = sc.nextInt();
		int ar[] = new int[n];
		
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		
		System.out.println(countSum(ar, 7));
	}
	public static int countSum(int ar[], int k) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		//int cum[] = new int[ar.length];
		
		int temp = 0;
		
//		for(int i = 0; i < cum.length; i++) {
//			temp += ar[i];
//			cum[i] = temp;
//		}
		int sum = 0;
		
		map.put(0, 1);
		temp = 0;
		int count = 0;
		
		for(int i = 0; i < ar.length; i++) {
			
			//temp = ar[i] - k;  
			sum += ar[i];
			
			if(map.containsKey(sum - k)) {	
				count += map.get(sum - k);
			}
			// If the cum[i] is present in the map then we will add the value for that cum[i] key else insert cum[i], 1
			Integer p = map.get(sum);
			if(p == null)
				map.put(sum, 1);
			else
				map.put(sum, p + 1);
			
		}
		return count;
	}
	
	
}
