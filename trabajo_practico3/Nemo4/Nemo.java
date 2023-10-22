package Nemo;

import java.util.Arrays;

public class Nemo {
    private final ControlCenter controlCenter;
    private final Point point;
    private Orientation orientation;

    public Nemo() {
        this.controlCenter = new ControlCenter();
        this.point = new Point(0, 0, 0);
        this.orientation = new Orientation();
    }

    public int[] position() {
        return controlCenter.getCoordinates(point);
    }

    public int[] heading() {
        return controlCenter.getHeading(orientation);
    }

    public void execute(String command) {
        controlCenter.run(command, this);
    }

    public void ascend() {
        State currentState = controlCenter.getCurrentState(this);
        int changeOfUnits = currentState.unitsToAscend();
        point.updateDepth(changeOfUnits);
        currentState.getAfterAscendRunnable(controlCenter).run();
    }

    public void descend() {
        State currentState = controlCenter.getCurrentState(this);
        int changeOfUnits = currentState.unitsToDescend();
        point.updateDepth(changeOfUnits);
        currentState.descendF(controlCenter).run();
    }

    public void rotateLeft() {
        orientation = orientation.left();
        System.out.println(Arrays.toString(orientation.value()));
    }

    public void rotateRight() {
        orientation = orientation.right();
    }

    public void moveForward() {
        int[] toMove = controlCenter.getHeading(orientation);
        point.updatePosition(toMove);
    }

    public void throwCapsule() {
        State currentState = controlCenter.getCurrentState(this);
        currentState.throwCapsule();
    }
}
