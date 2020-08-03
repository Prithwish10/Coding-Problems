/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class DeleteNode_Without_Head_Reference {
    public void deleteNode(ListNode node) {
        
        if(node == null)
            return;
        
        int temp = node.val;
        node.val = node.next.val;
        node.next.val = temp;
     
        node.next = node.next.next;
    }
}
