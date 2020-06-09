package abd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.Scanner;

class Coordinate{
	
	int x;
	int y;
	
	Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getDistance() {
		
		return x*x + y*y;
	}
}
public class K_ClosestPoint_From_Origin {

	public static List<Coordinate> findClosestPoint(List<Coordinate> cord, int k) {
		
		if(cord.size() == 0)
			return new ArrayList<Coordinate>();
		
		Collections.sort(cord, (n1, n2) -> n1.getDistance() - n2.getDistance());
		
		List<Coordinate> res = new ArrayList<Coordinate>();
		
		for(int i = 0; i < k; i++)
			res.add(cord.get(i));
		
		return res;
	}
	public static void main(String args[]) {
		
		Scanner sc= new Scanner(System.in);
		
		List<Coordinate> cord = new ArrayList<Coordinate>();
		
		System.out.println("How many coordinates do u want to enter  :");
		int n = sc.nextInt();
		
		int x,y;
		
		for(int i = 0; i < n; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			
			Coordinate c = new Coordinate(x, y);
			cord.add(c);
		}
		
		System.out.println("Enter k :");
		int k = sc.nextInt();
		
		List<Coordinate> res = findClosestPoint(cord, k);
		
		for(Coordinate c : res)
			System.out.println("("+c.x+", "+c.y+")");
	}
}
