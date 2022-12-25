import java.util.*;
public class Heap211 {
	
	static public int[] heap;
	static public int size;
	
	Heap211(){
		heap = new int [30];
		size = 0;
	}
	
	int parent(int index) {
		return index / 2;
	}
	
	int leftChild(int index) {
		return index * 2;
	}
	
	int rightChild(int index) {
		return (index * 2) + 1;
	}
	
	boolean hasParent(int index) {
		return index > 1;
	}
	
	boolean hasLeftChild (int index) {
		return leftChild(index) <= size;
	}
	
	boolean hasRightChild(int index) {
		return rightChild(index) <= size;
	}
	
	boolean isEmpty() {
		return size == 0;
	}
	
	public String toString() {
		StringBuilder result = new StringBuilder ("[");
		if (!isEmpty()) {
			result.append(heap[1]);
			for (int i = 2; i <= size; i++) {
				result.append(", ").append(heap[i]);
			}
		}
		return result + "]";
	}
	
	void swap (int a, int b) {
		int temp = heap[a];
		heap[a] = heap[b];
		heap[b] = temp;		
	}
	
	void add (int value) {
		heap[size +1] = value;
		
		
		int index = size + 1;
		boolean found = false;
		while(!found && hasParent(index)){
			int parent = parent(index);
			if (heap[index] < heap[parent]) {
				swap(index, parent(index));
				index = parent(index);
			} else {
				found = true;
			}
		}
		size++;
	}
	
	int peek() {
		return heap[1];
	}
	
	int remove() {
		int result = peek();
		heap[1] = heap[size];
		size--;
		
		int index = 1;
		boolean found = false;
		while(!found && hasLeftChild(index)) {
			int left = leftChild(index);
			int right = rightChild(index);
			int child = left;
			if (hasRightChild(index) && heap[right] < heap [left]) {
				child = right;
			}
			if(heap[index] > heap[child]) {
				swap(index,child);
				index = child;
			} else {
				found = true;
			}
		}
		return result;
	}
}
