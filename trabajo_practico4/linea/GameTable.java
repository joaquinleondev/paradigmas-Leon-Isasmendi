package linea;

import java.util.ArrayList;

public class GameTable {
    private int base;
    private int height;
    private final ArrayList<ArrayList<Character>> fullSlots = new ArrayList<>();
    private final ArrayList<ArrayList<Character>> emptySlots = new ArrayList<ArrayList<Character>>();
    public GameTable(int base, int height){
        this.base = base;
        this.height = height;
        for (int i = 0; i < base; i++) {
            ArrayList<Character> row = new ArrayList<>();
            this.fullSlots.add(row);
        }
        for (int i = 0; i < base; i++) {
            ArrayList<Character> row = new ArrayList<>();
            for (int j = 0; j < height; j++) {
                row.add('-');
            }
            this.emptySlots.add(row);
        }
    }
    public ArrayList<ArrayList<Character>> getFullSlots() {
        return fullSlots;
    }
    public ArrayList<ArrayList<Character>> getEmptySlots() {
        return emptySlots;
    }
    public ArrayList<Integer> playAt(int position, char value){
        fullSlots.get(position - 1).add(value);
        emptySlots.get(position - 1).remove(0);
        ArrayList<Integer> result = new ArrayList<>();
        result.add(position - 1);
        result.add(fullSlots.get(position - 1).size() - 1);
        return result;
    }
    public ArrayList<ArrayList<Character>> getFullMatrix() {

        ArrayList<ArrayList<Character>> result = new ArrayList<>();
        for (int i = 0; i < base; i++) {

            ArrayList<Character> row = new ArrayList<>();
            row.addAll(fullSlots.get(i));
            row.addAll(emptySlots.get(i));
            result.add(row);
        }
        return result;
    }
    public ArrayList<ArrayList<Character>> getTransposeMatrix() {
        ArrayList<ArrayList<Character>> matrix = getFullMatrix();
        ArrayList<ArrayList<Character>> result = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            ArrayList<Character> row = new ArrayList<>();
            for (int j = 0; j < base; j++) {
                row.add(matrix.get(j).get(i));
            }
            result.add(row);
        }
        return result;
    }
    public ArrayList<ArrayList<Character>> expandMatrix(){
    ArrayList<Character> toExpand= new ArrayList<>();
    for (int i = 0; i < 3 ; i++) {
        toExpand.add('-');
    }
    ArrayList<ArrayList<Character>> matrix = getFullMatrix();
    matrix.forEach((row) -> {
        row.addAll(toExpand);
        row.addAll(0, toExpand);
    });
    for (int i = 0; i < 3; i++) {
        ArrayList<Character> row = new ArrayList<>();
        for (int j = 0; j < matrix.get(0).size(); j++) {
            row.add('-');
        }
        matrix.add(row);
        matrix.add(0, row);
    }
    return matrix;
    }
public ArrayList<ArrayList<Character>> getDiagonals (int x , int y){
    ArrayList<ArrayList<Character>> matrix = expandMatrix();
    ArrayList<ArrayList<Character>> result = new ArrayList<>();
    result.add(new ArrayList<>());
    result.add(new ArrayList<>());
    int i =x;
    int j =y;
    int k =y + 6;
    while (i <= x+6 && j <= y+6){
        result.get(0).add(matrix.get(i).get(j));
        result.get(1).add(matrix.get(i).get(k));
        i++;
        j++;
        k--;
    }
    return result;

}
}

















