package Nemo;

public class Instruction {
    private String value;
    public void executeInstruction(Nemo nemo) throws RuntimeException {
        throw new RuntimeException("Command not found");
    };

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
        state.ascend(nemo)
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

    }
}

class left extends Instruction {
    private static final String value = "l";
    @Override
    public String returnValue() {
        return value;
    }
}

class right extends Instruction {
    private static final String value = "r";
    @Override
    public String returnValue() {
        return value;
    }
}

class forward extends Instruction {
    private static final String value = "f";
    @Override
    public String returnValue() {
        return value;
    }
}

class throwCapsule extends Instruction {
    private static final String value = "m";
    @Override
    public String returnValue() {
        return value;
    }
}
