
public class Design_Browser_History {

	class ListNode{
	    
	    ListNode next;
	    ListNode prev;
	    String val;
	    
	    ListNode(String val){
	        this.val = val;
	    }
	}
	ListNode head = null;
    ListNode dll;
    
    public Design_Browser_History(String homepage) {
        head = new ListNode(homepage);
        dll = head;
    }
    
    public void visit(String url) {
        
        ListNode temp = new ListNode(url);
        dll.next = temp;
        temp.prev = dll;
        dll = dll.next;
    }
    
    public String back(int steps) {
        
        while(steps > 0 && dll.prev != null){
            dll = dll.prev;
            steps --;
        }
        return dll.val;
    }
    
    public String forward(int steps) {
        
        while(steps > 0 && dll.next != null){
            dll = dll.next;
            steps --;
        }
        return dll.val;
    }
}
