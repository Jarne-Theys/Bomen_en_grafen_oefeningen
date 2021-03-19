package ui;

import domain.BinaryMinHeap;

public class BinaryMinHeapDriver {

	public static void main(String[] args) {
		BinaryMinHeap<Integer> heap = new BinaryMinHeap<>();
		heap.addValue(3);
		heap.addValue(2);
		heap.addValue(1);
		heap.addValue(0);
		heap.addValue(-1);
		heap.addValue(-2);
		heap.addValue(-4);
		heap.addValue(2);
		heap.addValue(-7);
		heap.print();
		System.out.println("Kleinste waarde = " + heap.getMin());
		System.out.println("\n5 x Kleinste waarde verwijderen:");


		for (int i = 1 ; i <= 5; i++){
			System.out.println(heap.removeSmallest());
			heap.print();
		}

		System.out.println("\nGet path van 3, 2 en 5:");

		System.out.println(heap.getPath(3));
		System.out.println(heap.getPath(2));
		System.out.println(heap.getPath(5));


	}

}
