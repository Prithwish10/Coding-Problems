//In this particular problem we will be going to use Sliding Window Technique
//So our idea is for every window we will be calculate the sum of customers[i], when grumpy[i] = 1
//And by doing this every time we encounter a sum greater than the sum that we have encountered earlier we will update our maxOnesSum along with the start and the end index of that maxOnesSum window
//After this we will just iterate over the grumpy array and whenever we encounter a 0 we will add customers[i] to our max(sum) that we got earlier (we will ignore the zeross of the window from where we have got the max(Sum))

class Grumpy_BookStore_Owner {
    public int maxSatisfied(int[] customers, int[] grumpy, int x) {
        
        if(customers == null || grumpy == null || customers.length != grumpy.length ||                              grumpy.length == 0)
            return 0;
        
        int n = customers.length;
        int m = grumpy.length;
        
        int max  = 0, sum = 0;
        int start = -1, end = -1;
        int ones = 0, maxOnesSum = 0;
        
        int i;
        
        for(i = 0; i < x; i++){
            
            sum += customers[i];
            if(grumpy[i] == 1)
                ones += customers[i];
        }
        
        max = sum;
        start = 0;
        end = x - 1;
        maxOnesSum = ones;
        
        for(; i < n; i++){
            
            sum -= customers[i - x];
            sum += customers[i];
            
            if(grumpy[i - x] == 1)
                ones -= customers[i - x];
            
            if(grumpy[i] == 1)
                ones += customers[i];
            
            if(ones > maxOnesSum){
                
                max = sum;
                start = i - x + 1;
                end = i;
                maxOnesSum = ones;
            }
            
        }
      
        for(int j = 0; j < m; j++){
            
            if(j >= start && j <= end)
                continue;
            
            if(grumpy[j] == 0){
                
                max += customers[j];
            }
        }
        return max;
    }
}

