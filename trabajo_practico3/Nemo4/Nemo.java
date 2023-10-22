package Nemo;

public class Nemo {
    private final ControlCenter controlCenter;
    private final Point point;
    private final Orientation orientation;

    public Nemo() {
        this.controlCenter = new ControlCenter();
        this.point = new Point(0, 0, 0);
        this.orientation = new East();
    }

    public int[] position() {
        return this.controlCenter.getCoordinates(this.point);
    }

    public int[] heading() {
        return this.controlCenter.getHeading(this.orientation);
    }

    public void execute(String command) {
        this.controlCenter.run(command, this);
    }

    public void ascend() {
        State currentState = controlCenter.getCurrentState(this);
        int change = currentState.ascend();
        this.point.updateDepth(change);
        currentState.ascendF(controlCenter).run();
    }

    public void descend() {
        State currentState = controlCenter.getCurrentState(this);
        int change = currentState.descend();
        this.point.updateDepth(change);
        currentState.descendF(controlCenter).run();
    }

    public void rotateLeft() {
        this.orientation.left();
    }

    public void rotateRight() {
        this.orientation.right();
    }

    public void moveForward() {
        int[] toMove = controlCenter.getHeading(this.orientation);
        this.point.updatePosition(toMove);
    }

    public void throwCapsule() {
        State currentState = controlCenter.getCurrentState(this);
        currentState.throwCapsule();
    }
}
