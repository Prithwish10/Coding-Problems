import java.util.Stack;

public class Insert_Intervals {

	class Intervals{
	    
	    int beg;
	    int end;
	    Intervals(int beg, int end){
	        this.beg = beg;
	        this.end = end;
	    }
	}
	public int[][] insert(int[][] ar, int[] newInterval) {
        
        if(ar == null)
            return new int[][]{{}};
        
        Intervals[] intervals = new Intervals[ar.length + 1];
        
        int i = 0, index = 0;
        boolean flag = false;
        int start = 0, end = 0;
        
        while(i < ar.length){
            
            start = ar[i][0];
            end = ar[i][1];
            
            if(newInterval[0] < start && !flag){
                intervals[index] = new Intervals(newInterval[0], newInterval[1]);
                flag = true;
            }
            else {
                intervals[index] = new Intervals(start, end);
                i ++;
            }
            // System.out.println(intervals[index].beg+" "+intervals[index].end);
            index ++;
        }
        if(!flag)
            intervals[index] = new Intervals(newInterval[0], newInterval[1]);
        
        Stack<Intervals> stack = new Stack<Intervals>();
        
        stack.add(intervals[0]);;
        
        i = 1;
        
        while(i < intervals.length){
            
            Intervals top = stack.peek();
            
            if(top.end < intervals[i].beg){
                stack.add(new Intervals(intervals[i].beg, intervals[i].end));
            }
            else if(top.end < intervals[i].end){
                Intervals tmp = stack.pop();
                tmp.end = Math.max(intervals[i].end, tmp.end);
                stack.add(tmp);
            }
            i++;
        }
        
        int res[][] = new int[stack.size()][2];
        index = res.length - 1;
        
        while(!stack.isEmpty()){
            
            Intervals ele = stack.pop();
            
            res[index][0] = ele.beg;
            res[index][1] = ele.end;
            
            index --;
        }
        return res;
    }
}
