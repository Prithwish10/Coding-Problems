
public class Count_Odd_Numbers {

	public int countOdds(int low, int high) {
        
        int count = 0;
        
        for(int i = low; i <= high; i++){
            // if((i ^ 1) == i - 1)
            //     count ++;
            count += (i & 1);
        }
        return count;
    }
}
