//Given a sorted linked list, delete all duplicates such that each element appear only once.
//
//Example 1:
//
//Input: 1->1->2
//Output: 1->2
//Example 2:
//
//Input: 1->1->2->3->3
//Output: 1->2->3

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
