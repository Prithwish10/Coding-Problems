
public class Number_Of_Steps_To_Reduce_A_Number_To_Zero {

	public int numberOfSteps (int num) {
        
        /*int count = 0;
        
        while(num > 0){
            
            if(num % 2 == 0)
                num = num / 2;
            else
                num -= 1;
            
            count ++;
        }
        return count;*/
        return helper(num);
    }
    private int helper(int num){
        
        if(num == 0)
            return 0;
        
        if(num % 2 == 0)
            return helper(num / 2) + 1;
        
        else
            return helper(num - 1) + 1;
    }
}
