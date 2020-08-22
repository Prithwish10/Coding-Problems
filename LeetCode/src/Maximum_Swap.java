
public class Maximum_Swap {

	public int maximumSwap(int num) {
        
        char ch[] = String.valueOf(num).toCharArray();
        
        int maxVal[] = new int[ch.length];
        maxVal[ch.length - 1] = ch[ch.length - 1] - '0';
        
        for(int i = ch.length - 2; i >= 0; i --)
            maxVal[i] = Math.max(maxVal[i + 1], ch[i] - '0');
        
        for(int i = 0; i < ch.length; i++){
            
            if(ch[i] - '0' >= maxVal[i])
                continue;
            
            else{
                
                int n = maxVal[i];
                int j;
                for(j = ch.length - 1; j >= 0; j --){
                    if(ch[j] - '0' == n)
                        break;
                }
               
                swap(ch, i, j);
                break;
            }
        }
        int res = 0;
        for(int i = 0; i < ch.length; i++)
            res = res * 10 + ch[i] - '0';
        
        return res;
    }
    private void swap(char ch[], int i, int j){
        
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
