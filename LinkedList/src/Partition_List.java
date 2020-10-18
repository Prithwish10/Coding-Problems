//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
//You should preserve the original relative order of the nodes in each of the two partitions.
//
//Example:
//
//Input: head = 1->4->3->2->5->2, x = 3
//Output: 1->2->2->4->3->5

public class Partition_List {

	public ListNode partition(ListNode head, int x) {
        
        if(head == null)
            return null;
        boolean flag = false;
        ListNode temp = head;
        ListNode new_head = new ListNode();
        ListNode t = new_head;
        
        while(temp != null){
            
            if(temp.val < x){
                t.next = new ListNode(temp.val);
                t = t.next;
            }
            else if(!flag){
                flag = true;
                ListNode node = new ListNode(temp.val);
                ListNode temp1 = temp;
                
                while(temp1 != null && temp1.next != null){
                    
                    while(temp1.next != null && temp1.next.val < x){
                        
                        t.next = new ListNode(temp1.next.val);
                        t = t.next;
                        temp1.next = temp1.next.next;
                    }
                    temp1 = temp1.next;
                }
                t.next = node;
                t = t.next;
            }
            else{
                t.next = new ListNode(temp.val);
                t = t.next;
            }
            temp = temp.next;
        }
        return new_head.next;
    }
}
