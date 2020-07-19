import java.util.Scanner;

public class Merge_Two_Sorted_LinkedList {

	ListNode head1, head2;
	
	public void traverse(ListNode head) {
		
		ListNode temp = head;
		
		while(temp != null) {
			
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
	}
	
	public ListNode merge(ListNode l1, ListNode l2) {
		
		if(l1 == null && l2 == null)
			return null;
		
		if(l1 == null || l2 == null)
			return l1 == null ? l2 : l1;
		
		ListNode dummy = new ListNode();
		ListNode temp = dummy;
		
		while(l1 != null && l2 != null) {
			
			if(l1.val < l2.val) {
				temp.next = l1;
				l1 = l1.next;
			}
			else {
				
				temp.next = l2;
				l2 = l2.next;
			}
			temp = temp.next;
		}
		if(l1 != null)
			temp.next = l1;
		else
			temp.next = l2;
		
		return dummy.next;
	}
	
	public static void main(String args[]) {
		
		Merge_Two_Sorted_LinkedList merge = new Merge_Two_Sorted_LinkedList();
		
		merge.head1 = new ListNode(1);
		merge.head1.next = new ListNode(2);
		merge.head1.next.next = new ListNode(4);
		merge.head1.next.next.next = new ListNode(7);
		
		merge.head2 = new ListNode(3);
		merge.head2.next = new ListNode(6);
		merge.head2.next.next = new ListNode(10);
		merge.head2.next.next.next = new ListNode(12);
		
		ListNode result = merge.merge(merge.head1, merge.head2);
		
		merge.traverse(result);
	}
}
