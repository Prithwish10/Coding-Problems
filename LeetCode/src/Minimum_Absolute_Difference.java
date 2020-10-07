//Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements. 
//
//Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
//
//a, b are from arr
//a < b
//b - a equals to the minimum absolute difference of any two elements in arr
// 
//
//Example 1:
//
//Input: arr = [4,2,1,3]
//Output: [[1,2],[2,3],[3,4]]
//Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
//Example 2:
//
//Input: arr = [1,3,6,10,15]
//Output: [[1,3]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Minimum_Absolute_Difference {

	public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(arr == null || arr.length == 0)
            return res;
        
        Arrays.sort(arr);
        
        int n = arr.length, min = Integer.MAX_VALUE;
        
        for(int i = 1; i < n; i ++){
            min = Math.min(min, arr[i] - arr[i - 1]);
        }
        
        for(int i = 1; i < n; i ++){
            
            if(arr[i] - arr[i - 1] == min){
                List<Integer> list = new ArrayList<>();
                list.add(arr[i - 1]);
                list.add(arr[i]);
                res.add(list);
            }
        }
        return res;
    }
}
