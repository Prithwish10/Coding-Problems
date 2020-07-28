import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Number_Of_SubArraySum_Equals_0 {

	public static void main(String args[]) {
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter n :");
		int n = sc.nextInt();
		int ar[] = new int[n];
		
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		
		System.out.println(countSum(ar, n));
	}
	
	public static int countSum(int ar[], int n) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		
		int count = 0;
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			
			sum += ar[i];
			
			if(map.containsKey(sum))
				count += map.get(sum);
			
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return count;
	}
}
