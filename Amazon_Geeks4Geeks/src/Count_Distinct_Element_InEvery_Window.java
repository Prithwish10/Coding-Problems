import java.util.HashMap;
import java.util.Map;

public class Count_Distinct_Element_InEvery_Window {

	public static void main(String args[]) {
		
		int ar[] = {1, 2, 1, 3, 4, 2, 3};
		
		//findDistinct(ar, 4);
		countDistinct(ar, 4);
	}
	//Time Complexity : O(n ^ 2)
	//Space Complexity : O(n)
	public static void findDistinct(int ar[], int k) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int i = 0, j = k - 1;
		
		while(j < ar.length) {
			
			for(int a = i; a <= j; a ++) {
				
				map.put(ar[a], map.getOrDefault(ar[a], 0) + 1);
			}
			System.out.print(map.size()+" ");
			map.clear();
			i ++;
			j ++;
		}
	}
	//Time Complexity : O(n)
	//Space Complexity : O(n)
	public static void countDistinct(int ar[], int k) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < k; i++)
			map.put(ar[i], map.getOrDefault(ar[i], 0) + 1);
		
		int count = map.size();
		
		System.out.print(count+" ");
		
		if(map.get(ar[0]) > 1)
			map.put(ar[0], map.get(ar[0]) - 1);
		else {
			map.remove(ar[0]);
			count--;
		}
		
		int i = 1;
		int j = k;

		while(j < ar.length) {
			
			if(map.containsKey(ar[j])) {
				map.put(ar[j], map.get(ar[j]) + 1);
			}
			else {
				count ++;
				map.put(ar[j], 1);
			}
			System.out.print(count+" ");
			
			if(map.get(ar[i]) > 1)
				map.put(ar[i], map.get(ar[i]) - 1);
			else {
				map.remove(ar[i]);
				count --;
			}
			//System.out.println(map);
			i++;
			j++;
			
		}
	}
}
