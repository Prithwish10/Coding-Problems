import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

class Merge_Overlapping_Intervals {
    public static int[][] merge(int[][] arr) {
        
        if(arr.length == 0)
            return new int[0][0];
        
        Intervals ar[] = new Intervals[arr.length];
        
        for(int i = 0; i < arr.length; i++){
            
            ar[i] = new Intervals(arr[i][0], arr[i][1]);
        }
            
        
        Arrays.sort(ar, new Comparator<Intervals>(){
            
            public int compare(Intervals l1, Intervals l2){
                
                return l1.beg - l2.beg;
            }
        });
        
        Stack<Intervals> stack = new Stack<Intervals>();
        
        stack.add(ar[0]);
        
        for(int i = 1; i < ar.length; i++){
            
            Intervals top = stack.peek();
            
            if(top.end < ar[i].beg){
                stack.add(ar[i]);
            }
            else if(top.end < ar[i].end){
                
                top.end = ar[i].end;
                stack.pop();
                stack.add(top);
            }
        }
        
        int res[][] = new int[stack.size()][2];
        int index = res.length - 1;
        
        while(!stack.isEmpty()){
            
            Intervals ele = stack.pop();
            
            res[index][0] = ele.beg;
            res[index][1] = ele.end;
            
            index --;
        }
        return res;
    }
    public static void main(String args[]) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Enter the number of intervals :");
    	int n = sc.nextInt();
    	
    	int ar[][] = new int[n][2];
    	
    	System.out.println("Enter the intervals :");
    	for(int i = 0; i < n; i++) {
    		ar[i][0] = sc.nextInt();
    		ar[i][1] = sc.nextInt();
    	}
    	int res[][] = merge(ar);
    	
    	for(int i[] : res) {
    		System.out.println(i[0]+","+i[1]);
    	}
    }
}
class Intervals{
    
    int beg;
    int end;
    Intervals(int beg, int end){
        this.beg = beg;
        this.end = end;
    }
}
