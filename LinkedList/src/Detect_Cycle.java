import java.util.Scanner;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Detect_Cycle {
	
	ListNode head;
	ListNode temp;
	
	public Detect_Cycle() {
		head = null;
		temp = head;
	}
    public boolean hasCycle(ListNode head) {
        
        if(head == null)
            return false;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast)
                return true;
        }
        return false;
    }
    
    public void add(int val) {
		
		ListNode new_node = new ListNode(val);
		
		if(head == null) {
			head = new_node;
			temp = new_node;
		}
		else {
			
			temp.next = new_node;
			temp = temp.next;
		}
	}
    
    public static void main(String args[]) {
    	
    	Detect_Cycle ms = new Detect_Cycle();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements :");
		int n = sc.nextInt();
		
		System.out.println("Enter the elements :");
		
		for(int i = 0; i < n; i++)
			ms.add(sc.nextInt());
		
		//Intentionally creating a loop
		ListNode t = ms.temp;
		t.next = ms.head.next;
	
		System.out.print(ms.hasCycle(ms.head));
    }
}
