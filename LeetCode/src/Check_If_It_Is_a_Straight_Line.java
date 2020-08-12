
public class Check_If_It_Is_a_Straight_Line {

	public boolean checkStraightLine(int[][] coordinates) {
        
        if(coordinates == null || coordinates.length == 0)
            return false;
        
        if(coordinates.length == 1 || coordinates.length == 2)
            return true;
        
        double x1 = coordinates[0][0];
        double y1 = coordinates[0][1];
        
        double x2 = coordinates[1][0];
        double y2 = coordinates[1][1];
        
        double slope = x2 != x1 ? (y2 - y1)/(x2 - x1) : 999.00;
        
        for(int i = 2; i < coordinates.length; i++){
            
            double x = coordinates[i][0];
            double y = coordinates[i][1];
            
            double m = x != x1 ? (y - y1) / (x - x1) : 999.00;
            
            if(m != slope)
                return false;
        }
        return true;
    }
}
