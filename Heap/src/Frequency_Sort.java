import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
public class Frequency_Sort {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements");
		int n = sc.nextInt();
		
		Integer ar[] = new Integer[n];
		System.out.println("Enter the elements :");
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		
		List<Integer> list = Arrays.asList(ar);
		
		List<Integer> res = sortByFrequency(list);
		
		System.out.println(res);
		
		List<Integer> res1 = sortByFrequency1(list);
		System.out.println(res1);
	}
	
	public static List<Integer> sortByFrequency(List<Integer> list){
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(Integer i : list) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		
		Collections.sort(list, (n1, n2) -> {

			int freq1 = map.get(n1);
			int freq2 = map.get(n2);
			
			if(freq1 != freq2)
				return freq2 - freq1;
			
			return n1 - n2;
		});
		return list;
	}
	
	public static List<Integer> sortByFrequency1(List<Integer> list){
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(Integer i : list) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		
		Frequency f[] = new Frequency[map.size()];
		int index = 0;
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			f[index] = new Frequency(entry.getKey(), entry.getValue());
			index ++;
		}
		
		Arrays.sort(f, new Comparator<Frequency>() {

			@Override
			public int compare(Frequency o1, Frequency o2) {
				
				if(o1.freq != o2.freq)
					return o2.freq - o1.freq;
				else
					return o1.ele - o2.ele;
			}
		});
		List<Integer> res = new ArrayList<Integer>();
		
		for(int i = 0; i < f.length; i++) {
			
			int freq = f[i].freq;
			int ele = f[i].ele;
			
			for(int j = 0; j < freq; j ++) {
				res.add(ele);
			}
		}
		return res;
	}
}
class Frequency{
	
	int ele;
	int freq;
	
	public Frequency(int ele, int freq) {
		
		this.ele = ele;
		this.freq = freq;
	}
}