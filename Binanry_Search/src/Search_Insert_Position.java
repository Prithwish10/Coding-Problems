import java.util.Scanner;

//Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
//You may assume no duplicates in the array.
//
//Example 1:
//
//Input: [1,3,5,6], 5
//Output: 2
//Example 2:
//
//Input: [1,3,5,6], 2
//Output: 1
//Example 3:
//
//Input: [1,3,5,6], 7
//Output: 4
//Example 4:
//
//Input: [1,3,5,6], 0
//Output: 0
class Search_Insert_Position {
    public static int searchInsert(int[] nums, int target) {
        
        if(nums == null || nums.length == 0)
            return 0;
        
        int pos = -1;
        
        int L = 0;
        int R = nums.length - 1;
        
        while(L <= R){
            
            int mid = L + (R - L)/2;
            
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target){
                pos = mid;
                R = mid - 1;
            }
            else
                L = mid + 1;
        }
        
        return pos == -1 ? nums.length : pos;
    }
    public static void main(String args[]) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Enter n :");
    	int n = sc.nextInt();
    	
    	System.out.println("Enter the cost array :");
    	int nums[] = new int[n];
    	
    	for(int i = 0; i < n; i++)
    		nums[i] = sc.nextInt();
    	
    	System.out.println("Enter target :");
    	int target = sc.nextInt();
    	
    	int res = searchInsert(nums, target);
    	System.out.println(res);
    }
}

