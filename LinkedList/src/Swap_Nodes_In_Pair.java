
public class Swap_Nodes_In_Pair {

	public ListNode swapPairs(ListNode head) {
        
        if(head == null) return null;
        
        if(head.next == null) return head;
        
        ListNode temp = head;
       
        while(temp != null && temp.next != null){
            
            int t = temp.val;
            temp.val = temp.next.val;
            temp.next.val = t;
            
            temp = temp.next.next;
        }
        return head;
    }
}
