import java.util.ArrayList;
import java.util.List;

//Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
//
//Return the intersection of these two interval lists.
//
//(Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.  The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.  For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
//
// 
//
//Example 1:
//
//
//
//Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
//Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
//
//
//import java.util.ArrayList;
//import java.util.List;

public class Interval_List_Intersections {

	public int[][] intervalIntersection(int[][] A, int[][] B) {
        
        int i = 0, j = 0;
        List<List<Integer>> list = new ArrayList<>();
        
        while(i < A.length && j < B.length){
            
            int start1 = A[i][0];
            int end1 = A[i][1];
            
            int start2 = B[j][0];
            int end2 = B[j][1];
                       
            List<Integer> temp = new ArrayList<>();
            
            if(start2 > end1){
                
                i++;
            }
            
            else if(end2 < start1){
                
                j++;
            }
            
            else if(start2 >= start1 && end2 <= end1){
                
                temp.add(start2);
                temp.add(end2);
                
                j++;
            }
            else if(start1 >= start2 && end1 <= end2){
                
                temp.add(start1);
                temp.add(end1);
                
                i++;
            }
            else if(start2 >= start1 && start2 <= end2){
                
                temp.add(start2);
                temp.add(end1);
                
                i++;
            }
            else if(end2 >= start1 && end2 <= end1){
                
                temp.add(start1);
                temp.add(end2);
                
                j ++;
            }
            if(temp.size() != 0)
                list.add(temp);
        }
        int res[][] = new int[list.size()][2];
        int index = 0;
        
        for(List<Integer> l : list){
            
            res[index][0] = l.get(0);
            res[index][1] = l.get(1);
            index ++;
        }
        return res;
    }
}
