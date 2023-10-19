package Nemo2;

public class Nemo {
    NavigationSystem navigationSystem;
    Point point;
    ControlCenter controlCenter;
    Orientation orientation;
    State state;

    public Nemo() {
        this.navigationSystem = new NavigationSystem(this);
        this.point = new Point();
        this.controlCenter = new ControlCenter(this);
        this.orientation = new Orientation();
        this.state = new State();
    }

}
