import java.util.PriorityQueue;
import java.util.Comparator;
public class K_Closest_Points_From_Origin {

	public int[][] kClosest(int[][] points, int k) {
        
        if(points == null || points.length == 0 || points.length < k)
            return new int[][]{{}};
        
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>(){
            
            public int compare(Point p1, Point p2){
                
                return p2.dis - p1.dis;
            }
        });
        
        for(int i = 0; i < points.length; i++){
            
            int dis = (int) (Math.pow(points[i][0], 2) + Math.pow(points[i][1], 2));
            
            if(pq.size() < k)
                pq.add(new Point(points[i][0], points[i][1], dis));
            
            else{
                
                if(pq.peek().dis > dis){
                    
                    pq.poll();
                    pq.add(new Point(points[i][0], points[i][1], dis));
                }
            }
        }
        int res[][] = new int[pq.size()][2];
        int index = 0;
        
        while(!pq.isEmpty()){
            
            Point p = pq.poll();
            int x = p.x;
            int y = p.y;
            
            res[index][0] = x;
            res[index][1] = y;
            
            index ++;
        }
        return res;
    }

	class Point{
	    
	    int x, y, dis;
	    
	    Point(int x, int y, int dis){
	        
	        this.x = x;
	        this.y = y;
	        this.dis = dis;
	    }
	}
}
