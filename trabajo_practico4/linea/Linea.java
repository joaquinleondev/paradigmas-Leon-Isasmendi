package linea;

import java.util.ArrayList;

public class Linea {
    private int base;
    private int height;
    private GameMode gameType;
    private ArrayList<ArrayList> gameTable;
    private ArrayList<Turns> turns;

    public Linea(int base, int height, char gameType) {
        this.base = base;
        this.height = height;
        this.gameType = new GameMode(gameType);
        this.gameTable = new ArrayList<>();
        for (int i = 0; i < base; i++) {
            ArrayList<String> row = new ArrayList<>();
            this.gameTable.add(row);
        }
        this.turns = new ArrayList<>();
        this.turns.add(new Red());
    }

    public String show() {
        ArrayList<String> result = new ArrayList<>();
        for (int i = this.height; i > 0; i--) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < this.base; j++) {
                try {
                    row.append(this.gameTable.get(j).get(i));
                } catch (Exception e) {
                    row.append("-");
                } finally {
                    row.append(" ");
                }
            }
            result.add(row.toString());
        }
        return String.join("\n", result);
    }

    public void finished() {

    }

    public void playRedAt(int position) {
        this.turns.add(new Red());
        this.gameTable.get(position).add("R");
    }

    public void playBlueAt(int position) {

    }
}
