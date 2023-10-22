package nemo;

public interface Instruction {
    String getCommand();

    void execute(Nemo nemo);
}

class Ascend implements Instruction {
    private static final String COMMAND = "u";

    @Override
    public String getCommand() {
        return COMMAND;
    }

    @Override
    public void execute(Nemo nemo) {
        nemo.ascend();
    }
}

class Descend implements Instruction {
    private static final String COMMAND = "d";

    @Override
    public String getCommand() {
        return COMMAND;
    }

    @Override
    public void execute(Nemo nemo) {
        nemo.descend();
    }
}

class Left implements Instruction {
    private static final String COMMAND = "l";

    @Override
    public String getCommand() {
        return COMMAND;
    }

    @Override
    public void execute(Nemo nemo) {
        nemo.rotateLeft();
    }
}

class Right implements Instruction {
    private static final String COMMAND = "r";

    @Override
    public String getCommand() {
        return COMMAND;
    }

    @Override
    public void execute(Nemo nemo) {
        nemo.rotateRight();
    }
}

class Forward implements Instruction {
    private static final String COMMAND = "f";

    @Override
    public String getCommand() {
        return COMMAND;
    }

    @Override
    public void execute(Nemo nemo) {
        nemo.moveForward();
    }
}

class ThrowCapsule implements Instruction {
    private static final String COMMAND = "m";

    @Override
    public String getCommand() {
        return COMMAND;
    }

    @Override
    public void execute(Nemo nemo) {
        nemo.throwCapsule();
    }
}
