
public class ReverseList {

	ListNode head;
	ListNode temp;
	
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
	public static void main(String args[]) {
		
		ReverseList rev = new ReverseList();
		System.out.println("Original List ->");
		rev.insert(10);
		rev.insert(20);
		rev.insert(30);
		rev.insert(15);
		rev.traverse(rev.head);
		
		System.out.println("\nReversed List ->");
		rev.head = rev.reverse1(rev.head);
		rev.traverse(rev.head);
	}
}
