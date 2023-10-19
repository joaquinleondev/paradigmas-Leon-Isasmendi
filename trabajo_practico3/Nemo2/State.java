package Nemo2;

public class State {

}

class SubmergedLvl1 extends State {
    public int depth() {
        return 1;
    }
}

class SubmergedLvl2 extends State {
    public int depth() {
        return 2;
    }
}

class OnSurface extends State {
    public int depth() {
        return 3;
    }
}
