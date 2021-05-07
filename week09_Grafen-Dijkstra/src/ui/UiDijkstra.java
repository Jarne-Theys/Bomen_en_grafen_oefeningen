package ui;

import domain.Graph;

public class UiDijkstra {

	public static void main(String[] args) {
		final int X = Integer.MAX_VALUE;
		// voorbeeld uit de cursus met extra knoop 9. In deze knoop komt geen
		// enkele verbinding aan.
		int[][] gewichtenMatrix = {
				{ 0, 5,  9, X, X,  X,  X,  X,  X },
				{ 5, 0,  3, 8, 10, 11, X,  X,  X },
				{ 9, 3,  0, 2, X,  X,  7,  X,  X },
				{ X, 8,  2, 0, X,  3,  7,  X,  X },
				{ X, 10, X, X, 0,  1,  X,  8,  X },
				{ X, X,  X, 3, 1,  0,  5,  10, X },
				{ X, X,  7, 7, X,  X,  0,  12, X },
				{ X, X,  X, X, 8,  10, 12, 0,  X },
				{ 1, X,  X, X, X,  X,  X,  X,  0 }
		};
		Graph g = new Graph(gewichtenMatrix);
		System.out.println(g.berekenPaden(1));
	}

}
