package ui;

import domain.BinarySearchTree;

public class BinarySearchTreeDriver {

	public static void main(String[] args) {
		BinarySearchTree<Integer> boom = new BinarySearchTree<Integer>(6);
		boom.addNode(4);
		boom.addNode(8);
		boom.addNode(3);
		boom.addNode(5);
		boom.addNode(7);
		boom.addNode(9);

		printBoomInfo(boom);


	}

	private static void printBoomInfo(BinarySearchTree<Integer> boom) {
		if (boom == null) System.out.println("Lege boom");
		else {
			boom.printInorder();
			System.out.print("\nData zit in boom: " + boom.lookup(2));
			//System.out.println("\nDe grootste waarde uit deze boom = " + boom.searchGreatest());
			//System.out.println("\nDe kleinste waarde uit deze boom = " + boom.searchSmallest());
		}


	}
}
