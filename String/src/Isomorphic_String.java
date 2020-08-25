
public class Isomorphic_String {

	public boolean isIsomorphic(String s, String t) {
        
        if(s == null || t == null || s.length() != t.length())
            return false;
        // APPROACH - 1
        //Time - O(n)
        //Space - O(n)
        
        /*Map<Character, Character> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            
            if(map.containsKey(sc) && map.get(sc) != tc)
                return false;
            if(!map.containsKey(sc)){
                if(map.containsValue(tc))
                    return false;
                map.put(sc, tc);
            }
        }
        return true;
        */
        // APPROACH - 2
        //Time - O(n)
        //Space - O(n)
        
        int arr1[] = new int[256];
        int arr2[] = new int[256];
        
        for(int i = 0; i < s.length(); i++){
            
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            
            if(arr1[c1] != arr2[c2])
                return false;
            arr1[c1] = i + 1;
            arr2[c2] = i + 1;
        }
        return true;
    }
}
