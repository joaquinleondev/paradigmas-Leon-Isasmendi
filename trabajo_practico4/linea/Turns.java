package linea;

import java.util.Objects;

public abstract class Turns {
    private final String value;

    public Turns(String value) {
        this.value = value;
    }

    public Turns next() {
        return null;
    }

    public String getValue() {
        return value;
    }

    public boolean equals(Turns other) {
        return !Objects.equals(this.value, other.value);
    }

    public Cell returnCell(int[] coords) {
        return null;
    }

}

class Blue extends Turns {
    public Blue() {
        super("B");
    }

    @Override
    public Turns next() {
        return new Red();
    }

    @Override
    public Cell returnCell(int[] coords) {
        return new BlueCell(coords[0], coords[1]);
    }
}

class Red extends Turns {
    public Red() {
        super("R");
    }

    @Override
    public Turns next() {
        return new Blue();
    }

    @Override
    public Cell returnCell(int[] coords) {
        return new RedCell(coords[0], coords[1]);
    }
}


