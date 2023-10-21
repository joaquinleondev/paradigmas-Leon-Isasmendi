package Nemo2;

public class ControlCenter {
    Nemo nemo;
    public ControlCenter(Nemo nemo) {
        this.nemo = nemo;
    }
    public int[] getPosition() {
        return nemo.point.position();
    }
    public int[] getHeading() {
        return nemo.orientation.heading();
    }
}
