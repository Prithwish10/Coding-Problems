import java.util.Scanner;

public class MergeSort_LinkedList {

	ListNode head;
	ListNode temp;
	
	public MergeSort_LinkedList() {

		head = null;
		temp = head;
	}
	
	public void add(int val) {
		
		ListNode new_node = new ListNode(val);
		
		if(head == null) {
			head = new_node;
			temp = new_node;
		}
		else {
			
			temp.next = new_node;
			temp = temp.next;
		}
	}
	
	public void traverse(ListNode head) {
		
		ListNode temp = head;
		
		while(temp != null) {
			
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
	}
	
	public ListNode sort(ListNode head) {
		
		if(head == null || head.next == null) 
			return head;
			
		ListNode mid = findMiddle(head);
			
		ListNode nextOfMid = mid.next;
		mid.next = null;
			
		ListNode left = sort(head);
		ListNode right = sort(nextOfMid);
		ListNode sortedList = merge(left, right);
		
		return sortedList;
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
	
	public ListNode findMiddle(ListNode head) {
		
		if(head == null)
			return head;
		
		ListNode slow = head;
		ListNode fast = head;
		
		while(fast.next != null && fast.next.next != null) {
			
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	public static void main(String args[]) {
		
		MergeSort_LinkedList ms = new MergeSort_LinkedList();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements :");
		int n = sc.nextInt();
		
		System.out.println("Enter the elements :");
		
		for(int i = 0; i < n; i++)
			ms.add(sc.nextInt());
		
		System.out.println("Original List :");
		ms.traverse(ms.head);
		
		ListNode result = ms.sort(ms.head);
		
		System.out.println("\nSorted List :");
		ms.traverse(result);
	}
}
