import java.util.ArrayList;
import java.util.List;

class Kids_With_Greatest_Number_Candies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        List<Boolean> res = new ArrayList<Boolean>();
        
        if(candies == null || candies.length == 0)
            return res;
        
        int max = -1;
        
        for(int i : candies)
            if(i > max)
                max = i;
        
        for(int i : candies){
            
            if(i + extraCandies >= max)
                res.add(true);
            else
                res.add(false);
        }
        return res;
    }
}
