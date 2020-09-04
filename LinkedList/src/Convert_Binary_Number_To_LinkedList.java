
public class Convert_Binary_Number_To_LinkedList {

	public int getDecimalValue(ListNode head) {
        
        ListNode node = reverse(head);
        
        return convert(node);
    }
    private ListNode reverse(ListNode head){
        
        if(head == null || head.next == null){
            return head;
        }
        ListNode new_head = reverse(head.next);
        head.next.next = head;
        head.next = null;
        
        return new_head;
    }
    private int convert(ListNode head){
        
        ListNode temp = head;
        int res = 0;
        int p = 0;
        
        while(temp != null){
            
            res += Math.pow(2, p) * temp.val;
            p ++;
            temp = temp.next;
        }
        return res;
    }
}
