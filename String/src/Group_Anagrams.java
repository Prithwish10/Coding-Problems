import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class Group_Anagrams {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of strings u want to enter :");
		int n = sc.nextInt();
		
		List<String> list = new ArrayList<>();
		
		System.out.println("Enter the words :");
		
		for(int i = 0; i < n; i++)
			list.add(sc.next());
		
		List<List<String>> res = groupAnagrams(list);
		
		for(List<String> l : res)
			System.out.println(l);
	}
	private static List<List<String>> groupAnagrams(List<String> list){
		
		Map<String, List<String>> map = new HashMap<>();
		
		for(String s : list) {
			
			char ch[] = s.toCharArray();
			Arrays.sort(ch);
			String tmp = new String(ch);
			List<String> l;
			
			if(!map.containsKey(tmp)) {
				
				l = new ArrayList<>();
			}
			else {
				l = map.get(tmp);
			}
			l.add(s);
			map.put(tmp, l);
		}
		
		List<List<String>> res = new ArrayList<>();
		
		for(Map.Entry<String, List<String>> entry : map.entrySet()) {
			
			List<String> l = entry.getValue();
			res.add(l);
		}
		return res;
	}
}
