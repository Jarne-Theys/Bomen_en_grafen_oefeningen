package domain;

public class BinaryTree<E> {
	private E data;
	private BinaryTree<E> leftTree, rightTree;

	public BinaryTree(E data) {
		this(data, null, null);
	}

	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		if (data == null) {
			throw new IllegalArgumentException();
		}
		this.data = data;
		this.leftTree = leftTree;
		this.rightTree = rightTree;
	}

	public void printPreorder() {
		System.out.print(this.data + " ");
		if (this.leftTree != null) this.leftTree.printPreorder();
		if (this.rightTree != null) this.rightTree.printPreorder();
	}

	public void printInorder() {
		if (this.leftTree != null) this.leftTree.printInorder();
		System.out.print(this.data + " ");
		if (this.rightTree != null) this.rightTree.printInorder();
	}

	public void printPostorder() {
		if (this.leftTree != null) this.leftTree.printPostorder();
		if (this.rightTree != null) this.rightTree.printPostorder();
		System.out.print(this.data + " ");
	}

	public int countNodes() {
		return countNodesLeft() + countNodesRight();
	}

	private int countNodesLeft() {
		if (this.leftTree != null) {
			return 1 + this.leftTree.countNodes();
		} else {
			return 0;
		}
	}

	private int countNodesRight() {
		if (this.rightTree != null) {
			return 1 + this.rightTree.countNodes();
		} else {
			return 0;
		}
	}

	/*public int countLeaves(){
		if(leftTree!=null){
			return leftTree.countLeaves();
		} else if(rightTree!=null){
			return rightTree.countLeaves();
		} else{
			return 1;
		}
	}*/
	public int countLeaves(){
		if(this.leftTree!=null && this.rightTree!=null){
			return countLeavesLeft() + countLeavesRight();
		} else if(this.leftTree!=null){
			return countLeavesLeft();
		} else {
			return countLeavesRight();
		}

	}
	private int countLeavesLeft(){
		if(this.rightTree==null && this.leftTree==null){
			return 1;
		} else {
			return this.leftTree.countLeaves();
		}
	}
	private int countLeavesRight(){
		if(this.rightTree==null && this.leftTree==null){
			return 1;
		} else {
			return this.rightTree.countLeaves();
		}
	}

	public int getDepth() {
		return Math.max(getDepthLeft(), getDepthRight());
	}

	private int getDepthLeft() {
		if (this.leftTree != null) {
			return 1 + this.leftTree.getDepthLeft();
		} else if (this.rightTree != null)
		{
			return 1 + this.rightTree.getDepthRight();
		}
		return 0;
	}
	private int getDepthRight(){
		if (this.rightTree != null){
			return 1 + this.rightTree.getDepthRight();
		} else if(this.leftTree != null)
		{
			return 1 + this.leftTree.getDepthLeft();
		}
		return 0;
	}

	public boolean isLeaf(){
		return this.rightTree == null && this.leftTree == null;
	}
	public String isLeafString(boolean isLeaf){
		if(isLeaf){
			return "is een blad";
		} else {
			return "is geen blad";
		}
	}

	public void getDataLeaves(){
		if(this.isLeaf()){
			System.out.print(this.data + " ");
		}if(this.leftTree!=null){
			this.leftTree.getDataLeaves();
		}if(this.rightTree!=null){
			this.rightTree.getDataLeaves();
		}
	}






	//Week 4




	public int count(E data) {
		return countLeft(data)+countRight(data);
	}

	private int countLeft(E data){
		if(this.data == data && this.leftTree!=null){
				return 1 + this.leftTree.count(data);
		} else if(this.leftTree!=null) {
			return this.leftTree.count(data);
		}
		return 0;
	}

	private int countRight(E data){
		if(this.data == data && this.rightTree!=null){
			return 1 + this.rightTree.count(data);
		} else if(this.rightTree!=null) {
			return this.rightTree.count(data);
		}
		return 0;
	}




}
