class Valid_Mountain_Array {
    public boolean validMountainArray(int[] A) {
        
        if(A == null || A.length == 0)
            return false;
        int i;
        
        //Strictly increasing 
        for(i = 1; i < A.length; i++){
            
            if(A[i] == A[i - 1])
                return false;
            
            if(A[i] < A[i - 1]){
                if(i == 1)
                    return false;
                else
                    break;
            }   
        }
        //Strictly decreasing
        boolean flag = false;
        for(; i < A.length; i++){
            
            if(A[i] >= A[i - 1])
                return false;
            else
                flag = true;
        }
        return flag;
    }
}
