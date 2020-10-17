
public class Design_LinkedList {

	class ListNode{
	    ListNode next;
	    int val;
	    ListNode(int val){
	        this.val = val;
	    }
	}
	 /** Initialize your data structure here. */
    ListNode head, tail;
    int length;
    public Design_LinkedList() {
        
        head = null;
        tail = null;
        length = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        
        if(index < 0 || index >= length)
            return -1;
        
        ListNode temp = head;
        
        for(int i = 0; i < index; i++)
            temp = temp.next;
        
        return temp.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        
        ListNode new_node = new ListNode(val);
        new_node.next = head;
        head = new_node;
        
        if(tail == null)
            tail = new_node;
        
        length ++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        
        if(tail == null)
            addAtHead(val);
        else{
            ListNode new_node = new ListNode(val);
            tail.next = new_node;
            tail = tail.next;
        }
        length ++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        
        if(index < 0 || index > length)
            return;
        
        if(index == 0)
            addAtHead(val);
        else if(index == length)
            addAtTail(val);
        else{
            
            ListNode new_node = new ListNode(val);
            
            ListNode temp = head;
            for(int i = 0; i < index - 1; i++)
                temp = temp.next;
            
            new_node.next = temp.next;
            temp.next = new_node;

            length ++;
        }
        
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        
        if(index < 0 || index >= length)
            return;
        
        if(index == 0){
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            return;
        }
        
        ListNode temp = head;
        for(int i = 0; i < index - 1; i++)
            temp = temp.next;
        
        if(index == length - 1){
            tail = temp;
        }
        
        temp.next = temp.next.next;
        
        length --;
    }
}
