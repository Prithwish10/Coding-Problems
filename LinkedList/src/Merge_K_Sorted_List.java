
public class Merge_K_Sorted_List {

	public ListNode mergeKSorted(ListNode node[], int last) {
		
		if(node == null) 
            return null;
        
        if(node.length == 0)
            return null;
		
		int i,j;
		
		while(last != 0) {
			
			i = 0;
			j = last;
			
			while(i < j) {
				
				node[i] = merge(node[i], node[j]);
				
				i ++;
				j --;
				
				if(i >= j) {
					
					last = j;
					break;
				}
			}
		}
		return node[0];
	}
	
	public void traverse(ListNode head) {
		
		ListNode temp = head;
		
		while(temp != null) {
			
			System.out.print(temp.val+" ");
			temp = temp.next;
		}
	}
	
	public ListNode merge(ListNode l1, ListNode l2) {
		
		if(l1 == null && l2 == null)
			return null;
		
		if(l1 == null || l2 == null)
			return l1 == null ? l2 : l1;
		
		ListNode dummy = new ListNode();
		ListNode temp = dummy;
		
		while(l1 != null && l2 != null) {
			
			if(l1.val < l2.val) {
				temp.next = l1;
				l1 = l1.next;
			}
			else {
				
				temp.next = l2;
				l2 = l2.next;
			}
			temp = temp.next;
		}
		if(l1 != null)
			temp.next = l1;
		else
			temp.next = l2;
		
		return dummy.next;
	}
	
	public static void main(String args[]) {
		
		ListNode node[] = new ListNode[5];
		
		node[0] = new ListNode(1);
		node[0].next = new ListNode(5);
		node[0].next.next = new ListNode(7);
		node[0].next.next.next = new ListNode(9);
		
		node[1] = new ListNode(0);
		node[1].next = new ListNode(2);
		node[1].next.next = new ListNode(6);
		node[1].next.next.next = new ListNode(10);
		
		node[2] = new ListNode(1);
		node[2].next = new ListNode(3);
		node[2].next.next = new ListNode(4);
		node[2].next.next.next = new ListNode(12);
		node[2].next.next.next.next = new ListNode(15);
		
		node[3] = new ListNode(8);
		node[3].next = new ListNode(13);
		node[3].next.next = new ListNode(16);
		node[3].next.next.next = new ListNode(19);
		
		node[4] = new ListNode(0);
		node[4].next = new ListNode(14);
		node[4].next.next = new ListNode(18);
		node[4].next.next.next = new ListNode(30);
		
		Merge_K_Sorted_List m = new Merge_K_Sorted_List();
		
		ListNode result = m.mergeKSorted(node, node.length - 1);
		
		m.traverse(result);
	}
}
