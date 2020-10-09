import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class Merge_Intervals {

	public int[][] merge(int[][] intervals) {
        
        if(intervals == null || intervals.length == 0)
            return new int[][]{};
        
        Arrays.sort(intervals, new Comparator<int[]>() {

				public int compare(int[] o1, int[] o2) {
					
					if(o1[0] != o2[0])
						return o1[0] - o2[0];
					return o1[1] - o2[1];
				}	
	    });
        
        List<List<Integer>> res = new ArrayList<>();
        int i = 1;
        int start = intervals[0][0];
        int end = intervals[0][1];
       
        while(i < intervals.length){
            
            int start1 = intervals[i][0];
            int end1 = intervals[i][1];
            
            List<Integer> list = new ArrayList<>();
            
            if(start1 >= start && end1 <= end){
                // System.out.println(start+" "+end);
                i ++;
            }
            
            else if(start1 >= start && start1 <= end){     
                
                end = end1;
                i ++;
                //
            }
            
            else{       
            
                list.add(start);                          
                list.add(end);
                res.add(list);  
                            
                start = start1;
                end = end1;
                
                i ++;
            }   
        }
        List<Integer> list = new ArrayList<>();
        list.add(start);
        list.add(end);
        res.add(list);
       
        int n = res.size();
        
        int ans[][] = new int[n][2];
        
        for(i = 0; i < n; i++){
            ans[i][0] = res.get(i).get(0);
            ans[i][1] = res.get(i).get(1);
        }
        System.out.println(res);
        return ans;
    }
	public int[][] merge_Efficient(int[][] arr) {
        
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
    
}
class Intervals{
    
    int beg;
    int end;
    Intervals(int beg, int end){
        this.beg = beg;
        this.end = end;
    }
}
