package Nemo2;

import java.util.ArrayList;

public class Point {
    public int x;
    public int y;
    public int z;
    public ArrayList<State> depths = new ArrayList<State>();


    public Point() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        depths.add(new OnSurface(this));
    }

    public int depth() {
        return this.z;
    }
    public State getActualState() {
        return this.depths.get(lastDepthIndex());
    }
    private int lastDepthIndex() {
        return this.depths.size() - 1;
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
