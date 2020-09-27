
public class Add_Two_Numbers {
	public class ListNode {
	     int val;
	     ListNode next;
	     ListNode() {}
	     ListNode(int val) { this.val = val; }
	     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 }
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        
        ListNode temp1 = l1, temp2 = l2, new_head = null, temp3 = new_head;
        int carry = 0, sum = 0;
        
        while(temp1 != null && temp2 != null){
            
            sum = temp1.val + temp2.val + carry;
            carry = sum / 10;
            
            if(sum >= 10){
                
                sum = sum % 10;
            }
            
            if(new_head == null){
                new_head = new ListNode(sum);
                temp3 = new_head;
            }
            else{
                temp3.next = new ListNode(sum);
                temp3 = temp3.next;
            }
            
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        while(temp1 != null){
            
            sum = temp1.val + carry;
            carry = sum / 10;
            //System.out.println(temp1.val+" "+carry);
            if(sum >= 10){
        
                sum = sum % 10;
            }
            temp3.next = new ListNode(sum);
            
            temp3 = temp3.next;
            temp1 = temp1.next;
        }
        
        while(temp2 != null){
            
            sum = temp2.val + carry;
            carry = sum / 10;
            
            if(sum >= 10){
                
                sum = sum % 10;
            }
            temp3.next = new ListNode(sum);
            
            temp3 = temp3.next;
            temp2 = temp2.next;
        }
        if(carry != 0){
            temp3.next = new ListNode(carry);
        }
        new_head = reverseList(new_head);
        
        return new_head;
    }
    private ListNode reverseList(ListNode head){
        
        if(head.next == null)
            return head;
        
        ListNode new_head = reverseList(head.next);
        
        head.next.next = head;
        head.next = null;
        
        return new_head;
    }
}
