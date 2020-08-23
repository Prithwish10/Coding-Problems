//Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
//
//Return the linked list sorted as well.
//
//Example 1:
//
//Input: 1->2->3->3->4->4->5
//Output: 1->2->5
//Example 2:
//
//Input: 1->1->1->2->3
//Output: 2->3
import java.util.HashMap;
import java.util.Map;

public class remove_Duplicate_From_Sorted_List_2 {

	//**********time-O(n)*******space-O(n)**********
	public ListNode deleteDuplicates(ListNode head) {
        
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        ListNode temp = head;
        
        while(temp != null){
            
            map.put(temp.val, map.getOrDefault(temp.val, 0) + 1);
            temp = temp.next;
        }
        
        ListNode new_head = new ListNode();
        ListNode t = new_head;
        temp = head;
        
        while(temp != null){
            
            if(map.get(temp.val) == 1){
                t.next = temp;
                t = t.next;
            }
            temp = temp.next;
        }
        t.next = null;
        return new_head.next;
    }
}
