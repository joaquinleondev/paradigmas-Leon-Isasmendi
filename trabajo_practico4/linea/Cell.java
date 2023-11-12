package linea;

public class Cell {
    @Override
    public String toString() {
        return "-";
    }
}

class EmptyCell extends Cell {
    public EmptyCell() {
        super();
    }

}

class RedCell extends Cell {
    public RedCell() {
        super();
    }

    @Override
    public String toString() {
        return "R";
    }
}

class BlueCell extends Cell {
    public BlueCell() {
        super();
    }

    @Override
    public String toString() {
        return "B";
    }
}
