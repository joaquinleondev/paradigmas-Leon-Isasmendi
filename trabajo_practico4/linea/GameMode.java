package linea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class GameMode {
    public static final char EMPTY = '-';
    private final char gameType;

    public GameMode(char gameType) {
        this.gameType = gameType;
    }

    public static GameMode createGameMode(char gameType) {
        GameMode[] gameTypes = {new typeA(), new typeB(), new typeC()};
        return Arrays.stream(gameTypes).filter(gameMode -> gameMode.getGameType() == gameType).collect(Collectors.toCollection(ArrayList::new)).get(0);
    }

    public char getGameType() {
        return this.gameType;
    }

    public boolean check(char[][] gameBoard) {
        return true;
    }
}

class typeA extends GameMode {
    public typeA() {
        super('A');
    }
}

class typeB extends GameMode {
    public typeB() {
        super('B');
    }
}

class typeC extends GameMode {
    public typeC() {
        super('C');
    }
}