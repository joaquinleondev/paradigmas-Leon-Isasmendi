package Nemo2;

abstract class Orientation {
    int[] orientation = new int[]{0, 1};
    public Orientation() {
        ;
    }
    public int[] heading() { return this.orientation; }

}
class North extends Orientation {
    int[] orientation = new int[]{0, 1};
    public North() {

    }
    public void left () {
        this.orientation = new int[]{-1, 0};
    }
    public void right () {
        this.orientation = new int[]{1, 0};
    }

}
class South extends Orientation{
    int[] orientation = new int[]{0, -1};

    public South(int[] orientation) {
        super(orientation);
    }

}
