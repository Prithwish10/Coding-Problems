// An array contains both positive and negative numbers in random order. 
//Rearrange the array elements so that positive and negative numbers are placed alternatively. 
//Number of positive and negative numbers need not be equal. If there are more positive numbers they appear at the 
//end of the array. If there are more negative numbers, they too appear in the end of the array.

//For example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9], 
//then the output should be [9, -7, 8, -3, 5, -1, 2, 4, 6]

public class Re_Arrange_Negative_Positive {

	public static void  main(String args[]) {
		
		int ar[] = {10, 2, 7, 9, -5, -6, -7, -3, 0};
	
		reArrange1(ar, ar.length);
	}
	// By this approach the relative position the elements are not retaining. 
	// But the problem demands to restore the relative ordering of the elements.
	
	//Time Complexity : O(n^2)
	//Space : O(1)
	public static void reArrange(int ar[], int n) {
		
		int i = 0;
	    while(i < n - 1){
	        
	    	if(i == 0 && ar[i] < 0) {
	    		
	    		int temp = i + 1;
	    		
	    		while(temp < n && ar[temp] < 0)
	    			temp ++;
	    		
	    		if(temp != n) {
	    			int t = ar[i];
	    			ar[i] = ar[temp];
	    			ar[temp] = t;
	    		}
	    		i ++;
	    	}
	    	else if(ar[i] >= 0 && ar[i + 1] < 0 || ar[i] < 0 && ar[i + 1] >= 0){
	             
	             i++;
	        }
	        else{
	            
	            if(ar[i] >= 0 && ar[i + 1] >= 0){
	                
	                int temp = i + 1;
	                
	                while(temp < n && ar[temp] >= 0)
	                    temp ++;
	                 if(temp != n){   
	                   int t = ar[i + 1];
	                   ar[i + 1] = ar[temp];
	                   ar[temp] = t;
	                 }
	            }
	            else{
	                
	                int temp = i + 1;
	                
	                while(temp < n && ar[temp] < 0)
	                    temp ++;
	                  
	                 if(temp != n){   
	                    int t = ar[i + 1];
	                    ar[i + 1] = ar[temp];
	                    ar[temp] = t;
	                 }
	            }
	            
	            i++;
	        }
	    }
	    for(int j : ar)
	        System.out.print(j+" ");
	    
	   System.out.println();
	}
	
	// This approach also does not maintain the relative order of the elements
	// Time : O(n)
	// Space : O(1)
	public static void reArrange1(int ar[], int n) {
		
		// The following few lines are similar to partition 
        // process of QuickSort.  The idea is to consider 0 
        // as pivot and divide the array around it. 
		
		int i = -1;
		
		for(int j = 0; j < n; j++) {
			
			if(ar[j] < 0) {
				
				i ++;
				
				int temp = ar[i];
				ar[i] = ar[j];
				ar[j] = temp;
			}
		}
		// Now all positive numbers are at end and negative numbers at 
        // the beginning of array. Initialize indexes for starting point 
        // of positive and negative numbers to be swapped 
		int pos = i + 1;
		int neg = 0;
		
		// Increment the negative index by 2 and positive index by 1, i.e., 
        // swap every alternate negative number with next positive number
		while(pos < n && neg < pos && ar[neg] < 0) {
			
			int temp = ar[pos];
			ar[pos] = ar[neg];
			ar[neg] = temp;
			
			neg += 2;
			pos ++;
		}
		
		for(int j : ar)
	        System.out.print(j+" ");
	}
}
