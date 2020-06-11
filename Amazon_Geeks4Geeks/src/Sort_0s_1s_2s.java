
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class Sort_0s_1s_2s {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++){
		    
		    int n = sc.nextInt();
		    
		    int ar[] = new int[n];
		    
		    for(int j = 0; j < n; j++)
		        ar[j] = sc.nextInt();
		    
		    sort(ar, n);
		}
	}
	public static void sort(int ar[], int n){
	    
	    int low = 0, high = n - 1, p = 0;
	    int temp = 0;
	    
	    while(p <= high){
	        
	        temp = 0;
	        
	        if(ar[p] == 2){
	            
	            temp = ar[high];
	            ar[high] = ar[p];
	            ar[p] = temp;
	            
	            high --;
	        }
	        else if(ar[p] == 0){
	            
	            temp = ar[low];
	            ar[low] = ar[p];
	            ar[p] = temp;
	            
	            low ++;
	            p ++;
	        }
	        else{
	            
	            p++;
	        }
	    }
	    for(int i : ar)
	    	System.out.print(i+" ");
	    System.out.println();
	}
}