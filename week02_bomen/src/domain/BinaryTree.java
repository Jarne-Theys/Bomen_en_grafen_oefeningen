package domain;

public class BinaryTree<E> {
	private E data;
	private BinaryTree<E> leftTree, rightTree;
	
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
	
	public void printPreorder(){
			System.out.print(this.data + " ");
			if (this.leftTree != null) this.leftTree.printPreorder();
			if (this.rightTree != null) this.rightTree.printPreorder();
	}

	public void printInorder(){
		if (this.leftTree != null) this.leftTree.printInorder();
		System.out.print(this.data + " ");
		if (this.rightTree != null) this.rightTree.printInorder();
	}

	public void printPostorder(){
		if (this.leftTree != null) this.leftTree.printPostorder();
		if (this.rightTree != null) this.rightTree.printPostorder();
		System.out.print(this.data + " ");
	}

	public int countNodes(){
		return CountNodesLeft() + CountNodesRight();
	}
	private int CountNodesLeft(){
		if (this.leftTree != null){
			return 1 + this.leftTree.countNodes();
		} else {
			return 0;
		}
	}
	private int CountNodesRight(){
		if (this.rightTree != null){
			return 1 + this.rightTree.countNodes();
		} else {
			return 0;
		}
	}

	public int getDepth(){
		return Math.max(getDepthLeft(),getDepthRight());
	}
	private int getDepthRight(){
		if (this.rightTree != null){
			return 1 + this.rightTree.getDepthRight();
		} else {
			return 0;
		}
	}
	private int getDepthLeft(){
		if (this.leftTree != null){
			return 1 + this.leftTree.getDepthLeft();
		} else {
			return 0;
		}
	}

}
