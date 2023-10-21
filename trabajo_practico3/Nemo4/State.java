package Nemo;

abstract class State {
    public Point point;

    public State getActualState() {
        return this.point.depths.get(lastDepthIndex());
    }

    public State() {
    }

    public void ascend() {
        this.point.depths.remove(lastDepthIndex());
        this.point.z += 1;
    }

    public void descend() {
        this.point.depths.add(new DangerousDepth(point));
        this.point.z -= 1;
    }

    public void throwCapsule() {
        System.out.println("Capsule thrown");
    }

    private int lastDepthIndex() {
        return this.point.depths.size() - 1;
    }
}

class OnSurface extends State {
    public OnSurface() {
        super(point);
    }
    @Override
    public void ascend() {
    }

    @Override
    public void descend(Point point) {
        point.depths.add(new SafeDepth(point));
        point.z -= 1;
    }

}

class SafeDepth extends State {
    public SafeDepth(Point point) {
        super(point);
    }
}

class DangerousDepth extends State {
    public DangerousDepth(Point point) {
        super(point);
    }

    @Override
    public void throwCapsule() {
        throw new RuntimeException("Nemo is destroyed, capsule cant be thrown from this depth");
    }

}