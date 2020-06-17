import java.util.ArrayList;

public class Boogle {

	public static void main(String args[]) {
		
		char words[][] = {{'G', 'I', 'Z'},
					  	  {'U', 'E', 'K'},
					  	  {'Q', 'S', 'E'}};
	
		ArrayList<String> dictionary = new ArrayList<String>();
		
		dictionary.add("GEEKS");
		dictionary.add("FOR");
		dictionary.add("NO");
		dictionary.add("QUIZ");
		
		int visited[][] = new int[words.length][words[0].length];
		
		for(int i = 0; i < words.length; i++) {
			for(int j = 0; j < words[0].length; j++) {
				findWords(words, dictionary, visited, i, j);
			}
			//System.out.println();
		}
		
	}
	
	static StringBuilder s = new StringBuilder();
	
	public static void findWords(char[][] words, ArrayList<String> dictionary, int[][] visited, int row, int col) {
		
		if(row < 0 || row >= words.length || col < 0 || col >= words.length || visited[row][col] == 1)
			return;
		
		s.append(words[row][col]);
		visited[row][col] = 1;
		//System.out.println(s);
		if(dictionary.contains(s.toString())) {
			
			System.out.println(s);
			
		}
		findWords(words, dictionary, visited, row + 1, col);
		findWords(words, dictionary, visited, row - 1, col);
		findWords(words, dictionary, visited, row, col + 1);
		findWords(words, dictionary, visited, row, col - 1);
		findWords(words, dictionary, visited, row - 1, col + 1);
		findWords(words, dictionary, visited, row - 1, col - 1);
		findWords(words, dictionary, visited, row + 1, col - 1);
		findWords(words, dictionary, visited, row + 1, col + 1);
		
		visited[row][col] = 0;
		s.deleteCharAt(s.length() - 1);
	}
}
