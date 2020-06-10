import java.util.Scanner;

class Stack{
	
	int top;
	int ar[];
	
	Stack(int capacity){
		top = -1;
		ar = new int[capacity];
	}
	
	public boolean isEmpty() {
		
		if(top == -1)
			return true;
		else
			return false;
	}
	
	public boolean isFull() {
		
		if(top == ar.length - 1)
			return true;
		else
			return false;
	}
	
	public void push(int n) {
		
		if(!isFull()) {
			
			ar[++top] = n;
		}
		else
			System.out.println("Stak overflow !!");
	}
	
	public int pop() {
		
		int item = 0;
		
		if(!isEmpty()) {
			
			item = ar[top];
			top--;
			return item;
		}
		return -1;
	}
}
public class Next_Higher_Element {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of elements :");
		int n = sc.nextInt();
		
		int ar[] = new int[n];
		
		for(int i = 0; i < n; i++)
			ar[i] = sc.nextInt();
		
		nextGreater(ar, n);
	}
	public static void nextGreater(int ar[], int n) {
		
		Stack s = new Stack(n);
		
		//1) FIRST WE WILL PUSH THE FIRST ELEMENT INTO THE STACK
		s.push(ar[0]);
		
		//2) THEN WE WILL ITERATE FROM THE 1TH INDEX TO N-1
		for(int i = 1; i < n; i++) {
			
			int next = ar[i];
			//3) AT EACH ITERATION WE WILL FIRST CHECK WHETHER THE STACK IS EMPTY OR NOT
			//   IF IT IS NOT EMPTY THEN WE POP THE TOP ELEMENT FROM THE STACK 
			//   AND ITERATE UNTILL THE POPED ELEMENT IS BIGGER THAN THE "NEXT" ELEMENT OR IUNTILL THE STACJK GETS EMPTY
			if(!s.isEmpty()) {
				
				int element = s.pop();
				
				while(next > element) {
					
					System.out.println(element +" -> "+ next);
					
					if(s.isEmpty())
						break;
					element = s.pop();
				}
				//4) IF THE POPED ELEMENT IS GREATER THAN THE NEXT ITEM THEN PUSH THE ELEMENT BACK INTO THE STACK
				if(element > next)
					s.push(element);
			}
			//5) AND FINALLY PUSH THE NEXT ELEMENT INTO THE STACK
			s.push(next);
		}
		//6) AFTER ALL THE ELEMENTS ARE PUSHED INTO THE STACK, THEN THE ELEMENTS THAT ARE LEFT DOES NOT HAVE ANY NEXT 
		// 	 GREATER ELEMENT SO -1 IS PRINTED
		while(!s.isEmpty())
			System.out.println(s.pop() + " -> "+ -1);
	}
}
