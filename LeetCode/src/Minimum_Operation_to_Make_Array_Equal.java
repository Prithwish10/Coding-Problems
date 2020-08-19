
public class Minimum_Operation_to_Make_Array_Equal {

	public int minOperations(int n) {
        
        int ar[] = new int[n];
        int mid = 0, count = 0;
        
        for(int i = 0; i < n; i++)
            ar[i] = 2 * i + 1;
        
        if(n % 2 == 0){
            
            mid = (n / 2) - 1;
            
            for(int i = 0; i < mid; i++)
                count += (ar[mid] - ar[i]);
            
            count += mid + 1;
        }
        else{
            
            mid = n / 2;
            
            for(int i = 0; i < mid; i++)
                count += (ar[mid] - ar[i]);
        }
        return count;
    }
}
