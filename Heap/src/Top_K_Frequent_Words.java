import java.util.*;

class Top_K_Frequent_Words {
	
	public static void main(String args[]) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Enter the numner of words :");
    	int n = sc.nextInt();
    	
    	System.out.println("Enter the words :");
    	String words[] = new String[n];
    	
    	for(int i = 0; i < n; i++)
    		words[i] = sc.next();
    	
    	System.out.println("Enter the k :");
    	int k = sc.nextInt();
    	
    	for(String i : topKFrequent(words, k))
    		System.out.print(i+" ");
    }

    public static List<String> topKFrequent(String[] words, int k) {
        
        List<String> res = new ArrayList<>();
        
        if(words == null || words.length == 0)
            return res;
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String s : words)
            map.put(s, map.getOrDefault(s, 0) + 1);
        
        PriorityQueue<String> minHeap = new PriorityQueue<>(new Comparator<String>(){
            
            public int compare(String s1, String s2){
                
                int freq1 = map.get(s1);
                int freq2 = map.get(s2);
                
                if(freq1 == freq2)
                    return s2.compareTo(s1);
                else
                    return freq1 - freq2;
            }
        });
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            
            minHeap.add(entry.getKey());
            
            if(minHeap.size() > k)
                minHeap.poll();
        }
        
        while(!minHeap.isEmpty()){
            
           res.add(minHeap.poll());
        }
        Collections.reverse(res);
        return res;
    }
}