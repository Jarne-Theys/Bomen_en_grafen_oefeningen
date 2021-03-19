package domain;

import java.util.ArrayList;

public class BinaryMinHeap<E extends Comparable<E>> {
    private ArrayList<E> values;

    private boolean isEmpty() {
        return values == null || values.size() == 0;
    }

    public void print() {
        if (this.isEmpty())
            System.out.println("De heap is leeg");
        else
            System.out.println(values);
    }

    public E getMin() {
        if (this.isEmpty())
            throw new IllegalStateException("Kan niet zoeken in een lege heap");
        //TO DO zie oefening 3
        return values.get(0);
    }

    public boolean addValue(E value) {
        // geen null toevoegen aan de heap
        if (value == null) throw new IllegalArgumentException();
        // indien de heap leeg is: eerst initialiseren
        if (this.isEmpty())
            values = new ArrayList<E>();

        values.add(value);//achteraan toevoegen
        this.bubbleUp();//bubbleUp vanaf de laatste zie slides theorie
        return true;
    }

    private void bubbleUp() {
        int index = (values.size() - 1);
        int indexOuder = (index - 1) / 2;
        while (indexOuder >= 0) {
            if (values.get(index).compareTo(values.get(indexOuder)) < 0) {
                switchNodes(index, indexOuder);
                index = indexOuder;
                indexOuder = (indexOuder - 1) / 2;
            } else {
                break;
            }
        }
    }

    private void switchNodes(int index, int indexOuder) {
        E hulp = values.get(index);
        values.set(index, values.get(indexOuder));
        values.set(indexOuder, hulp);
    }

    public E removeSmallest() {
        if (this.isEmpty())
            throw new IllegalStateException("Kan niets verwijderen uit een lege boom");
        E res = this.getMin();// res bevat de kleinste = eerste element van de lijst
        this.values.set(0, this.values.get(this.values.size() - 1));// verwissel eerste met de laatste
        this.values.remove(this.values.size() - 1); // verwijder de laatste
        this.bubbleDown(); // bubble down van eerste naar beneden zie theorie
        return res;
    }

    /*private void bubbleDown() {
        int index = 0;
        int indexLinkerKind = 1;
        int indexRechterKind = 2;
        while () {
            if (values.get(index).compareTo(values.get(indexLinkerKind)) > values.get(0).compareTo(values.get(indexRechterKind))) {
                switchNodes(indexRechterKind, index);
                index = indexRechterKind;
                indexRechterKind = indexRechterKind * 2 + 2;
            } else {
                switchNodes(indexLinkerKind, index);
                index = indexLinkerKind;
                indexLinkerKind = indexLinkerKind * 2 + 1;
            }
        }
    }*/

    private int indexRechterKind(int index) {
        return index * 2 + 2;
    }

    private int indexLinkerKind(int index) {
        return index * 2 + 1;
    }

    private boolean kindBestaat(int index){
        if(index >= values.size()){
            return false;
        } else {
            return true;
        }
    }

    private void bubbleDown() {
        int index = 0;
        boolean wisselOK = true;

        while (kindBestaat(indexLinkerKind(index))&& wisselOK) {

            int indexKleinsteKind = indexLinkerKind(index);

            if (kindBestaat(indexRechterKind(index))
                    && values.get(indexKleinsteKind).compareTo(values.get(indexRechterKind(index))) > 0) {
                indexKleinsteKind = indexRechterKind(index);
            }

            if (values.get(index).compareTo(values.get(indexKleinsteKind)) > 0) {

                this.switchNodes(index, indexKleinsteKind);
            } else {
                wisselOK = false;
            }
            index = indexKleinsteKind;
        }
    }

    public ArrayList<E> getPath (E value){
        ArrayList<E> path = new ArrayList<>();
        int index = values.indexOf(value);
        if(index == -1){
            return null;
        }
        path.add(value);
        while(index > 0){
            index = (index - 1) / 2;
            path.add(0,values.get(index));
        }
        return path;
    }

}