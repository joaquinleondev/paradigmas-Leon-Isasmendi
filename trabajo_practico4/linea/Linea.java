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
        return Graphics.show(this.gameTable, this.actualTurn(), this.someoneWon(), this.tied());
    }

    public boolean finished() {
        return this.tied() || this.someoneWon();
    }

    public void playRedAt(int position) {
        playTurn(position, Turns.RED);
    }
    public void playBlueAt(int position) {
        playTurn(position, Turns.BLUE);
    }
    // gameTable() is used in LineaTest.java, it won't be used in the terminal version
    public ArrayList<ArrayList<Cell>> gameTable(){
        return this.gameTable;
    }

    private void playTurn(int position, Turns player) {
        IsItPlayerTurn(player);
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

    private void IsItPlayerTurn(Turns player) {
        if (actualTurn().equals(player)) {
            throw new RuntimeException("It's not your turn!");
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

