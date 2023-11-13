package linea;

import java.util.ArrayList;

public class Graphics {
    public static String show(ArrayList<ArrayList<Cell>> gameTable, Turns turn, boolean someoneWon, boolean tied) {
        StringBuilder result = new StringBuilder();
        result.append("Tablero 4 en linea\n");
        result.append("| ");
        for (int i = 0; i < gameTable.size(); i++) {
            result.append(i + 1).append(" ");
        }
        result.append("|\n");

        for (int i = gameTable.get(0).size() - 1; i >= 0; i--) {
            result.append("| ");
            for (int j = 0; j < gameTable.size(); j++) {
                result.append(gameTable.get(j).get(i)).append(" ");
            }
            result.append("|\n");
        }
        if(someoneWon){
            result.append("Gano ").append(turn).append("!");
        }else if(tied){
            result.append("Empate!");
        }


        return result.toString();
    }
}
