
public class Maximum_Distance_Between_Person {
	
	public int maxDistToClosest(int[] seats) {
        
        int n = seats.length;
        
        int closeToLeft[] = new int[seats.length];
        int closeToRight[] = new int[seats.length];
        
        if(seats[0] == 0)
             closeToLeft[0] = 1;
        if(seats[n - 1] == 0)
             closeToRight[n - 1] = 1;
        
        for(int i = 1; i < n; i++){
            if(seats[i] == 1)
                continue;
            closeToLeft[i] = closeToLeft[i - 1] + 1;
        }
        for(int i = n - 2; i >= 0; i--){
            if(seats[i] == 1)
                continue;
            closeToRight[i] = closeToRight[i + 1] + 1;
        }
        if(closeToLeft[0] == 1)
             closeToLeft[0] = closeToRight[0];
        if(closeToRight[n - 1] == 1)
             closeToRight[n - 1] = closeToLeft[n - 1];
        
        int ans = -1;
        
        for(int i = 0; i < n; i++){
            //System.out.println(closeToLeft[i] +" "+ closeToRight[i]);
            ans = Math.max(ans, Math.min(closeToLeft[i], closeToRight[i]));
        }
        return ans;
    }
}
