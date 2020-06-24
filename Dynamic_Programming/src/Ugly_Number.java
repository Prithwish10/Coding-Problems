import java.util.HashMap;
import java.util.Map;

public class Ugly_Number {

	public static void main(String args[]) {
		
		int n = 100;
		int ar[] = new int[5];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(5);
		map.put(1,  8);
		System.out.println(map.size());
		//find(n);
	}
	public static void find(int n) {
		
		int i = 2;
		int c = 1;
		while(true) {
			
			if((i % 2 == 0) || (i % 3 == 0) || (i % 5 == 0)) {
				
				 c ++;
				 System.out.print(i+" ");
			}
			if(c == n)
				break;
			i++;
		}
	}
}
