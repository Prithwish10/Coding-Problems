
public class Long_Pressed_Name {

	public boolean isLongPressedName(String name, String typed) {
        
        String res = "";
        int i = 0, j = 0;
        if(typed.length() != 0 && name.length() != 0 && name.charAt(0) != typed.charAt(0))
            return false;
        
        while(i < name.length() && j < typed.length()){
            
            char n = name.charAt(i);
            char t = typed.charAt(j);
            
            if(n == t){
                i ++;
                j ++;
            }
            else{
                while(j < typed.length() && name.charAt(i) != typed.charAt(j) && t == typed.charAt(j)){
                    j ++;
                }
                if(j == typed.length() || typed.charAt(j) != n)
                    return false;
            }  
        }
        if(i != name.length())
            return false;
        if(j == typed.length())
            return true;
        
        char c = typed.charAt(j);
        
        while(j < typed.length() && typed.charAt(j) == c)
            j ++;
        
        if(j != typed.length())
            return false;
        
        return true;
    }
}
