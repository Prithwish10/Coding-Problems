//Find the best time to buy and sell a stock with 1 transaction
public class Buying_And_Selling_Stock_1_Transaction {

	public static void main(String args[]) {
		
		int ar[] = {100, 80, 120, 130, 70, 60, 100, 125};
		
		findMaxProfit1(ar, ar.length);
	}
	public static void findMaxProfit(int ar[], int n) {
		
		int maxProfit = 0;
		int buying_Price = 0;
		int selling_Price = 0;
		
		for(int i = 0; i < n - 1; i++) {
			
			for(int j = i + 1; j < n; j++) {
				
				if(ar[j] - ar[i] > maxProfit) {
					
					maxProfit = ar[j] - ar[i];
					buying_Price = ar[i];
					selling_Price = ar[j];
				}
			}
		}
		System.out.println(maxProfit);
		System.out.println("BuyingPrice :"+buying_Price+"\nSelling Price :"+selling_Price);
	}
	public static void findMaxProfit1(int ar[], int n) {
		
		int buying_Price = Integer.MAX_VALUE;
		int max_Profit = 0;
		
		for(int i = 0; i < n; i++) {
			
			if(ar[i] < buying_Price)
				buying_Price = ar[i];
			
			else if(ar[i] > buying_Price) {
				max_Profit = Math.max(max_Profit, ar[i] - buying_Price);
			}
		}
		System.out.println(max_Profit);
	}
}
