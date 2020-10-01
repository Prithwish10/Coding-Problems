
public class Valid_Pallindrome_II {

	public static void main(String args[]) {
		
		String s = "adccbaabtccda";
		System.out.println(validPalindrome(s));
	}
	public static boolean validPalindrome(String s) {
        
        if(s == null) return false;
        if(s.length() == 0) return true;
        
        return isValid(s, 0, s.length() - 1);
    }
	static boolean flag = false;
    public static boolean isValid(String s, int i, int j){
        
        if(i >= j) return true;
        if(s.charAt(i) == s.charAt(j)){
            return isValid(s, i + 1, j - 1);
        }
        else{
            if(flag)
                return false;
            flag = true;
            return isValid(s, i + 1, j) || isValid(s, i, j - 1);
        }
    }
}
