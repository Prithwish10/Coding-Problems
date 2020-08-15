
public class Minimum_Number_of_Arrows_to_Burst_Balloons {

	public int findMinArrowShots(int[][] points) {
        
        if(points == null || points.length == 0)
            return 0;
        
        Arrays.sort(points, new Comparator<int[]>(){
            
            public int compare(int[] o1, int[] o2){
                
                if(o1[1] != o2[1])
					return o1[1] - o2[1];
				return o2[0] - o1[0];
            }
        });
        
        int count = 0;
        int start1 = points[0][0];
        int end1 = points[0][1];
        int start2 = 0, end2 = 0;
        
        int i = 0, j = 0;
        
        while(i < points.length - 1){
            count ++;
            j = i + 1;

            while(j < points.length){
                
                start2 = points[j][0];
                end2 = points[j][1];
                
                if(start2 <= end1){
                    j++;
                }
                else
                    break;
            }
            start1 = start2;
            end1 = end2;
            i = j;
                
        }
        System.out.println(i);
        if(i == points.length - 1)
            count ++;
        return count;
    }
}
