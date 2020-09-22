
public class Remove_Elements_With_Given_Value {

	public ListNode removeElements(ListNode head, int val) {
        
        if(head == null) return null;
        
        ListNode temp = head;
        
        while(temp.next != null){
            
            if(temp.next.val == val)
                temp.next = temp.next.next;
            else
                temp = temp.next;
        }
        
        if(head != null && head.val == val)
            head = head.next;
        
        return head;
	}
}
