//Given a non negative integer number num. For every numbers i in the range 0 <= i <= num calculate the number of 1's in their binary representation and return them as an array.
//
//Example 1:
//
//Input: 2
//Output: [0,1,1]
//Example 2:
//
//Input: 5
//Output: [0,1,1,2,1,2]
public class Counting_Bits {

	public int[] countBits(int num) {
        
        int ar[] = new int[num + 1];
        
        for(int i = 0; i <= num; i++){
            
            ar[i] = countSetBits(i);
        }
        return ar;
    }
    private int countSetBits(int n){
        
        int count = 0;
        
        while(n > 0){
            
            n = n & (n - 1);
            count ++;
        }
        return count;
    }
}
