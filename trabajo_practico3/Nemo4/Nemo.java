package Nemo;

public class Nemo {
    private final ControlCenter controlCenter;
    private final Point point;
    private final Orientation orientation;

    public Nemo() {
        this.controlCenter = new ControlCenter();
        this.point = new Point(0, 0, 0);
        this.orientation = new Orientation();
    }

    public int[] position() {
        return this.controlCenter.getCoordinates(this.point);
    }

    public int heading() {
        return this.controlCenter.getHeading(this.orientation);
    }

    public void execute(String command) {
        this.controlCenter.run(command, this);
    }
}
