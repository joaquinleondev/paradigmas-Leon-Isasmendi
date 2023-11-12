package linea;

import java.util.ArrayList;

public enum GameType {
    TYPE_A('A') {
        @Override
        public boolean isAWinner(ArrayList<ArrayList<Cell>> gameTable, String actualTurn) {
            return Checker.checkVerticalWin(actualTurn, gameTable) || Checker.checkHorizontalWin(actualTurn, gameTable);
        }
    }, TYPE_B('B') {
        @Override
        public boolean isAWinner(ArrayList<ArrayList<Cell>> gameTable, String actualTurn) {
            return Checker.checkDiagonalWin(actualTurn, gameTable);
        }
    }, TYPE_C('C') {
        @Override
        public boolean isAWinner(ArrayList<ArrayList<Cell>> gameTable, String actualTurn) {
            return Checker.checkVerticalWin(actualTurn, gameTable) || Checker.checkHorizontalWin(actualTurn, gameTable) || Checker.checkDiagonalWin(actualTurn, gameTable);
        }
    };

    private final char gameType;

    GameType(char gameType) {
        this.gameType = gameType;
    }

    public static GameType getGameType(char gameType) {
        for (GameType type : values()) {
            if (type.gameType == gameType) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid game type: " + gameType);
    }

    public abstract boolean isAWinner(ArrayList<ArrayList<Cell>> gameTable, String actualTurn);
}
