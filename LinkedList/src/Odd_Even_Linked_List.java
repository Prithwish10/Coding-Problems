//Given a singly linked list, group all odd nodes together followed by the even nodes. 
//Please note here we are talking about the node number and not the value in the nodes.
//
//You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
//
//Example 1:
//
//Input: 1->2->3->4->5->NULL
//Output: 1->3->5->2->4->NULL
//Example 2:
//
//Input: 2->1->3->5->6->4->7->NULL
//Output: 2->3->6->7->1->5->4->NULL

public class Odd_Even_Linked_List {

	public ListNode oddEvenList(ListNode head) {
        
        if(head == null || head.next == null)
            return head;
        
        ListNode t1 = head;
        ListNode t2 = head.next;
        ListNode even = t1.next;
        
        while(t1.next != null && t1.next.next != null){
            
            t2 = t1.next;
            t1.next = t2.next;
            t1 = t2.next;
            t2.next = t1.next;
        }
        
        t1.next = even;
        
        return head;
    }
}
