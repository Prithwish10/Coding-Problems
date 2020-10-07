import java.util.Arrays;

public class Minimum_Increase_To_Make_Array_Unique {
	 
	public int minIncrementForUnique(int[] A) {
        
		// T.L.E
		
//      Map<Integer, Integer> map = new HashMap<>();
     
//      for(int i : A)
//          map.put(i, map.getOrDefault(i, 0) + 1);
     
//      int inc = 0;
//      Set<Integer> set = new HashSet<>();
             
//      for(Map.Entry<Integer, Integer> entry : map.entrySet()){
         
//          int key = entry.getKey();
//          int val = entry.getValue();
         
//          if(val > 1){
             
//              int extra = val - 1;
//              int tempKey;
             
//              for(int i = 1; i <= extra; i ++){
                 
//                  tempKey = key;
                 
//                  while(map.containsKey(tempKey) || set.contains(tempKey)){
//                      inc ++;
//                      tempKey ++;
//                  }
//                  set.add(tempKey);
//              }
//          }
//      }
//      return inc;
		
		//Time - O(n log n)
     Arrays.sort(A);
     
     int min = 0;
     
     for(int i = 1; i < A.length; i++){
         
         if(A[i] <= A[i - 1]){
             
             min += A[i - 1] + 1 - A[i];
             
             A[i] = A[i - 1] + 1;
         }
     }
     return min;
 }
}
