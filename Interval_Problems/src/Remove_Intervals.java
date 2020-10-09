//Given a list of intervals, remove all intervals that are covered by another interval in the list.
//
//Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.
//
//After doing so, return the number of remaining intervals.
//
// 
//
//Example 1:
//
//Input: intervals = [[1,4],[3,6],[2,8]]
//Output: 2
//Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
//Example 2:
//
//Input: intervals = [[1,4],[2,3]]
//Output: 1
//Example 3:
//
//Input: intervals = [[0,10],[5,12]]
//Output: 2
//Example 4:
//
//Input: intervals = [[3,10],[4,10],[5,11]]
//Output: 2

import java.util.Arrays;
import java.util.Comparator;

public class Remove_Intervals {

	public int removeCoveredIntervals(int[][] intervals) {
        
        if(intervals == null || intervals.length == 0)
            return 0;
        
        Arrays.sort(intervals, new Comparator<int[]>() {

				public int compare(int[] o1, int[] o2) {
					
					if(o1[0] != o2[0])
						return o1[0] - o2[0];
					return o2[1] - o1[1];
				}	
	        });
	        
	        int i = 1, ans = intervals.length;
	        int start = intervals[0][0];
	        int end = intervals[0][1];
	        
	        while(i < intervals.length) {
	        	
	        	int start1 = intervals[i][0];
	        	int end1 = intervals[i][1];
	        	
	        	if(start <= start1 && end >= end1) {
	        		ans --;
	        	}
	        	else {
	        		start = start1;
	        		end = end1;
	        	}
                i++;
	        }
	        return ans;
    }
}
