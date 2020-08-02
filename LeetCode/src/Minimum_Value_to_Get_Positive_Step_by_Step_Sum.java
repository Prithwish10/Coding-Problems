class Minimum_Value_to_Get_Positive_Step_by_Step_Sum {
    public int minStartValue(int[] nums) {
        
        if(nums == null || nums.length == 0)
            return -1;
        
        int startvalue = 1;
        int sum = startvalue;
//              O(N^2)
//         int i;
//         while(true){
            
//             for(i = 0; i < nums.length; i++){
                
//                 sum += nums[i];
//                 if(sum < 1){
//                     break;
//                 }
//             }
//             if(i == nums.length)
//                 return startvalue;
            
//             startvalue ++;
//             sum = startvalue;
//         }
//              O(n)       
        for(int i = 0; i < nums.length; i++){
            
            sum += nums[i];
            
            if(sum < 1){
                
                int temp = sum - startvalue;
                startvalue = Math.abs(temp) + 1;
                sum = temp + startvalue;
            }
        }
        return startvalue;
    }
}
