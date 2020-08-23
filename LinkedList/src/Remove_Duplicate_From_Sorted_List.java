
public class Remove_Duplicate_From_Sorted_List {

	public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        
        ListNode i = head;
        ListNode j = head;
        
        while(i != null){
            
            j = i.next;
            
            while(j != null && j.val == i.val){
                j = j.next;
            }
            i.next = j;
            i = j;
        }
        return head;
    }
}
