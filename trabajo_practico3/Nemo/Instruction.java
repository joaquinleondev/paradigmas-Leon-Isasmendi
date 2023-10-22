package nemo;

public interface Instruction {
    String getCommand();

    void execute(ControlCenter controlCenter);
}

class Ascend implements Instruction {
    private static final String COMMAND = "u";

    @Override
    public String getCommand() {
        return COMMAND;
    }

    @Override
    public void execute(ControlCenter controlCenter) {
        State currentState = controlCenter.getCurrentState();
        int changeOfUnits = currentState.unitsToAscend();
        controlCenter.point.updateDepth(changeOfUnits);
        currentState.getAfterAscendRunnable(controlCenter).run();
    }
}

class Descend implements Instruction {
    private static final String COMMAND = "d";

    @Override
    public String getCommand() {
        return COMMAND;
    }

    @Override
    public void execute(ControlCenter controlCenter) {
        State currentState = controlCenter.getCurrentState();
        int changeOfUnits = currentState.unitsToDescend();
        controlCenter.point.updateDepth(changeOfUnits);
        currentState.getAfterDescendRunnable(controlCenter).run();;
    }
}

class Left implements Instruction {
    private static final String COMMAND = "l";

    @Override
    public String getCommand() {
        return COMMAND;
    }

    @Override
    public void execute(ControlCenter controlCenter) {
        controlCenter.orientation = controlCenter.orientation.left();
    }
}

class Right implements Instruction {
    private static final String COMMAND = "r";

    @Override
    public String getCommand() {
        return COMMAND;
    }

    @Override
    public void execute(ControlCenter controlCenter) {
        controlCenter.orientation = controlCenter.orientation.right();
    }
}

class Forward implements Instruction {
    private static final String COMMAND = "f";

    @Override
    public String getCommand() {
        return COMMAND;
    }

    @Override
    public void execute(ControlCenter controlCenter) {
        int[] toMove = controlCenter.orientation.value();
        controlCenter.point.updatePosition(toMove);
    }
}

class ThrowCapsule implements Instruction {
    private static final String COMMAND = "m";

    @Override
    public String getCommand() {
        return COMMAND;
    }

    @Override
    public void execute(ControlCenter controlCenter) {
        State currentState = controlCenter.getCurrentState();
        currentState.throwCapsule();
    }
}
