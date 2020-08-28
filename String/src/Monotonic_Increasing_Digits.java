
public class Monotonic_Increasing_Digits {

	 public int monotoneIncreasingDigits(int N) {
	        
	        char ch[] = String.valueOf(N).toCharArray();
	        int n = ch.length;
	        
	        int j = -2;
	        
	        for(int i = n - 1; i > 0; i--){
	            if(ch[i] < ch[i - 1]){
	                ch[i - 1] --;
	                j = i - 1;
	            }
	        }
	        
	        for(j = j + 1; j < n && j != -1; j++){
	            ch[j] = '9';
	        }
	            
	        //String res = "";
	        boolean flag = false;
	        int ans = 0;
	        
	        for(int i = 0; i < n; i++){
	            
	            if(ch[i] == '0' && !flag)
	                continue;
	            // res += ch[i];
	            ans = ans *10 + ch[i] - '0';
	        }
	        //System.out.println(ans);
	        //return Integer.parseInt(res);
	        return ans;
	    }  
}
