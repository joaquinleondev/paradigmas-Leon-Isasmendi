package linea;

import java.util.ArrayList;
import java.util.Arrays;
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



    public ArrayList<ArrayList<Character>> getPosibleWins(GameTable gameTable, int x, int y){
    ArrayList<ArrayList<Character>> result = new ArrayList<>();
        return result;
    }
}
class typeA extends GameMode {
    public typeA() {
        super('A');
    }
    @Override
    public ArrayList<ArrayList<Character>> getPosibleWins(GameTable gameTable, int x, int y){
        ArrayList<ArrayList<Character>> result = new ArrayList<>();
        result.addAll(gameTable.getFullSlots());
        result.addAll(gameTable.getTransposeMatrix());
        return result;
    }


}

class typeB extends GameMode {
    public typeB() {
        super('B');
    }
    @Override
    public ArrayList<ArrayList<Character>> getPosibleWins(GameTable gameTable, int x, int y){
        ArrayList<ArrayList<Character>> result = new ArrayList<>();
        result.addAll(gameTable.getDiagonals(x,y));
        return result;
    }
}

class typeC extends GameMode {
    public typeC() {
        super('C');
    }
    @Override
    public ArrayList<ArrayList<Character>> getPosibleWins(GameTable gameTable, int x, int y){
        ArrayList<ArrayList<Character>> result = new ArrayList<>();
        result.addAll(gameTable.getDiagonals(x,y));
        result.addAll(gameTable.getTransposeMatrix());
        result.addAll(gameTable.getFullSlots());
        return result;
    }
}