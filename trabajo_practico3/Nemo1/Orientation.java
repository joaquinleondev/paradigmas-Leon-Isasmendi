package Nemo1;

public class Orientation {
    private int heading;
    public Orientation( int headingToUpdate ) {
        this.heading = headingToUpdate;
    }
    public int heading() {
        return heading;
    }

    public void rotateLeft() {
        this.heading = (this.heading + 90) % 360;
    }

    public void rotateRight() {
        this.heading = (this.heading - 90) % 360;
    }
}
