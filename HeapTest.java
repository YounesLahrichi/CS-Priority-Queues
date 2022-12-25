import java.util.*;

public class HeapTest {

	public static void main(String[] args) {
		int actions = 30;
		Random rand = new Random();
		Heap211 heap = new Heap211();
		
		for (int action = 1; action <= actions; action++) {
			int whatAction = rand.nextInt(2);
			
			if (whatAction == 0) {
				int element = rand.nextInt(100);
				heap.add(element);
				System.out.println(action + " Add " + element + ": " + heap.toString());
			}
			
			else if(whatAction == 1 ) {
				if(heap.isEmpty()) {
					action = action - 1;
				} else {
					int element = heap.remove();
					System.out.println(action + " Remove " + element + ": " + heap.toString());
				}
			}
		}

	}

}
