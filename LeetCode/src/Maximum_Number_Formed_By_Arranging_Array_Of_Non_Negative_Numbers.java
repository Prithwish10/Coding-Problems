import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Maximum_Number_Formed_By_Arranging_Array_Of_Non_Negative_Numbers {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements :");
		int n = sc.nextInt();
		
		System.out.println("Enter the elements into the array :");
		//int ar[] = new int[n];
		List<Integer> list = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			//ar[i] = sc.nextInt();
			list.add(sc.nextInt());
		}
			
		
		String res = getMaxNumber(list, n);
		System.out.println(res);
	}
	private static String getMaxNumber(List<Integer> list, int n) {
		
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				
				String XY = String.valueOf(o1) + String.valueOf(o2);
				String YX = String.valueOf(o2) + String.valueOf(o1);
				
				return XY.compareTo(YX) > 0 ? -1 : 1;
				
			}
		});
		
		String res = "";
		
		for(int i : list)
			res += i;
		return res;
	}
}
