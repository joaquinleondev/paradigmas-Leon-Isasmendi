package Nemo;

public class Instruction {
    private String value;

    public void executeInstruction(Nemo nemo) throws RuntimeException {
        throw new RuntimeException("Command not found");
    }

    ;

    public String returnValue() {
        return value;
    }
}

class ascend extends Instruction {
    private static final String value = "u";

    @Override
    public String returnValue() {
        return value;
    }

    @Override
    public void executeInstruction(Nemo nemo) {
        nemo.ascend();
    }
}

class descend extends Instruction {
    private static final String value = "d";

    @Override
    public String returnValue() {
        return value;
    }

    @Override
    public void executeInstruction(Nemo nemo) {
        nemo.descend();
    }
}

class left extends Instruction {
    private static final String value = "l";

    @Override
    public String returnValue() {
        return value;
    }

    @Override
    public void executeInstruction(Nemo nemo) {
        nemo.rotateLeft();
    }
}

class right extends Instruction {
    private static final String value = "r";

    @Override
    public String returnValue() {
        return value;
    }

    @Override
    public void executeInstruction(Nemo nemo) {
        nemo.rotateRight();
    }
}

class forward extends Instruction {
    private static final String value = "f";

    @Override
    public String returnValue() {
        return value;
    }

    @Override
    public void executeInstruction(Nemo nemo) {
        nemo.moveForward();
    }
}

class throwCapsule extends Instruction {
    private static final String value = "m";

    @Override
    public String returnValue() {
        return value;
    }

    @Override
    public void executeInstruction(Nemo nemo) {
        nemo.throwCapsule();
    }
}
