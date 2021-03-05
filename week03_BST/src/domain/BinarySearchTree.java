package domain;

/*
Update the BinaryTree class in the domain folder with the BinaryTree of week 02
* */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

   public BinarySearchTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
      super(data, leftTree, rightTree);
   }

   public BinarySearchTree(E data) {
      super(data);
   }

   @Override
   public boolean lookup(E data) {
      if (data == null) {
         return false;
      }
      if (this.data.compareTo(data) == 0) {
         return true;
      } else {
         if (this.data.compareTo(data) > 0) {
            return (this.leftTree != null && this.leftTree.lookup(data));
         } else {
            return (this.rightTree != null && this.rightTree.lookup(data));
         }
      }
   }

   @Override
   public boolean addNode(E data) {
      if (data == null || this.data == null) {
         throw new IllegalArgumentException();
      }
      if (data.compareTo(this.data) == 0) {
         return false;
      } else if (this.data.compareTo(data) > 0) {
         if (this.leftTree == null) {
            this.leftTree = new BinarySearchTree<>(data);
            return true;
         } else return (this.leftTree.addNode(data));
      } else if (this.rightTree == null) {
         this.rightTree = new BinarySearchTree<>(data);
         return true;
      } else return (this.rightTree.addNode(data));
   }

   public boolean removeNode(E data) {
      throw new UnsupportedOperationException("Not yet implemented");
   }

   @Override
   public E searchSmallest() {
      if(this.leftTree!=null && !this.isLeaf()){
         return this.leftTree.searchSmallest();
      } else {
         return this.data;
      }
   }

   @Override
   public E searchGreatest() {
      if(this.rightTree!=null && !this.isLeaf()){
         return this.rightTree.searchGreatest();
      } else {
         return this.data;
      }
   }

   public void getPath(E data){
      System.out.println(this.data + " ");
      if(this.data.compareTo(data) > 0){
      }
   }


}


