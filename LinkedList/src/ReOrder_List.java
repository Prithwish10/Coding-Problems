//You may not modify the values in the list's nodes, only nodes itself may be changed.
//
//Example 1:
//
//Given 1->2->3->4, reorder it to 1->4->2->3.
//Example 2:
//
//Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
public class ReOrder_List {

	public void reorderList(ListNode head) {
        
        if(head == null || head.next == null || head.next.next == null)
            return;
        
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode new_head = slow.next;
        slow.next = null;
        
        new_head = reverse(new_head);
        
        head = merge(head, new_head);
    }
    private ListNode reverse(ListNode head){
        
        if(head.next == null)
            return head;
        
        ListNode new_head = reverse(head.next);
        
        head.next.next = head;
        head.next = null;
        
        return new_head;
    }
    private ListNode merge(ListNode l1, ListNode l2){
        
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        
        while(l1 != null && l2 != null){
            
            temp.next = l1;
            temp = temp.next;
            l1 = l1.next;
            
            temp.next = l2;
            temp = temp.next;
            l2 = l2.next;
        }
        if(l1 != null)
            temp.next = l1;
        if(l2 != null)
            temp.next = l2;
        
        return dummy.next;
    }
}
