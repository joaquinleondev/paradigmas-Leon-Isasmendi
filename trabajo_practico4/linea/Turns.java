package linea;

import java.util.ArrayList;

public abstract class Turns {
    private char value;
    public Turns(char value) {
        this.value = value;
    }
    public char getValue() {
        return value;
    }
    public Turns next() {
        return new None();
        }

    public boolean equals(Turns other) {
        return this.value == other.value;
    }
    public void playAt(int position, ArrayList<ArrayList> gameTable, ArrayList<Turns> turns){
        gameTable.get(position - 1).add(this.getValue());
        turns.add(this.next());
    }

}



class Blue extends Turns {
    public Blue(){
        super('B');
    }
    @Override
    public Turns next() {
        return new Red();
    }


}

class Red extends Turns {
    public Red(){
        super('R');
    }
    @Override
    public Turns next() {
        return new Blue();
    }
}
class None extends Turns {
    public None(){
        super('-');
    }
}


