package domain;

import java.util.ArrayList;
import java.util.List;




//NIET KUNNEN STARTEN, NA HALFUUR DENKEN OPLOSSiNG GERAADPLEEGD





public class WeightedGraph {
	private final double[][] gewichtenMatrix;
	public final static double infty = Double.POSITIVE_INFINITY;

    public WeightedGraph(double[][] matrix) {
        if (!isGeldigeGewichtenmatrix(matrix))
            throw new IllegalArgumentException("No valid gewichtenmatrix");
        this.gewichtenMatrix = matrix;
    }

    private boolean isGeldigeGewichtenmatrix(double[][] matrix) {
        return matrix != null && matrix.length == matrix[0].length;
    }

    private int getAantalKnopen() {
        return gewichtenMatrix.length;
    }

    public int[][] findDistances() {
        int lengteDistanceMatrix = getAantalKnopen();
        int[][] path = new int[getAantalKnopen()][getAantalKnopen()];
        double[][] distanceMatrix = this.gewichtenMatrix.clone();
        for(int i = 0; i < lengteDistanceMatrix;i++){
            distanceMatrix[i] = distanceMatrix[i].clone();
        }

        for(int k = 0; k < lengteDistanceMatrix;k++){
            for(int rij=0;rij<lengteDistanceMatrix;rij++){
                for(int kolom = 0;kolom<lengteDistanceMatrix;kolom++){
                    if(distanceMatrix[rij][k]+distanceMatrix[k][kolom]<distanceMatrix[rij][kolom]){
                        distanceMatrix[rij][kolom] = distanceMatrix[rij][k] + distanceMatrix[k][kolom];
                        path[rij][kolom] = k+1;
                    }
                }
            }
        }
        return path;
    }

        public int[][] getPointerMatrix() {
        int[][] pointerMatrix = new int[getAantalKnopen()][getAantalKnopen()];
        double[][] DMatrix = this.gewichtenMatrix.clone();
		return pointerMatrix;
	}

	public List<Integer> getShortestPath(int i, int j, int[][] pointer) {
		List<Integer> res = new ArrayList<>();
		return res;
	}

	public int berekenLengte(List<Integer> pad) {
		int som = 0;
		return som;
	}

}
