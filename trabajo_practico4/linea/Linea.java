package linea;

import java.util.ArrayList;

public class Linea {
    private int base;
    private int height;
    private GameMode gameType;
    private final ArrayList<ArrayList<String>> gameTable = new ArrayList<>();
    private final ArrayList<Turns> turns = new ArrayList<>();
    private final Checker checker = new Checker();

    public Linea(int base, int height, char gameType) {
        this.base = base;
        this.height = height;
        this.gameType = new GameMode(gameType);
        for (int i = 0; i < base; i++) {
            ArrayList<String> row = new ArrayList<>();
            this.gameTable.add(row);
        }
        this.turns.add(new Red());
        this.gameType = GameMode.createGameMode(gameType);
    }

    public String show() {
        ArrayList<String> result = new ArrayList<>();
        StringBuilder numberOfColumns = new StringBuilder();
        numberOfColumns.append("| ");
        for (int i = 0; i < this.base; i++) {
            numberOfColumns.append(i + 1);
            numberOfColumns.append(" ");
        }
        numberOfColumns.append("|");
        for (int i = this.height - 1; i >= 0; i--) {
            StringBuilder row = new StringBuilder();
            row.append("| ");
            for (int j = 0; j < this.base; j++) {
                try {
                    row.append(this.gameTable.get(j).get(i));
                } catch (Exception e) {
                    row.append("-");
                }
                row.append(" ");
            }
            row.append("|");
            result.add(row.toString());
        }
        result.add(numberOfColumns.toString());
        return String.join("\n", result);

    }

    public boolean finished() {
        return this.checker.check(this.gameTable, this.gameType);
    }

    public void playRedAt(int position) {
        if (new Red().equals(actualTurn())) {
            throw new RuntimeException("A player can't play twice in a row");
        }
        actualTurnPlaysAt(position);

    }

    public void playBlueAt(int position) {
        if (new Blue().equals(actualTurn())) {
            throw new RuntimeException("A player can't play twice in a row");
        }
        checkPosition(position);
        actualTurnPlaysAt(position);

    }

    private void actualTurnPlaysAt(int position) {
        checkPosition(position);
        actualTurn().playAt(position, this.gameTable, this.turns);
    }

    private void checkPosition(int position) {
        if (position < 1 || position > this.base) {
            throw new RuntimeException("Position out of bounds");
        }
        if (this.gameTable.get(position - 1).size() == this.height) {
            throw new RuntimeException("Column is full");
        }
    }

    private Turns actualTurn() {
        return this.turns.get(this.turns.size() - 1);
    }
}

