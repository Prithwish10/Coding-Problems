
public class Add_Numbers_Represented_ByLinkedlIST {

	ListNode head1;
	ListNode head2;
	
	public ListNode insert(ListNode head, int val) {
		
		if(head == null) {
			head = new ListNode(val);
		}
		else {
			ListNode node = new ListNode(val);
			ListNode temp = head;
			
			while(temp.next != null)
				temp = temp.next;
			
			temp.next = node;
		}
		return head;
	}
	
	public void traverse(ListNode head) {
		
		ListNode temp = head;
		
		while(temp != null) {
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
	}
	public ListNode reverse(ListNode node) {
		
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
	
	public ListNode addNumbers(ListNode l1, ListNode l2) {
		
		l1 = reverse(l1);
		l2 = reverse(l2);
		
		ListNode first = l1;
		ListNode second = l2;
		ListNode head = null;
		ListNode temp = null;
		
		int sum = 0;
		int carry = 0;
		int rem = 0;
				
		while(first != null || second != null) {
			
			sum = carry + (first != null ? first.val : 0) + (second != null ? second.val : 0);
			
			carry = sum / 10;
			
			rem = sum % 10;
			
			if(head == null) {
				head = new ListNode(rem);
				temp = head;
			}
			else {
				temp.next = new ListNode(rem);
				temp = temp.next;
			}
			
			if(first != null)
				first = first.next;
			if(second != null)
				second = second.next;
		}
		if(carry == 1)
			temp.next = new ListNode(carry);
		
		head = reverse(head);
		return head;
	}
	public static void main(String args[]) {
		
		Add_Numbers_Represented_ByLinkedlIST obj = new Add_Numbers_Represented_ByLinkedlIST();
		
		obj.head1 = obj.insert(obj.head1, 2);
		obj.head1 = obj.insert(obj.head1, 4);
		obj.head1 = obj.insert(obj.head1, 3);
		
		obj.head2 = obj.insert(obj.head2, 5);
		obj.head2 = obj.insert(obj.head2, 6);
		obj.head2 = obj.insert(obj.head2, 4);
		
		ListNode head = obj.addNumbers(obj.head1, obj.head2);
		
		obj.traverse(head);
	}
}
