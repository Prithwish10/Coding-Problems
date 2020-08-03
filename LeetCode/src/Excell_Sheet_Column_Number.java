class Excell_Sheet_Column_Number {
    public int titleToNumber(String s) {
        
        int sum = 0;
        for(int i = 0; i  < s.length(); i++){
            
            sum *= 26;
            sum += s.charAt(i) - 'A' + 1;
            System.out.println((int)s.charAt(i));
        }
        return sum;
    }
}
