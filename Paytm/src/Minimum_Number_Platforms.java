import java.util.Arrays;

//Given arrival and departure times of all trains that reach a railway station, the task is to find the minimum 
//number of platforms required for the railway station so that no train waits.
//We are given two arrays which represent arrival and departure times of trains that stop.

public class Minimum_Number_Platforms {

	public static void main(String args[]) {
		
		int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
		int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
		
		findMinPlatform(arr, dep);
		findMinPlatform1(arr, dep);
	}
	public static void findMinPlatform(int arr[], int dep[]) {
		
		int platforms = 1;
		
		int res = 0;
		
		for(int i = 1; i < arr.length; i++) {
			
			platforms = 1;
			
			for(int j = i - 1; j >= 0; j--) {
				
				if(arr[i] >= arr[j] && arr[i] <= dep[j])
					platforms ++;
			}
			
			res = Math.max(platforms, res);
		}
		System.out.println("Minimum number of platforms required so that no trains had to wait are : "+ res);
	}
	// The idea here is that we first will sort the arrival and departure array
	// Then we will position our two pointers at the 0th index and 1th index respectively of the departure and arrival array
	// Now we will compare and see that if the the arrival time is greater than the departure
	//If the arrival time is less than the departure that means before the previous train has departed, a new train has
	//arrived so the platforms required will increase. And if the departure is less than the arrival than means that the
	//one of our train has departed therefore the platform count will get '-'.
	
	public static void findMinPlatform1(int arr[], int dep[]) {
		
		Arrays.sort(arr);
		Arrays.sort(dep);
		
		int i = 1;
		int j = 0;
		int maxGlobal = 1;
		int platform = 1;
		
		while(i < arr.length && j < dep.length) {
			
			if(arr[i] <= dep[j]) {
				platform ++;
				i ++;
			}
			else if(dep[j] < arr[i]) { //One train has left the platform hence one platform will become free
				platform --;
				j ++;
			}
			maxGlobal = Math.max(platform, maxGlobal);
		}
		System.out.println("Minimum platform required :"+maxGlobal);
	}
}
