package Nemo1;

public class CartesianSystem {
    private int x;
    private int y;
    private int z;

    public CartesianSystem(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int depth() {
        return z;
    }

    public int[] position() {
        return new int[]{x, y};
    }

    public float distanceTo(CartesianSystem otherPoint) {
        int[] otherPosition = otherPoint.position();
        int otherX = otherPosition[0];
        int otherY = otherPosition[1];
        int otherZ = otherPoint.depth();
        int xDistance = Math.abs(x - otherX);
        int yDistance = Math.abs(y - otherY);
        int zDistance = Math.abs(z - otherZ);
        return (float) Math.sqrt(xDistance * xDistance + yDistance * yDistance + zDistance * zDistance);
    }

    public void descend() {
        z--;
    }

    public void ascend() {
        z++;
    }

    public void moveForward(Orientation orientation) {

    }
}
