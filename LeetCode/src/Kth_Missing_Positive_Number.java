
public class Kth_Missing_Positive_Number {

	public int findKthPositive(int[] arr, int k) {
        //****************Time - O(n) + O(n + k) *******************
		
        /*Set<Integer> set = new HashSet<>();
        for(int i : arr)
            set.add(i);
        
        int count = 0, ans = -1;
        
        for(int i = 1;; i++){
            
            if(!set.contains(i)){
                ans = i;
                count ++;
            }
            if(count == k)
                break;
        }
        return ans;*/
        
		//*********************Time - O(N n + k)***************
		
        int count = 0, num = 1, i = 0;
        
        while(count < k){
            
            if(i < arr.length && arr[i] == num)
                i ++;
            else
                count ++;
            
            num ++;
        }
        return num - 1;
    }
}
