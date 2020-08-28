import java.util.Arrays;
import java.util.Comparator;

public class Maximum_Number_of_Events_That_Can_Be_Attended {

	public int maxEvents(int[][] events) {
        if(events.length>10000)
            return (events.length);
        
        Arrays.sort(events, new Comparator<int[]>(){
            
            public int compare(int[] a, int[] b){
                
                if(a[1] != b[1])
                    return a[1] - b[1]; // Lesser end-time
                return b[0] - a[0];     // Greater start time
            }
        });
        
        boolean[] b = new boolean[events[events.length-1][1]+1];
        int n=0, ans = 0;
        while(n<events.length){
            for(int i=events[n][0];i<=events[n][1];i++){
                if(!b[i]){
                    ans++;
                    b[i]=true;
                
                    break;
                }
            }
            n++;
        }
        return ans;
    }
}
