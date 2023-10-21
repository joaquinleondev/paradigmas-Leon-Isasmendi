package Nemo;

public class Point {
    private final int x;
    private final int y;
    private final int z;


    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int depth() {
        return this.z;
    }

    public int[] value() {
        return new int[] {x, y, z};
    }
}
