
public class ReverseList {

	ListNode head;
	ListNode temp;
	
	//Function to Insert Elements into the List
	//Time Complexity : O(1)
	public void insert(int val) {
		
		if(head == null) {
			head = new ListNode(val);
			temp = head;
		}
		else {
			ListNode node = new ListNode(val);
			temp.next = node;
			temp = temp.next;
		}
	}
	
	public void reverseList(ListNode head) {
		
		ListNode t = head;
		reverse(t);
	}
	//Function to reverse a list recursively
	public void reverse(ListNode p) {
		
		if(p.next == null) {
			head = p;
			return;
		}
		reverse(p.next);
		ListNode q = p.next;
		q.next = p;
		p.next = null;
	}
	
	public void traverse(ListNode head) {
		
		ListNode temp = head;
		
		while(temp != null) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
	}
	//Function to reverse a list iteratively
	//Time Complexity : O(n)
	public ListNode reverse1(ListNode node) {
		
		ListNode next = node;
		ListNode prev = null;
		ListNode curr = null;
		
		while(next != null) {
			
			prev = next;
			next = next.next;
			prev.next = curr;
			curr = prev;
		}
		return prev;
	}
	
	//Reverse recursively but in this case return the head of the reverse list
	public ListNode reverse2(ListNode node) {
		
		if(node == null || node.next == null)
			return node;
		
		ListNode rev_head = reverse2(node.next);
		
		node.next.next = node;
		node.next = null;
		
		return rev_head;
	}
	public static void main(String args[]) {
		
		ReverseList rev = new ReverseList();
		System.out.println("Original List ->");
		rev.insert(10);
		rev.insert(20);
		rev.insert(30);
		rev.insert(15);
		rev.traverse(rev.head);
		
		System.out.println("\nReversed List ->");
		rev.head = rev.reverse2(rev.head);
		rev.traverse(rev.head);
	}
}
