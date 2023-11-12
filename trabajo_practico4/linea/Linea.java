package linea;

import java.util.ArrayList;
import java.util.Objects;

public class Linea {
    private final int base;
    private final int height;
    private final GameType gameType;
    private final ArrayList<ArrayList<Cell>> gameTable;
    private final ArrayList<Turns> turns = new ArrayList<>();
    private final Checker checker = new Checker();

    public Linea(int base, int height, char gameType) {
        this.base = base;
        this.height = height;
        this.gameType = GameType.getGameType(gameType);
        this.gameTable = new ArrayList<>();
        for (int i = 0; i < base; i++) {
            ArrayList<Cell> row = new ArrayList<>();
            for (int j = 0; j < height; j++) {
                row.add(new EmptyCell());
            }
            this.gameTable.add(row);
        }
        this.turns.add(Turns.BLUE);
    }

    public String show() {
        StringBuilder result = new StringBuilder();
        result.append("| ");
        for (int i = 0; i < this.base; i++) {
            result.append(i + 1).append(" ");
        }
        result.append("|\n");

        for (int i = this.height - 1; i >= 0; i--) {
            result.append("| ");
            for (int j = 0; j < this.base; j++) {
                result.append(this.gameTable.get(j).get(i)).append(" ");
            }
            result.append("|\n");
        }

        return result.toString();
    }

    public boolean finished() {
        return !this.tied() && !this.someoneWon();
    }

    public void playAt(int position) {
        if (Objects.equals(this.turns.get(turns.size() - 1).getValue(), "R")) {
            playTurn(position, Turns.BLUE);
        } else {
            playTurn(position, Turns.RED);
        }
    }

    private void playTurn(int position, Turns player) {
        checkPosition(position);

        for (int i = 0; i < this.height; i++) {
            if (this.gameTable.get(position - 1).get(i) instanceof EmptyCell) {
                int[] coordsToUpdate = {position - 1, i};
                this.gameTable.get(coordsToUpdate[0]).set(coordsToUpdate[1], player.returnCell());
                turns.add(player);
                return;
            }
        }
    }

    private boolean someoneWon() {
        return this.checker.isFinished(this.gameTable, this.gameType, this.actualTurn().getValue());
    }

    private boolean tied() {
        return base * height == turns.size() - 1;
    }

    private void checkPosition(int position) {
        if (position < 1 || position > this.base) {
            throw new RuntimeException("Position out of bounds");
        }
        if (!(this.gameTable.get(position - 1).get(this.height - 1) instanceof EmptyCell)) {
            throw new RuntimeException("Column is full");
        }
    }

    private Turns actualTurn() {
        return this.turns.get(this.turns.size() - 1);
    }

}

