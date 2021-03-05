package domain;

public class BinaryTree<E>{
<<<<<<< HEAD
	public E data;
	public BinaryTree<E> leftTree, rightTree;

=======
	E data;
	BinaryTree<E> leftTree, rightTree;

>>>>>>> 29b7f3afe2e852eb89a406b16ba85ad409a6996e
	public BinaryTree(E data){
		this(data,null,null);
	}

	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree){
		if (data == null) {
			throw new IllegalArgumentException();
		}
		this.data= data;
		this.leftTree= leftTree;
		this.rightTree= rightTree;
	}
	public void printInorder(){
			if (this.leftTree != null) this.leftTree.printInorder();
			System.out.print(this.data + " ");
			if (this.rightTree != null) this.rightTree.printInorder();
	}


	//*ONDERSTAANDE METHODES NIET IMPLEMENTEREN! DEZE MOETEN GEIMPLEMENTEERD WORDEN IN DE BinarySearchTree file!*//
	boolean lookup(E data) {
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	boolean addNode(E data) {
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	boolean removeNode(E data){
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	E searchSmallest(){
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	E searchGreatest(){
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}


}
