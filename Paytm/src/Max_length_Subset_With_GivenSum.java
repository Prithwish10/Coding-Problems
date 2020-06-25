import java.util.HashSet;
import java.util.Set;

public class Max_length_Subset_With_GivenSum {

	public static void main(String args[]) {
		
		int ar[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int notPick[] = {1, 2, 5};
		
		int k = 12;
		
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i : notPick)
			set.add(i);
		
		
		int res = findMax(ar, set, 0, 0, k);
		
		System.out.println(res);
	}
	
	public static int findMax(int ar[], Set<Integer> set, int sum, int pos, int k) {
		
		if(pos >= ar.length)
			return 0;
		
		if(set.contains(ar[pos]))
			return findMax(ar, set, sum, pos + 1, k);
		
		int include = 0;
		int not_incude = 0;
		
		if(sum + ar[pos] <= k)
			include = 1 + findMax(ar, set, sum + ar[pos], pos + 1, k);
		
		not_incude = findMax(ar, set, sum, pos + 1, k);
		
		return Math.max(include, not_incude);
	}
}
