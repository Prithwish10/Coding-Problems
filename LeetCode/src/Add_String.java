import java.util.Scanner;

class Add_String {
    public static String addStrings(String num1, String num2) {
        
        if(num1 == null || num1.length() == 0)
            return num2;
        
        if(num2 == null || num2.length() == 0)
            return num1;
        
        int carry = 0;
        
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int res = 0;
        String result = "";
        
        while(i >= 0 && j >= 0){
            
            int a = Character.getNumericValue(num1.charAt(i));
            int b = Character.getNumericValue(num2.charAt(j));
            
            int sum = a + b + carry;
            
            if(sum > 9){
                res = sum % 10;
                carry = sum / 10;
            }
            else{
                res = sum;
                carry = 0;
            }
            result = res + result;
            
            i --;
            j --;
        }
        while(i >= 0){
            
            int a = Character.getNumericValue(num1.charAt(i));
            
            int sum = a + carry;
            
            if(sum > 9){
                
                res = sum % 10;
                carry = sum / 10;
            }
            else{
                
                res = sum;
                carry = 0;
            }
            result = res + result;
            
            i--;
        }
        while(j >= 0){
            
            int a = Character.getNumericValue(num2.charAt(j));
            
            int sum = a + carry;
            
            if(sum > 9){
                
                res = sum % 10;
                carry = sum / 10;
            }
             else{
                
                res = sum;
                carry = 0;
            }
            
            result = res + result;
            
            j--;
        }
        if(carry != 0)
            result = carry + result;
        
        return result;
    }
    public static void main(String args[]) {
    	
    	Scanner sc = new Scanner(System.in);
    	
    	System.out.println("Enter the 1st string :");
    	String s1 = sc.next();
    	
    	System.out.println("Enter the 2nd String  :");
    	String s2 = sc.next();
    	
    	String res = addStrings(s1, s2);
    	
    	System.out.println(res);
    }
}

