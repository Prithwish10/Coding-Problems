import java.util.Scanner;
public class Phone_Directory {
	
	TrieNode root;
	
	public Phone_Directory() {
		root = new TrieNode();
	}
	
	public static void main(String args[]) {
		
		Phone_Directory dir = new Phone_Directory();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of contact u want to enter :");
		int n = sc.nextInt();
		
		String contacts[] = new String[n];
		
		System.out.println("Enter the contact names :");
		for(int i = 0; i < n; i++)
			contacts[i] = sc.next();
		
		dir.insertContacts(contacts, n);
		
		System.out.println("Enter the search keyword :");
		String t = "";
		while(true) {
			
			String s = sc.next();
			t += s;
			if(s.equals("quit"))
				break;
			dir.displayContacts(t);
			
		}
		
	}
	
	public void insertContacts(String contacts[], int n) {
		
		for(int i = 0; i < n; i++) {
			insert(contacts[i]);
		}
	}
	//geeksforgeeks
	private void insert(String contact) {
		
		TrieNode currentNode = root;
		
		for(int i = 0; i < contact.length(); i++) {
			
			char ch = contact.charAt(i);
			
			TrieNode node = currentNode.child.get(ch);
			
			if(node == null) {
				
				node = new TrieNode();
				currentNode.child.put(ch, node);
			}
			
			currentNode = node;
		}
		currentNode.endOfWord = true;
	}
	
	public void displayContacts(String str) {
		
		TrieNode prevNode = root;
		String prefix = "";
		int i;
		for(i = 0; i < str.length(); i++) {
			
			prefix += str.charAt(i);
			
			char lastChar = str.charAt(i);
			
			TrieNode currentNode = prevNode.child.get(lastChar);
			
			if(currentNode == null) {
				
				System.out.println("No Suggestions Found based on the prefix "+prefix);
				i++;
				break;
			}
			
			System.out.println("Suggestions based on "+prefix+" ");
			displayHelper(currentNode, prefix);
			
			prevNode = currentNode;
		}
		for(; i < str.length(); i++) {
			
			prefix += str.charAt(i);
			System.out.println("No Suggestions Found based on the prefix "+prefix);
		}
	}
	
	public void displayHelper(TrieNode current, String prefix) {
		
		if(current.endOfWord) {
			System.out.println(prefix);
			return;
		}
		
		//for(char i = 'a'; i <= 'z'; i++) {
		for(char c : current.child.keySet()) {
			TrieNode next = current.child.get(c);
			
			if(next != null) {
				displayHelper(next, prefix + c);
			}
		}
	}
}
