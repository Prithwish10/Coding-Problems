
public class Reverse_Only_Letter {

	 public static String reverseOnlyLetters(String s) {
	        
	        char ch[] = s.toCharArray();
	        int n = ch.length;
	        int i = 0;
	        int j = n - 1;
	        
	        while(i < j){
	            
	            int first = ch[i];
	            int last = ch[j];
	            
	            //If first and last character both are letters
	            if(((first >= 65 && first <= 90) || (first >= 97 && first <= 122)) 
	            		&& ((last >= 65 && last <= 90) || (last >= 97 && last <= 122))){
	                
	                char temp = ch[i];
	                ch[i] = ch[j];
	                ch[j] = temp;
	                
	                i++;
	                j--;
	            }
	            else if(!(first >= 65 && first <= 90) && !(first >= 97 && first <= 122)) {
	            	
	            	i++;
	            }
	            else if(!(last >= 65 && last <= 90) && !(last >= 97 && last <= 122)) {
	            	
	            	j --;
	            }
	        }
	        return new String(ch);
	  }
	 public static void main(String args[]) {
		 
		 System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
	 }
}
