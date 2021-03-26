package ui;

import domain.BinaryTree;

public class BinaryTreeDriver {

	public static void main(String[] args) {

		//Week 2
		/*
		BinaryTree<String> nodeC = new BinaryTree<>("C");
		BinaryTree<String> nodeE = new BinaryTree<>("E");
		BinaryTree<String> nodeH = new BinaryTree<>("H");
		BinaryTree<String> nodeA = new BinaryTree<>("A");
		BinaryTree<String> nodeD = new BinaryTree<>("D",nodeC,nodeE);
		BinaryTree<String> nodeI = new BinaryTree<>("I",nodeH,null);
		BinaryTree<String> nodeB = new BinaryTree<>("B",nodeA,nodeD);
		BinaryTree<String> nodeG = new BinaryTree<>("G",null,nodeI);
		BinaryTree<String> boom = new BinaryTree<>("F",nodeB,nodeG);
		System.out.print("Pre-order: ");
		boom.printPreorder();
		System.out.print("\n\nIn-order: ");
		boom.printInorder();
		System.out.print("\n\nPost-order: ");
		boom.printPostorder();

		System.out.print("\n\nAantal knopen: "+(boom.countNodes()+1));
		System.out.print("\nAantal bladeren: " + boom.countLeaves());
		System.out.print("\nDiepte: "+(1+boom.getDepth()));
		System.out.print("\nData van bladeren: ");
		boom.getDataLeaves();
		System.out.print("\nnodeE " + nodeE.isLeafString(nodeE.isLeaf()));
		*/





		//Week 4




		BinaryTree<String> nodeE1 = new BinaryTree<>("E");
		BinaryTree<String> nodeE2 = new BinaryTree<>("E");


		BinaryTree<String> nodeC = new BinaryTree<>("C",null,nodeE1);
		BinaryTree<String> nodeE3 = new BinaryTree<>("E");
		BinaryTree<String> nodeH2 = new BinaryTree<>("H",nodeC,nodeE2);
		BinaryTree<String> nodeE4 = new BinaryTree<>("E");


		BinaryTree<String> nodeA = new BinaryTree<>("A");
		BinaryTree<String> nodeH3 = new BinaryTree<>("H",null,nodeE3);
		BinaryTree<String> nodeI = new BinaryTree<>("I",nodeH3,nodeE4);


		BinaryTree<String> nodeH1 = new BinaryTree<>("H",nodeA,nodeH2);
		BinaryTree<String> nodeG = new BinaryTree<>("G",null,nodeI);


		BinaryTree<String> boom = new BinaryTree<>("A",nodeH1,nodeG);


		boom.printPreorder();
		System.out.println("\nAantal voorkomens A: ");
		System.out.println(boom.count("H"));
	}

}
