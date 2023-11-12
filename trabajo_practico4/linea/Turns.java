package linea;

public enum Turns {
    BLUE("B") {
        @Override
        public Cell returnCell() {
            return new BlueCell();
        }
    }, RED("R") {
        @Override
        public Cell returnCell() {
            return new RedCell();
        }
    };

    private final String value;

    Turns(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public abstract Cell returnCell();
}

