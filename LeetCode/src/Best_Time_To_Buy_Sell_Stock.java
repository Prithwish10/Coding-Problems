import java.util.Scanner;

class Best_Time_To_Buy_Sell_Stock {
	
    public int maxProfit(int[] prices) {
        
        if(prices.length == 0)
            return 0;
        
        int mgr[] = new int[prices.length];
        
        mgr[prices.length - 1] = prices[prices.length - 1];
        
        for(int i = prices.length - 2; i >= 0; i--){
            
            mgr[i] = Math.max(prices[i], mgr[i + 1]);
        }
        
        int max = 0;
        
        for(int i = 0; i < prices.length; i++){
            max = Math.max(max, mgr[i] - prices[i]);
        }
        return max;
    }


	public static void main(String args[]) {
		Best_Time_To_Buy_Sell_Stock obj = new Best_Time_To_Buy_Sell_Stock();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter n :");
		int n = sc.nextInt();
		int ar[] = new int[n];
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		int res = obj.maxProfit(ar);
		
		
		System.out.print(res);
	}
}
