package domain;

import java.util.ArrayList;

public class Graph {
    private final int[][] gewichtenMatrix;
    private final int inf = Integer.MAX_VALUE;

    public Graph(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
            throw new IllegalArgumentException();
        }
        this.gewichtenMatrix = matrix.clone();
    }

    private int AantalRijenGewichtMatrix() {
        return gewichtenMatrix.length;
    }


    private int[][] initMatrixDijkstra(int vanKnoop) {
        // laatste rij is rij met kortste lengtes vanuit vanKnoop
        int[][] res = new int[this.gewichtenMatrix.length + 1][this.gewichtenMatrix.length];
        for (int rij = 0; rij < gewichtenMatrix.length; rij++) {
            for (int kolom = 0; kolom < gewichtenMatrix.length; kolom++) {
                res[rij][kolom] = gewichtenMatrix[rij][kolom];
                if (res[rij][kolom] == inf) {
                    res[rij][kolom] = 0;
                }
                res[this.gewichtenMatrix.length][rij] = inf;
            }
        }
        for (int i = 0; i < this.gewichtenMatrix.length + 1; i++) {
            res[i][vanKnoop - 1] = 0;
        }
        return res;
    }

    public int[][] Dijkstra(int vanKnoop) {
        int[][] res = initMatrixDijkstra(vanKnoop);
        System.out.println("Initiele matrix: \n");
        printIntMatrix(res);

        // oefening 9.4
// herhaal voor alle knopen
        for (int i = 0; i < AantalRijenGewichtMatrix() - 1; i++) {
// zoek nieuwe minimale afstand
            int min = inf;
            int[] knopenpaar = {inf, inf}; // index die het nieuwe minimum is
            for (int TELLER1 = 0; TELLER1 < AantalRijenGewichtMatrix(); TELLER1++) {
// herhaal voor alle knopen die al bezocht zijn
                if (res[AantalRijenGewichtMatrix()][TELLER1] != inf) {
                    for (int k = 0; k < AantalRijenGewichtMatrix(); k++) {
// als knoop k+1 nog niet gevonden is,
// als er een verbinding is tussen knoop TELLER1+1 en knoop k+1
// en als de verbinding tussen deze knopen korter is
// dan het minimum tot nog toe
                        if (res[AantalRijenGewichtMatrix()][k] == inf && res[TELLER1][k] != 0 & res[AantalRijenGewichtMatrix()][TELLER1] + res[TELLER1][k] < min) {
// onthoud (index van) dit knopenpaar en hun minimum
                            knopenpaar[0] = TELLER1;
                            knopenpaar[1] = k;
                            min = res[AantalRijenGewichtMatrix()][TELLER1] + res[TELLER1][k];
                        }
                    }
                }
            }
// tussenresultaat wegschrijven indien er verbetering is
            if (knopenpaar[0] != inf && knopenpaar[1] != inf) {
// nieuwe minimum
                res[AantalRijenGewichtMatrix()][knopenpaar[1]] = min;
                for (int j = 0; j < AantalRijenGewichtMatrix() - 1; j++) {
// kolom op nul zetten, maar niet op de plaats die het minimum aanlevert
                    if (j != knopenpaar[0])
                        res[j][knopenpaar[1]] = 0;

                }
            }
        }

        return res;
    }


    private ArrayList<Integer> vindPad(int vanKnoop, int naarKnoop, int[][] res) {
        ArrayList<Integer> pad = new ArrayList<>();
        //1 oefening 3.5
        // naarknoop, vanKnoop en k zijn namen van knopen
        // hun index in de matrix is altijd eentje minder want de rijen/kolommen tellen vanaf 0
        pad.add(naarKnoop) ;
        while (naarKnoop !=vanKnoop) {
            int k = 1;
            while (k - 1 < AantalRijenGewichtMatrix() && res[k - 1][naarKnoop - 1] == 0) {
                k++;
                pad.add(0, k);
                naarKnoop = k;
            }
        }
            return pad;
    }

    public String berekenPaden(int vanKnoop) {
        String uit = "";
        int[][] res = this.Dijkstra(vanKnoop);

        System.out.println("Resulterende matrix: \n");
        printIntMatrix(res);

        for (int i = 0; i < AantalRijenGewichtMatrix(); i++) {
            if ((i + 1) != vanKnoop) {
                if (res[AantalRijenGewichtMatrix()][i] == Integer.MAX_VALUE) {
                    uit += "Er is geen pad van " + vanKnoop + " naar " + (i + 1) + "\n";
                } else {
                    uit += "Kortste afstand van " + vanKnoop + " naar " + (i + 1) + " = " + res[AantalRijenGewichtMatrix()][i] + "\n";
                    uit += "via ";

                    int j = (i + 1);
                    ArrayList<Integer> pad = vindPad(vanKnoop, j, res);
                    uit += pad + "\n";
                }
            }
        }

        return uit;
    }

    private static void printIntMatrix(int[][] matrix) {
        String result = "";
        for (int rij = 0; rij < matrix.length; rij++) {
            for (int kolom = 0; kolom < matrix[0].length; kolom++) {
                result += (matrix[rij][kolom] == Integer.MAX_VALUE ? "inf" : matrix[rij][kolom]) + "\t";
            }
            result += "\n";
        }
        result += "\n";

        System.out.println(result);
    }

}
