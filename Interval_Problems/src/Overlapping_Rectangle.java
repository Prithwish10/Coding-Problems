import java.util.Scanner;
public class Overlapping_Rectangle {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int x1, x2, y1, y2;
		
		System.out.println("Enter the top left co-ordinate of the 1st Rectangle(l1) :");
		x1 = sc.nextInt();
		y1 = sc.nextInt();
		
		Point l1 = new Point(x1, y1);
		
		System.out.println("Enter the buttom right co-ordinate of the 1st Rectangle(r1) :");
		x2 = sc.nextInt();
		y2 = sc.nextInt();
		
		Point r1 = new Point(x2, y2);
		
		System.out.println("Enter the top left co-ordinate of the 2nd Rectangle(l2) :");
		x1 = sc.nextInt();
		y1 = sc.nextInt();
		
		Point l2 = new Point(x1, y1);
		
		System.out.println("Enter the buttom right co-ordinate of the 2nd Rectangle(r2) :");
		x2 = sc.nextInt();
		y2 = sc.nextInt();
		
		Point r2 = new Point(x2, y2);
		
		boolean res = isOverlapping(l1, r1, l2, r2);
		
		System.out.println(res == false ? "Not Overlapping" : "Overlapping");
	}
	public static boolean isOverlapping(Point l1, Point r1, Point l2, Point r2) {
		
		if(l2.x > r1.x || l1.x > r2.x)
			return false;
		
		if(r1.y > l2.y || r2.y > l1.y)
			return false;
		
		return true;
	}
}
class Point{
	
	int x, y;
	
	Point(int x, int y){
		
		this.x = x;
		this.y = y;
	}
}