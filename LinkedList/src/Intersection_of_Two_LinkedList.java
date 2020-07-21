class Intersection_of_Two_LinkedList
{
	ListNode head1, head2;
	
	public int intersect(ListNode headA, ListNode headB)
	{
		
         int len1 = findLength(headA);
         int len2 = findLength(headB);
         int diff = 0;
         ListNode temp;
         ListNode p;
         
         if(len1 > len2){
             
             temp = headA;
             diff = len1 - len2;
             
             for(int i = 1; i <= diff; i++)
                temp = temp.next;
            
            p = headB;
            
            while(temp != null && p != null){
                
                if(temp.next == p.next)
                    return temp.next.val;
                    
                temp = temp.next;
                p = p.next;
            }
         }
         else if(len1 < len2){
             
             temp = headB;
             diff = len2 - len1;
             
             for(int i = 1; i <= diff; i++)
                temp = temp.next;
                
            p = headA;
            
            while(temp != null && p != null){
                
                if(temp.next == p.next)
                    return temp.next.val;
                    
                temp = temp.next;
                p = p.next;
            }
         }
        
        else{ 
            temp = headA;
            p = headB;
            while(temp != null && p != null){
                
                if(temp.next == p.next)
                    return temp.next.val;
                
                temp = temp.next;
                p = p.next;
            }
        }
        return -1;
	}
	public int findLength(ListNode head){
	    
	    ListNode temp = head;
	    int len = 0;
	    
	    while(temp != null){
	        
	        len++;
	        temp = temp.next;
	    }
	        
	    return len;
	}
}
