
public class Score_Of_Parenthesis {

	int i = 0;
    public int scoreOfParentheses(String S) {
        
        int score = 0;
        
        while(i < S.length()){
        
            int first = S.charAt(i);
            i++;
        
            if(first == '('){
            
                if(S.charAt(i) == ')'){
                    score += 1;
                    i++;
                }
                else{
                    score = score + 2 * scoreOfParentheses(S);
                }
            }
            else{
                return score;
            }
        }
        return score;
    }
}
