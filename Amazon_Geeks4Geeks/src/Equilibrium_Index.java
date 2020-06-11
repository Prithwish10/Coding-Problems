
/*package whatever //do not write package name here */

import java.util.*;

class Equilibrium_Index {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++){
		    
		    int n = sc.nextInt();
		    
		    int ar[] = new int[n];
		    
		    for(int j = 0; j < n; j++)
		        ar[j] = sc.nextInt();
		    
		    int res = findEquib(ar, n);
		    System.out.println(res);
		    
		    int res1 = equib(ar, n);
		    System.out.println(res1);
		}
	}
	public static int findEquib(int ar[], int n){
	    
		int left[] = new int[ar.length];
	    int right[] = new int[ar.length];
	    
	    int s = 0;
	    
	    for(int i = 0; i < ar.length; i++){
	        
	        s += ar[i];
	        
	        left[i] = s;
	    }
	    s = 0;
	    for(int i = ar.length - 1; i >= 0; i--){
	        
	        s += ar[i];
	        
	        right[i] = s;
	    }
        
	    for(int i = 0; i < ar.length; i++){
	        if(left[i] - ar[i] == right[i] - ar[i])
	            return i;
	    }
	    return -1;
	}
	
	public static int equib(int ar[], int n) {
		
		int leftSum = 0;
		int rightSum = 0;
		
		for(int i : ar)
			rightSum +=i;
		for(int i = 0; i < n; i++) {
			
			leftSum += ar[i];
			
			if(leftSum == rightSum)
				return i;
			
			rightSum -= ar[i];
		}
		return -1;
	}
}