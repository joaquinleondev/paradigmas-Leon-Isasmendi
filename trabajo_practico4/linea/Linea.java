package linea;

import java.util.ArrayList;

public class Linea {
    private int base;
    private int height;
    private GameMode gameType;
    public final GameTable gameTable;
    private final ArrayList<Turns> turns = new ArrayList<>();
    private final Checker checker = new Checker();
    private ArrayList<Integer> lastPlay = new ArrayList<>();

    public Linea(int base, int height, char gameType) {
        this.base = base;
        this.height = height;
        this.gameType = GameMode.createGameMode(gameType);
        this.gameTable = new GameTable(base, height);
        this.turns.add(new Red());
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
                    row.append(this.gameTable.getFullSlots().get(j).get(i));
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
        return  tied() && someoneWon();
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
    private boolean someoneWon() {
        return checker.isFinished(this.gameType.getPosibleWins(this.gameTable, lastPlay.get(0), lastPlay.get(1)));
    }

    private boolean tied() {
        return base*height == turns.size() - 1;
    }

    private void actualTurnPlaysAt(int position) {
        checkPosition(position);
        lastPlay=gameTable.playAt(position, actualTurn().getValue());
        turns.add(actualTurn().next());
    }

    private void checkPosition(int position) {
        if (position < 1 || position > this.base) {
            throw new RuntimeException("Position out of bounds");
        }
        if (this.gameTable.getFullSlots().get(position - 1).size() == this.height) {
            throw new RuntimeException("Column is full");
        }
    }

    private Turns actualTurn() {
        return this.turns.get(this.turns.size() - 1);
    }

}

