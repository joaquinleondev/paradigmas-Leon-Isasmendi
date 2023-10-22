package nemo;

public class Nemo {
    private final ControlCenter controlCenter;
    private final Point point;
    private Orientation orientation;

    public Nemo() {
        this.point = new Point(0, 0, 0);
        this.orientation = new Orientation();
        this.controlCenter = new ControlCenter(this.point, this.orientation);
    }

    public int[] position() {
        return controlCenter.getCoordinates(point);
    }

    public int[] heading() {
        return controlCenter.orientation.value();
    }

    public void execute(String command) {
        controlCenter.run(command, this);
    }

}
