
public class Robot_Return_To_Zero {

	public boolean judgeCircle(String moves) {
        
        if(moves == null || moves.length() == 0)
            return true;
        
        int L = 0, R = 0, U = 0, D = 0;
        
        for(char c : moves.toCharArray()){
            if(c == 'L')
                L ++;
            else if(c == 'R')
                R ++;
            else if(c == 'U')
                U ++;
            else 
                D ++;
        }
        if(L == R && D == U)
            return true;
        return false;
    }
}
