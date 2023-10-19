package Nemo1;

import java.util.Arrays;

public class Nemo {
    CartesianSystem cartesianSystem;
    Orientation orientation;
    SubmarineController submarineController;
    CapsuleThrower capsuleThrower;

    public Nemo() {
        this.cartesianSystem = new CartesianSystem(0, 0, 0);
        this.orientation = new Orientation(0);
        this.submarineController = new SubmarineController(this);
        this.capsuleThrower = new CapsuleThrower(this);
    }

    public void excecuteCommand(String command) {
        Arrays.stream(command.split("")).forEach(instruction -> {
            this.submarineController.execute(instruction);
        });
    }

    public void descend() {
        this.cartesianSystem.descend();
    }

    public void ascend() {
        this.cartesianSystem.ascend();
    }

    public void rotateLeft() {
        this.orientation.rotateLeft();
    }

    public void rotateRight() {
        this.orientation.rotateRight();
    }

    public void moveForward() {
        this.cartesianSystem.moveForward(this.orientation);
    }

    public void throwCapsule() {
        this.capsuleThrower.throwCapsule();
    }
}
