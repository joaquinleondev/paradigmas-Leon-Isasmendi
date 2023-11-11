package linea;

import java.util.ArrayList;

public class Checker {
    public boolean isFinished(ArrayList<ArrayList<Cell>> gameTable, GameMode gameMode, String actualTurn) {
        return gameMode.isAWinner(gameTable, actualTurn);
    }

    public static boolean checkVerticalWin(String player, ArrayList<ArrayList<Cell>> gameTable) {
        for (ArrayList<Cell> column : gameTable) {
            for (int j = 0; j < column.size() - 4; j++) {
                if (column.get(j).toString().equals(player) &&
                        column.get(j + 1).toString().equals(player) &&
                        column.get(j + 2).toString().equals(player) &&
                        column.get(j + 3).toString().equals(player)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkHorizontalWin(String player, ArrayList<ArrayList<Cell>> gameTable) {
        for (int i = 0; i < gameTable.size() - 1; i++) {
            for (int j = 0; j <= gameTable.get(0).size() - 4; j++) {
                if (gameTable.get(j).get(i).toString().equals(player) &&
                        gameTable.get(j + 1).get(i).toString().equals(player) &&
                        gameTable.get(j + 2).get(i).toString().equals(player) &&
                        gameTable.get(j + 3).get(i).toString().equals(player)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkDiagonalWin(String player, ArrayList<ArrayList<Cell>> gameTable) {
        for (int i = 0; i <= gameTable.get(0).size() - 4; i++) {
            for (int j = 0; j <= gameTable.size() - 4; j++) {
                if (gameTable.get(i).get(j).toString().equals(player) &&
                        gameTable.get(i + 1).get(j + 1).toString().equals(player) &&
                        gameTable.get(i + 2).get(j + 2).toString().equals(player) &&
                        gameTable.get(i + 3).get(j + 3).toString().equals(player)) {
                    return true;
                }
            }
        }
        for (int i = 0; i <= gameTable.get(0).size() - 4; i++) {
            for (int j = 3; j < gameTable.size(); j++) {
                if (gameTable.get(i).get(j).toString().equals(player) &&
                        gameTable.get(i + 1).get(j - 1).toString().equals(player) &&
                        gameTable.get(i + 2).get(j - 2).toString().equals(player) &&
                        gameTable.get(i + 3).get(j - 3).toString().equals(player)) {
                    return true;
                }
            }
        }
        return false;
    }
}
