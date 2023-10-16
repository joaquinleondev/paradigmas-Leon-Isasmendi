package Nemo;


import java.util.Arrays;

public class Nemo {
    Integer[] position = {0, 0, 0};
    Integer heading = 0;

    public Integer[] getPosition () {
        return this.position;
    }

    public Integer getHeading () {
        return this.heading;
    }

    private void ascend () {
        if (!(this.position[2] == 0)) {
            this.position[2] += 1;
        }
    }

    private void descend () {
        this.position[2] -= 1;
    }

    private void left () {
        if (this.heading == 270) {
            this.heading = 0;
        } else {
            this.heading += 90;
        }
    }

    private void right () {
        if (this.heading == 0) {
            this.heading = 270;
        } else {
            this.heading -= 90;
        }
    }

    private void moveForward () {
        if (this.heading == 0) {
            this.position[0] += 1;
        } else if (this.heading == 90) {
            this.position[1] += 1;
        } else if (this.heading == 180) {
            this.position[0] -= 1;
        } else if (this.heading == 270) {
            this.position[1] -= 1;
        }
    }

    private void throwCapsule () throws RuntimeException {
        if (this.position[2] < -1) {
            throw new RuntimeException("Nemo is destroyed, capsule cant be thrown from this depth");
        }
    }

    public void executeCommand (String command) {
        Arrays.stream(command.split("")).forEach((instruction) -> {
            switch (instruction) {
                case "u" -> this.ascend();
                case "d" -> this.descend();
                case "l" -> this.left();
                case "r" -> this.right();
                case "f" -> this.moveForward();
                case "m" -> this.throwCapsule();
            }
        });
    }
}