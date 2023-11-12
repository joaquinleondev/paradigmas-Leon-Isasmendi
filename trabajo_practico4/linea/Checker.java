package linea;

import java.util.ArrayList;

public class Checker {
    public boolean isFinished(ArrayList<ArrayList<Cell>> gameTable, GameType gameMode, String actualTurn) {
        return gameMode.isAWinner(gameTable, actualTurn);
    }

    public static boolean checkVerticalWin(String player, ArrayList<ArrayList<Cell>> gameTable) {
        for (ArrayList<Cell> column : gameTable) {
            for (int j = 0; j <= column.size() - 4; j++) {
                if (column.get(j).toString().equals(player) && column.get(j + 1).toString().equals(player) && column.get(j + 2).toString().equals(player) && column.get(j + 3).toString().equals(player)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkHorizontalWin(String player, ArrayList<ArrayList<Cell>> gameTable) {
        for (int i = 0; i <= gameTable.size() - 4; i++) {
            for (int j = 0; j < gameTable.get(0).size(); j++) {
                if (gameTable.get(i).get(j).toString().equals(player) && gameTable.get(i + 1).get(j).toString().equals(player) && gameTable.get(i + 2).get(j).toString().equals(player) && gameTable.get(i + 3).get(j).toString().equals(player)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkDiagonalWin(String player, ArrayList<ArrayList<Cell>> gameTable) {
        return checkDiagonalWinHelper(player, gameTable) || checkDiagonalWinHelper(player, reverseRows(gameTable));
    }

    private static ArrayList<ArrayList<Cell>> reverseRows(ArrayList<ArrayList<Cell>> gameTable) {
        ArrayList<ArrayList<Cell>> reversedRows = new ArrayList<>();
        for (ArrayList<Cell> row : gameTable) {
            ArrayList<Cell> reversedRow = new ArrayList<>(row);
            java.util.Collections.reverse(reversedRow);
            reversedRows.add(reversedRow);
        }
        return reversedRows;
    }

    private static boolean checkDiagonalWinHelper(String player, ArrayList<ArrayList<Cell>> gameTable) {
        for (int i = 0; i <= gameTable.get(0).size() - 4; i++) {
            for (int j = 0; j <= gameTable.size() - 4; j++) {
                if (gameTable.get(i).get(j).toString().equals(player) && gameTable.get(i + 1).get(j + 1).toString().equals(player) && gameTable.get(i + 2).get(j + 2).toString().equals(player) && gameTable.get(i + 3).get(j + 3).toString().equals(player)) {
                    return true;
                }
            }
        }
        return false;
    }
}
