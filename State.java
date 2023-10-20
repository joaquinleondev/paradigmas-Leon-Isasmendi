package Nemo2;

public class State {
    public Point point;
    public State(Point point) {
        this.point = point;

    }
    public void ascend() {
        this.point.z += 1;
    }
    public void throwCapsule() {
    }
}

class OnSurface extends State {
    public OnSurface(Point point) {
        super(point);
    }
    @Override
    public void ascend () {
    }
    @Override
    public void throwCapsule () {
        System.out.println("Capsule thrown");
    }
}
class SafeDepth extends State {
    public SafeDepth(Point point) {
        super(point);
    }
    @Override
    public void throwCapsule () {
        System.out.println("Capsule thrown");
    }
}

class DangerousDepth extends State {
    public DangerousDepth(Point point) {
        super(point);
    }
    @Override
    public void throwCapsule () {
        throw new RuntimeException("Nemo is destroyed, capsule cant be thrown from this depth");
    }

}


