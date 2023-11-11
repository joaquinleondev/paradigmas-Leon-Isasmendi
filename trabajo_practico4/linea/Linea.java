package linea;

import java.util.ArrayList;

public class Linea {
    private int base;
    private int height;
    private GameMode gameType;
    public final ArrayList<ArrayList<Cell>> gameTable;
    private final ArrayList<Turns> turns = new ArrayList<>();
    private final Checker checker = new Checker();
    private ArrayList<Integer> lastPlay = new ArrayList<>();

    public Linea(int base, int height, char gameType) {
        this.base = base;
        this.height = height;
        this.gameType = GameMode.createGameMode(gameType);
        this.gameTable = new ArrayList<>();
        for (int i = 0; i < base; i++) {
            ArrayList<Cell> row = new ArrayList<>();
            for (int j = 0; j < height; j++) {
                row.add(new EmptyCell(i, j));
            }
            this.gameTable.add(row);
        }
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
                row.append(this.gameTable.get(j).get(i));
                row.append(" ");
            }
            row.append("|");
            result.add(row.toString());
        }
        result.add(numberOfColumns.toString());

        return String.join("\n", result);

    }

    public boolean finished() {
        return this.tied() || this.someoneWon();
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
        actualTurnPlaysAt(position);
    }

    private boolean someoneWon() {
        return this.checker.isFinished(this.gameTable, this.gameType, this.actualTurn().next().returnCell(new int[]{0,0}).toString());
    }

    private boolean tied() {
        return base * height == turns.size() - 1;
    }

    private void actualTurnPlaysAt(int position) {
        checkPosition(position);
        ArrayList<Cell> emptyCells = this.gameTable.get(position - 1).stream().filter(cell -> cell.toString().equals(new EmptyCell(0, 0).toString())).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        int[] coordsToUpdate = emptyCells.get(0).getCoordinates();
        this.gameTable.get(coordsToUpdate[0]).set(coordsToUpdate[1], actualTurn().returnCell(coordsToUpdate));
        turns.add(actualTurn().next());
    }

    private void checkPosition(int position) {
        if (position < 1 || position > this.base) {
            throw new RuntimeException("Position out of bounds");
        }
        if (!this.gameTable.get(position - 1).get(this.height - 1).toString().equals(new EmptyCell(0, 0).toString())) {
            throw new RuntimeException("Column is full");
        }

    }

    private Turns actualTurn() {
        return this.turns.get(this.turns.size() - 1);
    }

}

