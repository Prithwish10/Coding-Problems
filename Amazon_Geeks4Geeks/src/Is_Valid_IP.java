import java.util.ArrayList;
import java.util.List;

public class Is_Valid_IP {

	public static void main(String args[]) {
		
		String str = "55.55.66.57";
			
		System.out.println(isValid(str));
	}
	public static boolean isValid(String str) {
		
		List<String> list = new ArrayList<String>();
		
		String word = "";
		
		if(str.charAt(0) == '.')
			return false;
		if(str.charAt(str.length() - 1) == '.')
			return false;
		
		int i = 0;
		int j = str.length() - 1;
		
		while(i < j) {
			
			if(str.charAt(0) == '.')
				return false;
			if(str.charAt(str.length() - 1) == '.')
				return false;
			
			if(str.charAt(i) == '.' && str.charAt(i + 1) == '.')
				return false;
			
			i ++;
			j --;
		}
		
		for(int a = 0; a < str.length(); a++) {
				
			if(str.charAt(a) != '.')
				word +=str.charAt(a);
			else {
				list.add(word);
				word = "";
			}
		}
		list.add(word);
		if(list.size() != 4)
			return false;
		for(String a : list) {
			
			if(a.length() > 1 && a.charAt(0) == '0')
				return false;
			if(a.length() > 3)
				return false;
			if(!isPoss(a))
				return false;
		}
		return true;
	}
	public static boolean isPoss(String s) {
		
		try{
		    int n = Integer.parseInt(s);
		    if(n >= 0 && n <= 255)
			    return true;
		}
		
		catch(NumberFormatException e){
		    return false;
		}
		return false;
	}
}
