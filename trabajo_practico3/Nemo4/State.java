package Nemo;

public class State {
    public int unitsToAscend() {
        return 1;
    }

    public Runnable getAfterAscendRunnable(ControlCenter controlCenter) {
        return controlCenter::removeState;
    }

    public int unitsToDescend() {
        return -1;
    }

    public Runnable descendF(ControlCenter controlCenter) {
        return () -> {
            controlCenter.addState(new Submerged());
        };
    }

    public void throwCapsule() {
        System.out.println("Capsule thrown");
    }
}

class OnSurface extends State {
    @Override
    public int unitsToAscend() {
        return 0;
    }

    @Override
    public Runnable getAfterAscendRunnable(ControlCenter controlCenter) {
        return () -> {};
    }
    @Override
    public Runnable descendF(ControlCenter controlCenter) {
        return () -> {
            controlCenter.addState(new SafeDepth());
        };
    }
}

class SafeDepth extends State {

}


class Submerged extends State {
    @Override
    public void throwCapsule() {
        throw new RuntimeException("Nemo is destroyed, capsule cant be thrown from this depth");
    }
}