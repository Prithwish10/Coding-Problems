
public class Rotate_List_By_K {

	public ListNode rotateRight(ListNode head, int k) {
        
        if(head == null)
            return null;
        
        //int len = findLength(head);
        ListNode fast = head;
        int len = 0;
        
        while(fast.next != null){
            len ++;
            fast = fast.next;
        }
        len ++;
        
        if(len < k)
            k = k % len;
        
        if(k == 0 || len == k)
            return head;
        
        ListNode temp = head;
        
        for(int i = 1; i <= len - k - 1; i++){
            temp = temp.next;
        }
        
        ListNode new_head = temp.next;
        temp.next = null;
        
        fast.next = head;
        
        return new_head;
    }
}
