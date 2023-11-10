package linea;

import java.util.ArrayList;

public class Checker {
    public boolean check(ArrayList<ArrayList<String>> gameTable, GameMode gameType) {
        return gameType.isFinished(gameTable);
    }
}
