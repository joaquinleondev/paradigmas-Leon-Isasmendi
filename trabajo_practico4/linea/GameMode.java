package linea;

public class GameMode {
    char type;
    public GameMode(char type) {
        this.type = type;
    }

    public char name() {
        return this.type;
    }
}

class typeA extends GameMode {
    public typeA() {
        super('A');
        this.type = 'A';
    }
}

class typeB extends GameMode {
    public typeB() {
        super('B');
        this.type = 'B';
    }
}

class typeC extends GameMode {
    public typeC() {
        super('C');
        this.type = 'C';
    }
}