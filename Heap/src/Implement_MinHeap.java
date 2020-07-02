
public class Implement_MinHeap {

	int ar[] = new int[20];
	int size = 0;
	
	public void insert(int val) {
		
		ar[size] = val;
		int index = size;
		int parent = (size - 1)/2;
		
		while(parent >= 0 && ar[index] < ar[parent]) {
			
			int temp = ar[parent];
			ar[parent] = ar[index];
			ar[index] = temp;
			
			index = parent;
			parent = (index - 1)/2;
		}
		size ++;
	}
	public int getMin() {
		return ar[0];
	}
	
	public void delete() {
		
		ar[0] = ar[this.size - 1];
		size --;
		
		heapify(0);
	}
	public void heapify(int index) {
		
		int l = (index * 2) + 1;
		int r = (index * 2) + 2;
		
		int smallest = index;
		
		if(l < this.size && ar[l] < ar[index])
			smallest = l;
		if(r < this.size && ar[r] < ar[l])
			smallest = r;
		
		if(smallest != index) {
			int temp = ar[index];
			ar[index] = ar[smallest];
			ar[smallest] = temp;
			
			heapify(smallest);
		}
	}
	public static void main(String args[]) {
		
		Implement_MinHeap minHeap = new Implement_MinHeap();
		
		int ar[] = {5, 7, 1, -9, 3, 0, 6, 15, 2, 1};
		
		for(int i : ar)
			minHeap.insert(i);
		
		for(int i : ar) {
			System.out.println(minHeap.getMin()+" ");
			minHeap.delete();
		}
	}
}
