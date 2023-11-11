package linea;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
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

    public boolean isAWinner(ArrayList<ArrayList<Cell>> gameTable, String actualTurn) {
        return false;
    }
}
class typeA extends GameMode {
    public typeA() {
        super('A');
    }

    @Override
    public boolean isAWinner(ArrayList<ArrayList<Cell>> gameTable, String actualTurn) {
        return Checker.checkVerticalWin(actualTurn, gameTable) || Checker.checkHorizontalWin(actualTurn, gameTable);
    }


}

class typeB extends GameMode {
    public typeB() {
        super('B');
    }

    @Override
    public boolean isAWinner(ArrayList<ArrayList<Cell>> gameTable, String actualTurn) {
        return Checker.checkDiagonalWin(actualTurn, gameTable);
    }
}

class typeC extends GameMode {
    public typeC() {
        super('C');
    }

    @Override
    public boolean isAWinner(ArrayList<ArrayList<Cell>> gameTable, String actualTurn) {
        return Checker.checkVerticalWin(actualTurn, gameTable) || Checker.checkHorizontalWin(actualTurn, gameTable) || Checker.checkDiagonalWin(actualTurn, gameTable);
    }
}