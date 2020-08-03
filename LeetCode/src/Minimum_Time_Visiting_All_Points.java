class Minimum_Time_Visiting_All_Points {
    public int minTimeToVisit(int[][] points) {
        
        int minTime = 0;
        
        if(points == null || points.length == 0)
            return minTime;
        
        int x1 = points[0][0];
        int y1 = points[0][1];
        
        for(int i = 1; i < points.length; i++){
            
            int x2 = points[i][0];
            int y2 = points[i][1];
            
            int a = Math.abs(x2 - x1);
            int b = Math.abs(y2 - y1);
            
            if(a < b)  {           
                minTime += a + (b - a);
            }
            else if(a > b){
                minTime += b + (a - b);
            }
            else
                minTime += a;
            
            x1 = x2;
            y1 = y2;
        }
        
        return minTime;
    }  
}
