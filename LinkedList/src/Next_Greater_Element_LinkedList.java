import java.util.Stack;

public class Next_Greater_Element_LinkedList {

	int len = 0;
    public int[] nextLargerNodes(ListNode head) {
        
        if(head == null)
            return new int[]{};
        
        ListNode rev_head = reverseList(head, 0);
        
        Stack<Integer> stack = new Stack<>();
        
        int res[] = new int[len];
        
        int index = len - 1;
        ListNode temp = rev_head;
        
        while(temp != null){
            
            while(!stack.isEmpty() && stack.peek() <= temp.val)
                stack.pop();
            
            if(stack.isEmpty())
                res[index --] = 0;
            else
                res[index --] = stack.peek();
            
            stack.add(temp.val);
            
            temp = temp.next;
        }
        return res;
    }
    private ListNode reverseList(ListNode head, int l){
        
        if(head.next == null){
            len = l + 1;
            return head;
        }
        
        ListNode new_head = reverseList(head.next, l+1);
        head.next.next = head;
        head.next = null;
        
        return new_head;
    }
}
