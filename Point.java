package Nemo2;

public class Point {
    public int x;
    public int y;
    public int z;


    public Point() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    public int depth() {
        return this.z;
    }

    public int[] position() {
        return new int[] {x, y, z};
    }

    public void ascend() {
        this.z += 1;
    }
}

class PointSubmerged extends Point {
}

class PointOnSurface extends Point {
}
