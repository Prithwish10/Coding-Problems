
public class Buy_And_Sell_Stock {

	public static void main(String args[]) {
		
		int ar[] = {100, 180, 260, 310, 40, 535, 695};
		
		System.out.println(findMaxProfit(ar, ar.length));
	}
	
	public static int findMaxProfit(int ar[], int n) {
		
		if(n == 1)
			return 0;
		
		int maxProfit = 0;
		int local_Min = 0;
		int local_Max = 0;
		
		int i = 0;
		
		while(i < n - 1) {
			
			while(i < n - 1 && ar[i] >= ar[i + 1])
				i ++;
			
			if(i == n - 1)
				break;
			
			local_Min = i;
			i ++;
			
			while(i < n && ar[i] >= ar[i - 1])
				i ++;
			
			local_Max = i - 1;
			
			System.out.println(ar[local_Min]+" "+ar[local_Max]);
			maxProfit += ar[local_Max] - ar[local_Min];
		}
		return maxProfit;
	}
}
