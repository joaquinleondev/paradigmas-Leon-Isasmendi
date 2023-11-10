package linea;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class GameMode {
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

    public boolean isFinished(ArrayList<ArrayList<String>> gameTable) {
        return false;
    }
}

class typeA extends GameMode {
    public typeA() {
        super('A');
    }

    @Override
    public boolean isFinished(ArrayList<ArrayList<String>> gameTable) {
        AtomicBoolean isFinished = new AtomicBoolean(false);
        gameTable.forEach(column -> {
            if (column.size() < 4) {
                return;
            }
            for (int i = 0; i < column.size() - 3; i++) {
                String toCheck = column.get(i);
                for (int j = 1; j < 4; j++) {
                    if (!toCheck.equals(column.get(i + j))) {
                        break;
                    }
                    isFinished.set(true);
                }
            }
        });
        return isFinished.get();
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