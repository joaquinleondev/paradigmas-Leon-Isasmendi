package linea;

public abstract class Cell {
    private int i;
    private int j;
    public Cell (int i, int j) {
        this.i = i;
        this.j = j;
    }
    public int[] getCoordinates() {
        return new int[]{this.i, this.j};
    }
}

class EmptyCell extends Cell {
    public EmptyCell(int i, int j) {
        super(i, j);
    }

    @Override
    public String toString() {
        return "-";
    }
}

class RedCell extends Cell {
    public RedCell(int i, int j) {
        super(i, j);
    }

    @Override
    public String toString() {
        return "R";
    }
}

class BlueCell extends Cell {
    public BlueCell(int i, int j) {
        super(i, j);
    }

    @Override
    public String toString() {
        return "B";
    }
}