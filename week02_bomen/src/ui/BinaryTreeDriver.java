package ui;

import domain.BinaryTree;

public class BinaryTreeDriver {

	public static void main(String[] args) {
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




		/*
		BinaryTree<String> nodeD = new BinaryTree<>("D");
		BinaryTree<String> nodeF = new BinaryTree<>("F");
		BinaryTree<String> nodeB = new BinaryTree<>("B");
		BinaryTree<String> nodeH = new BinaryTree<>("H");
		// knoop A heeft links D en rechts F
		BinaryTree<String> nodeA = new BinaryTree<>("A",nodeD, nodeF);
		// knoop E heeft links H
		BinaryTree<String> nodeE = new BinaryTree<>("E",nodeH,null);
		// knoop G heeft links E en rechts B
		BinaryTree<String> nodeG = new BinaryTree<>("G",nodeE, nodeB);
		// boom heeft root C en heeft links A en rechts G
		BinaryTree<String> boom = new BinaryTree<>("C",nodeA, nodeG);
		boom.printPreorder();
		*/

	}

}
