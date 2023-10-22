package Nemo;

public class Point {
    private int x;
    private int y;
    private int z;


    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int depth() {
        return this.z;
    }

    public int[] value() {
        return new int[]{x, y, z};
    }

    public void updateDepth(int change) {
        this.z += change;
    }

    public void updatePosition(int[] newPosition) {
        this.x += newPosition[0];
        this.y += newPosition[1];
    }
}